/**
 * This class represents a query that returned a result.
 */
class QueryResult {
    final int id;
    final String queryString;
    final int columnCount;
    final int rowCount;
    final String content;
    final String table;
    private boolean hidden;

    QueryResult(int id, String queryString, int columnCount, int rowCount, String content, String table) {
        this.id = id;
        this.queryString = queryString;
        this.columnCount = columnCount;
        this.rowCount = rowCount;
        this.content = content;
        this.table = table;
    }

    boolean isHidden() {
        return hidden;
    }

    void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
