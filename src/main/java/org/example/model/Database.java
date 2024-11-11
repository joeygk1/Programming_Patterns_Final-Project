package org.example.model;
// "jdbc:sqlite:./src/main/resources/database/data.db";
import java.sql.*;

public class Database {
    private static final String URL = "jdbc:sqlite:./src/main/resources/database/data.db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

