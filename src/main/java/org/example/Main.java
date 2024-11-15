package org.example;

import org.example.controller.MainFrameController;
import org.example.model.Database;
import org.example.view.MainFrame;

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
    }
}