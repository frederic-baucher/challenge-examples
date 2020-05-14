import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * Database Query comparator.
 */
class DBComparator {

    private static final String DRIVER = "db.driver";
    private static final String HOST = "db.host";
    private static final String PORT = "db.port";
    private static final String DB_NAME = "db.name";
    private static final String USER = "db.user";
    private static final String PASSWORD = "db.password";
    private static final String EXPECTED_QUERY_PATH = "query.expected.path";
    private static final String TEST_QUERY_PATH = "query.test.path";
    private static final String COMPARISON_QUERY_PATH = "query.compare.path";

    private Properties props;
    private boolean comparisonEnabled;
    private boolean writeOnly;

    DBComparator(boolean isSolve) {
        props = new Properties();
        // Load properties
        try (final InputStream stream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("db.properties")) {
            props.load(stream);
        } catch (IOException e) {
            throw new IllegalStateException("Error while loading properties. Please check your db properties are fine");
        }
        // Load driver
        try {
            Class.forName(props.getProperty(DRIVER));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Driver not supported: " + props.getProperty(DRIVER));
        }
        // Check if comparison enabled
        comparisonEnabled = isSolve;
        writeOnly = Files.exists(getComparisonQueryFile());
    }

    private Connection getConnection() {
        try {
            Connection c = DriverManager.getConnection(props.getProperty(HOST) + ":" + props.getProperty(PORT) + "/" + props.getProperty(DB_NAME), props.getProperty(USER), props.getProperty(PASSWORD));
            c.setAutoCommit(false); // Force to disable auto commit
            return c;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to remote database", e);
        }
    }

    void compare() {
        if (!Files.exists(getExpectedQueryFile())) {
            throw new IllegalStateException("Expected query file cannot be found. Please check your db properties are fine");
        }
        if (!Files.exists(getTestQueryFile())) {
            throw new IllegalStateException("Test query file cannot be found. Please check your db properties are fine");
        }

        try {
            // Get user query result content
            List<QueryResult> testResults = runTarget();

            if (comparisonEnabled) {
                // Get expected content
                List<QueryResult> expectedResults = runExpected();

                if (expectedResults.size() > 1) {
                    compareEach(expectedResults, testResults);
                } else if (expectedResults.size() == 1 && !testResults.isEmpty()) {
                    compareOne(expectedResults.get(0), testResults.get(testResults.size() - 1));
                } else {
                    throw new IllegalStateException("You must make at least one SELECT query.");
                }
                print(System.out, "Everything went well!");

            } else
                System.out.println("Done");
        } catch (IllegalStateException | IOException | SQLException e) {
            print(System.err, e.getMessage());
            System.exit(1);
        }
    }

    private void compareOne(QueryResult expectedResult, QueryResult testResult) {
        if (expectedResult.columnCount != testResult.columnCount) {
            throwError("Wrong column count in SELECT statement results.", testResult, expectedResult.columnCount, testResult.columnCount);
        }
        if (expectedResult.rowCount != testResult.rowCount) {
            throwError("Wrong row count in SELECT statement results.", testResult, expectedResult.rowCount, testResult.rowCount);
        }
        if (!expectedResult.content.equals(testResult.content)) {
            throwError("The result content don't match.");
        }
    }

    private void compareEach(List<QueryResult> expectedResults, List<QueryResult> testResults) {
        if (expectedResults.size() != testResults.size()) {
            throwError("Your count of SELECT queries is not what is expected.", expectedResults.size(), testResults.size());
        }
        for (int i = 0; i < expectedResults.size(); i++) {
            compareOne(expectedResults.get(i), testResults.get(i));
        }
    }

    private void print(PrintStream printStream, String... messages) {
        List<String[]> lmessages = Arrays.stream(messages)
                .map(message -> message.replace("\r", "")
                        .split("\n"))
                .collect(Collectors.toList());

        int length = lmessages.stream()
                .flatMap(Arrays::stream)
                .mapToInt(String::length)
                .max()
                .orElse(0);

        String separator = "==" + StringUtils.leftPad("", length, "=") + "==";
        printStream.println(separator);
        lmessages.forEach(message -> Arrays.stream(message)
                .forEach(m -> printStream.println("| " + StringUtils.rightPad(m, length) + " |")));
        printStream.println(separator);
        printStream.close();
    }

    private void throwError(String message) {
        print(System.err, "An error occurred: " + message);
        throw new IllegalStateException(message);
    }

    private void throwError(String message, Object expectedContent, Object foundContent) {
        print(System.err, "An error occurred: " + message,
                "Expected: " + expectedContent,
                "Actual: " + foundContent);

        throw new IllegalStateException(message);
    }

    private void throwError(String message, QueryResult found, Object expectedContent, Object foundContent) {
        if (found.isHidden()) throwError(message);
        else {
            print(System.err, "An error occurred: " + message,
                    "Query id: " + found.id,
                    "Query: " + found.queryString,
                    "Expected: " + expectedContent,
                    "Actual: " + foundContent);

            throw new IllegalStateException(message);
        }
    }

    private List<QueryResult> runExpected() throws IOException, SQLException {
        return run(getExpectedQueryFile(), false);
    }

    private List<QueryResult> runTarget() throws IOException, SQLException {
        return run(getTestQueryFile(), true);
    }

    private List<QueryResult> run(Path pathFile, boolean show) throws SQLException, IOException {
        try (Connection conn = getConnection()) {
            ScriptRunner scriptRunner = new ScriptRunner(conn);
            scriptRunner.runScript(pathFile, show);
            if (writeOnly) {
                scriptRunner.clearResults();
                scriptRunner.runScript(getComparisonQueryFile(), false);
            }
            conn.rollback();
            return scriptRunner.getResults();
        }
    }

    private Path getExpectedQueryFile() {
        return Paths.get(props.getProperty(EXPECTED_QUERY_PATH));
    }

    private Path getTestQueryFile() {
        return Paths.get(props.getProperty(TEST_QUERY_PATH));
    }

    private Path getComparisonQueryFile() {
        return Paths.get(props.getProperty(COMPARISON_QUERY_PATH));
    }
}