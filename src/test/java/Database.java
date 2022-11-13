import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    static void create() throws SQLException {
        query("CREATE TABLE IF NOT EXISTS PRODUCT" +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " PRICE          INT     NOT NULL)");
    }

    static void add(String name, String price) throws SQLException {
        query("INSERT INTO PRODUCT" +
                "(NAME, PRICE) VALUES (\"" + name + "\", " + price + ")");
    }

    static void clear() throws SQLException {
        query("DELETE FROM PRODUCT");
    }

    static void query(String sql) throws SQLException {
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:test.db")) {
            Statement stmt = c.createStatement();

            stmt.executeUpdate(sql);
            stmt.close();
        }
    }

}
