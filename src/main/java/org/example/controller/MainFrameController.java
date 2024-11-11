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

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (name, email) VALUES (?, ?)";

        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.executeUpdate();
            System.out.println("Customer added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding customer: " + e.getMessage());
        }
    }

    public void bookFlightAndHotel(Customer customer, Flight flight, Hotel hotel) {
        String insertBookingSQL = "INSERT INTO Booking (customerId, flightId, hotelId) VALUES (?, ?, ?)";
        int customerId = getCustomerId(customer.getEmail()); // Helper method to retrieve customer ID
        int flightId = flight.getFlightId();
        int hotelId = hotel.getHotelId();

        if (customerId == -1) {
            System.out.println("Customer not found.");
            return;
        }

        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(insertBookingSQL)) {
            stmt.setInt(1, customerId);
            stmt.setInt(2, flightId);
            stmt.setInt(3, hotelId);
            stmt.executeUpdate();
            System.out.println("Booking completed successfully.");
        } catch (SQLException e) {
            System.out.println("Error booking flight and hotel: " + e.getMessage());
        }
    }

    // Helper method to get Customer ID by email
    private int getCustomerId(String email) {
        String sql = "SELECT id FROM Customer WHERE email = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving customer ID: " + e.getMessage());
        }
        return -1; // Return -1 if customer is not found
    }
}

