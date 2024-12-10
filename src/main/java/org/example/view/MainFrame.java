package org.example.view;

import org.example.controller.MainFrameController;
import org.example.model.Database;
import org.example.model.Flight;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private MainFrameController controller;

    public MainFrame(MainFrameController controller) {
        this.controller = controller;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Travel Agency System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Customer Name:");
        userLabel.setBounds(10, 20, 120, 25);
        panel.add(userLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(150, 20, 165, 25);
        panel.add(nameText);

        // Fetching flights from the database
        List<Flight> flights = Database.getFlights(); // Fetch data from DB

// Example of populating a combo box with flight origin and destination
        JComboBox<String> flightComboBox = new JComboBox<>();
        for (Flight flight : flights) {
            // Combine origin and destination as the display string
            String flightInfo = flight.getOrigin() + " to " + flight.getDestination();
            flightComboBox.addItem(flightInfo);
        }
        panel.add(flightComboBox);

        flightComboBox.setBounds(150, 60, 165, 25);  // Adjust the position and size of the combo box
        panel.add(flightComboBox);

        JButton bookButton = new JButton("Book");
        bookButton.setBounds(10, 100, 150, 25);
        panel.add(bookButton);

        bookButton.addActionListener(e -> {
            // You can add actions when the button is clicked, e.g., opening a new form
            AddCustomerForm addCustomerForm = new AddCustomerForm();
            addCustomerForm.setVisible(true);
        });
    }
}
