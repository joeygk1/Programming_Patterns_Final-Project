package org.example;

import org.example.controller.MainFrameController;
import org.example.model.Database;
import org.example.model.Flight;
import org.example.view.MainFrame;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        initializeDatabase();
        MainFrameController controller = new MainFrameController();
        new MainFrame(controller);
    }

    public static void initializeDatabase() {
        Database.createCustomerTable();
        Database.createFlightTable();
        Database.createHotelTable();
        Database.createBookingTable();

        // Add sample data
        Database.addCustomer("Joey", "joey@example.com", "123-456-7890");
        Database.addFlight("AA123", "2024-12-10 10:00", "2024-12-10 14:00");
        Database.addHotel("Grand Hotel", "New York");
        Database.addBooking(1, 1, 1); // Assuming customer, flight, and hotel IDs are 1

        // Print out flights to test retrieval
        List<Flight> flights = Database.getFlights();
        for (Flight flight : flights) {
            // Print origin and destination instead of flightNumber
            System.out.println("Flight from " + flight.getOrigin() + " to " + flight.getDestination());
        }
    }
}