import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Tool to run database scripts
 */
class ScriptRunner {

    private static final String DELIMITER = ";";
    private static final int MAX_LINE_TO_PRINT = 100;

    private Connection connection;

    private PrintWriter logWriter;
    private PrintWriter errorLogWriter;

    private List<QueryResult> results;

    /**
     * Default constructor
     */
    ScriptRunner(Connection connection) {
        this.connection = connection;
        this.results = new LinkedList<>();
        this.logWriter = new PrintWriter(System.out);
        this.errorLogWriter = new PrintWriter(System.err);
    }

    /**
     * Runs an SQL script
     *
     * @param path - the path of the script source file
     * @param show - print the result or not
     * @throws SQLException - if any SQL errors occur
     * @throws IOException  - if any file errors occur
     */
    void runScript(Path path, boolean show) throws SQLException, IOException {
        runScript(connection, path, show);
    }

    /**
     * Runs an SQL script (read in using the Reader parameter) using the connection passed in
     *
     * @param conn - the connection to use for the script
     * @param path - the path of the script source file
     * @param show - print the result or not
     * @throws IOException  - if any file errors occur
     * @throws SQLException - if any SQL errors occur
     */
    private void runScript(Connection conn, Path path, boolean show) throws IOException, SQLException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path.toFile()))) {

            // reads the whole file and deletes all comments
            String content = removeComment(bufferedReader.lines()
                    .collect(Collectors.joining("\r\n")));

            // extract all SQL command
            List<String> commands = Arrays.stream(content.split(DELIMITER))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());

            for (int queryId = 0; queryId < commands.size(); queryId++) {
                String command = commands.get(queryId);

                Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                boolean hasResults = statement.execute(command);
                ResultSet rs = statement.getResultSet();
                if (hasResults && rs != null) {

                    // ------------ extract all column names and init the max length of each column ------------ //
                    ResultSetMetaData md = rs.getMetaData();
                    int cols = md.getColumnCount();
                    List<String[]> result = new ArrayList<>(); // List with all rows

                    int[] lengthColumn = new int[cols];
                    String[] lineResult = new String[cols];
                    for (int i = 0; i < cols; i++) {
                        String name = md.getColumnLabel(i + 1);
                        lengthColumn[i] = name.length();
                        lineResult[i] = name;
                    }
                    result.add(lineResult);
                    // ----------------------------------------------------------------------------------------- //

                    // ----------------------------------- extract all rows ------------------------------------ //
                    int count = 0; // number of rows counter
                    while (rs.next()) {
                        lineResult = new String[cols];
                        for (int i = 0; i < cols; i++) {
                            String value = rs.getString(i + 1);
                            value = value == null ? "null" : value.replaceAll("\r", "")
                                    .replaceAll("\n", "");

                            // updates the maximum length of the column if its length is longer (for the first MAX_LINE_TO_PRINT rows)
                            if (count < MAX_LINE_TO_PRINT && value.length() > lengthColumn[i])
                                lengthColumn[i] = value.length();
                            lineResult[i] = value;
                        }
                        result.add(lineResult);
                        count++;
                    }
                    // ----------------------------------------------------------------------------------------- //

                    // -- creation of the table result to be displayed from the first MAX_LINE_TO_PRINT lines -- //
                    StringBuilder resultToPrint = new StringBuilder();
                    int length = 4 + (cols - 1) * 3 + Arrays.stream(lengthColumn)
                            .sum(); // calculation of the length of the table result
                    String separator = StringUtils.leftPad("", length, "-");
                    int nbLine = count <= MAX_LINE_TO_PRINT ? count : MAX_LINE_TO_PRINT;
                    for (int l = 0; l <= nbLine; l++) {
                        if (l == 1)
                            resultToPrint.append(separator)
                                    .append("\r\n");
                        resultToPrint.append("| ");
                        String[] r = result.get(l);
                        for (int i = 0; i < cols; i++) {
                            String s = r[i];
                            resultToPrint.append(StringUtils.leftPad(s, lengthColumn[i]))
                                    .append(" | ");
                        }
                        resultToPrint.append("\r\n");
                    }
                    // ----------------------------------------------------------------------------------------- //

                    // ----------------------- display the table result if show is true ------------------------ //
                    if (show) {
                        println("\r\n-> Query " + (queryId + 1));
                        println(command);
                        println(separator);
                        print(resultToPrint.toString());
                        if (count > MAX_LINE_TO_PRINT) println("[More Entries Hidden]");
                        println(separator);
                        println("Returned " + count + " rows with " + cols + " columns.");
                    }
                    // ----------------------------------------------------------------------------------------- //

                    // ------------------------------- creation of query result -------------------------------- //
                    String resultContent = result.stream()
                            .map(r -> StringUtils.join(r, ""))
                            .collect(Collectors.joining(""));
                    QueryResult queryResult = new QueryResult(queryId + 1, command, cols, count, resultContent, resultToPrint.toString());
                    if (!show)
                        queryResult.setHidden(true);
                    results.add(queryResult);
                    // ----------------------------------------------------------------------------------------- //
                } else {
                    if (show) {
                        String commandLowerCase = command.toLowerCase();
                        String out = commandLowerCase.startsWith("select") && commandLowerCase.contains("into") ?
                                "Returned " + statement.getUpdateCount() + " rows saved into a temporary table." :
                                "Updated " + statement.getUpdateCount() + " rows.";
                        println("\r\n-> Query " + (queryId + 1));
                        println(command);
                        println(StringUtils.leftPad("", out.length(), "-"));
                        println(out);
                    }
                }
                statement.close();
                flush();
            }
        }
    }

    private String removeComment(String content) {
        String out = content;
        int indexStart;
        int indexEnd;
        boolean terminated = false;
        while (!terminated) {
            terminated = true;
            if ((indexStart = out.indexOf("/*")) > -1 && (indexEnd = out.indexOf("*/")) > -1) {
                out = out.replace(out.substring(indexStart, indexEnd + 2), "");
                terminated = false;
            }
            if ((indexStart = out.indexOf("--")) > -1) {
                indexEnd = out.indexOf('\n', indexStart);
                if (indexEnd < 0)
                    indexEnd = out.length();
                out = out.replace(out.substring(indexStart, indexEnd), "");
                terminated = false;
            }
        }
        return out;
    }

    private void print(Object o) {
        if (logWriter != null) {
            logWriter.print(o);
        }
    }

    private void println(Object o) {
        if (logWriter != null) {
            logWriter.println(o);
        }
    }

    private void printlnError(Object o) {
        if (errorLogWriter != null) {
            errorLogWriter.println(o);
        }
    }

    private void flush() {
        if (logWriter != null) {
            logWriter.flush();
        }
        if (errorLogWriter != null) {
            errorLogWriter.flush();
        }
    }

    List<QueryResult> getResults() {
        return results;
    }

    void clearResults() {
        results.clear();
    }
}