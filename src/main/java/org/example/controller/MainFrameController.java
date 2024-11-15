package org.example.controller;

import org.example.model.*;
import org.example.view.AddCustomerForm;
import org.example.view.MainFrame;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainFrameController {
    private Database database;

    public MainFrameController() {
        // Initialize the database connection
        this.database = new Database();
    }

    /**
     * This method inserts a new record into the "Customer" Table with the customer's name and email.
     * If there is an error with the database an error message will be printed
     * @param customer to GET their Name and Email
     */
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (name, email) VALUES (?, ?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.executeUpdate();
            System.out.println("Customer added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding customer: " + e.getMessage());
        }
    }

    /**
     * This method inserts a new record into "Booking" Table with the customer's id, flight's id and hotel's id
     * @param customer
     * @param flight
     * @param hotel
     */
    public void bookFlightAndHotel(Customer customer, Flight flight, Hotel hotel) {
        String insertBookingSQL = "INSERT INTO Booking (customerId, flightId, hotelId) VALUES (?, ?, ?)";

        int customerId = getCustomerId(customer.getEmail()); // Helper method to retrieve customer ID
        int flightId = flight.getFlightId();
        int hotelId = hotel.getHotelId();

        if (customerId == -1) { //if customer not found
            System.out.println("Customer not found.");
            return;
        }

        try (Connection connection = Database.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertBookingSQL)) {
            preparedStatement.setInt(1, customerId);
            preparedStatement.setInt(2, flightId);
            preparedStatement.setInt(3, hotelId);
            preparedStatement.executeUpdate();
            System.out.println("Booking completed successfully.");
        } catch (SQLException e) {
            System.out.println("Error booking flight and hotel: " + e.getMessage());
        }
    }

    /**
     * This is a helper method that GETs the CustomerId based on their email
     * sql
     * @param email
     * @return
     */
    private int getCustomerId(String email) {
        String sql = "SELECT id FROM Customer WHERE email = ?";

        try (Connection connection = Database.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving customer ID: " + e.getMessage());
        }
        return -1; // Return -1 if customer is not found
    }
}

