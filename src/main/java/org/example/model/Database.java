package org.example.model;
// "jdbc:sqlite:./src/main/resources/database/data.db";
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully");
            return connection;
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            throw e;
        }
    }

    public static List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM Flight";
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Flight flight = new Flight(
                        resultSet.getInt("id"),
                        resultSet.getString("origin"),           // Fetching 'origin' column
                        resultSet.getString("destination"),      // Fetching 'destination' column
                        resultSet.getString("departureDate")    // Fetching 'departureDate' column
                );
                flights.add(flight);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving flights: " + e.getMessage());
        }
        return flights;
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
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            // Execute the SQL statement to create the table
            statement.executeUpdate(createTableSQL);
            System.out.println("Customer table created or already exists.");

        } catch (SQLException e) {
            System.out.println("Error creating Customer table: " + e.getMessage());
        }
    }

    public static void addFlight(String flightNumber, String departureTime, String arrivalTime) {
        String insertSQL = "INSERT INTO Flight (flightNumber, departureTime, arrivalTime) VALUES (?, ?, ?)";
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, flightNumber);
            preparedStatement.setString(2, departureTime);
            preparedStatement.setString(3, arrivalTime);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Flight added successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting flight: " + e.getMessage());
        }
    }

    public static void addHotel(String name, String location) {
        String insertSQL = "INSERT INTO Hotel (name, location) VALUES (?, ?)";
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, location);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Hotel added successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting hotel: " + e.getMessage());
        }
    }

    public static void addBooking(int customerId, int flightId, int hotelId) {
        String insertSQL = "INSERT INTO Booking (customerId, flightId, hotelId) VALUES (?, ?, ?)";
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setInt(1, customerId);
            preparedStatement.setInt(2, flightId);
            preparedStatement.setInt(3, hotelId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Booking added successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting booking: " + e.getMessage());
        }
    }

    /**
     * Creates the "Flight" table in the database
     */
    public static void createFlightTable() {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS Flight (
            id INTEGER PRIMARY KEY,
            origin TEXT NOT NULL,
            destination TEXT NOT NULL,
            departureDate TEXT NOT NULL           
                """;

        try(Connection connection = Database.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
            System.out.println("Flight table created successfully");
        } catch (SQLException e) {
            System.out.println("Error creating Flight table: " + e.getMessage());
        }
    }

    public static void addCustomer(String name, String email, String phone) {
        String insertSQL = "INSERT INTO Customer (name, email, phone) VALUES (?, ?, ?)";
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer added successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting customer: " + e.getMessage());
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
