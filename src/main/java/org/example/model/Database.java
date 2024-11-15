package org.example.model;
// "jdbc:sqlite:./src/main/resources/database/data.db";
import javax.xml.crypto.Data;
import java.sql.*;

public class Database {
    private static final String URL = "jdbc:sqlite:./src/main/resources/database/data.db";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public Database() {}

    /**
     * Creates a connection to the database using (URL,USER,PASSWORD)
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Creates the "Customer" table in the database
     */
    public static void createCustomerTable() {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS Customer ( 
            id INTEGER PRIMARY KEY,
            name TEXT NOT NULL,
            email TEXT NOT NULL
            );
            """;
    }

    /**
     * Creates the "Flight" table in the database
     */
    public static void createFlightTable() {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS Flight ( 
            id INTEGER PRIMARY KEY,
            flightNumber TEXT NOT NULL, 
            departureTime TEXT NOT NULL,
            arrivalTime TEXT NOT NULL
            );
                """;

        try(Connection connection = Database.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Flight table created successfully");
        } catch (SQLException e) {
            System.out.println("Error creating Flight table: " + e.getMessage());
        }
    }

    /**
     * Creates the "Hotel" Table in the database
     */
    public static void createHotelTable() {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS Hotel ( 
            id INTEGER PRIMARY KEY,
            name TEXT NOT NULL,
            location TEXT NOT NULL
            ); 
                """;

        try(Connection connection = Database.getConnection();
        Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            System.out.println("Error creating Hotel table: " + e.getMessage());
        }
    }

    /**
     * Creates the "Booking" table in the database
     */
    public static void createBookingTable() {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS Booking ( 
                bookingId INTEGER PRIMARY KEY,
                customerId INTEGER NOT NULL,
                flightId INTEGER NOT NULL,
                hotelId INTEGER NOT NULL,
                FOREIGN KEY (customerId) REFERENCES Customer(id)
                FOREIGN KEY (flightId) REFERENCES Flight(id)
                FOREIGN KEY (hotelId) REFERENCES Hotel(id)
                );
                """;

        try (Connection connection = Database.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            System.out.println("Error Creating booking table: " + e.getMessage());
        }
    }
}

