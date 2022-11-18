package ru.akirakozov.sd.refactoring.database;

public class Database {


    public static String maxQuery() {
        return "SELECT * FROM PRODUCT ORDER BY PRICE DESC LIMIT 1";
    }

    public static String minQuery() {
        return "SELECT * FROM PRODUCT ORDER BY PRICE LIMIT 1";
    }

    public static String sumQuery() {
        return "SELECT SUM(price) FROM PRODUCT";
    }

    public static String countQuery() {
        return "SELECT COUNT(*) FROM PRODUCT";
    }

    public static String getQuery() {
        return "SELECT * FROM PRODUCT";
    }

    public static String insertQuery(String name, long price) {
        return "INSERT INTO PRODUCT (NAME, PRICE) VALUES (\"" + name + "\"," + price + ")";
    }

    public static String createQuery() {
        return "CREATE TABLE IF NOT EXISTS PRODUCT" +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " PRICE          INT     NOT NULL)";
    }
}
