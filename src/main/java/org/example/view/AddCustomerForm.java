package org.example.view;

import org.example.model.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerForm extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JButton saveButton;

    public AddCustomerForm() {
        setTitle("Add New Customer");
        setSize(400, 300);
        setLocationRelativeTo(null);

        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        emailField = new JTextField(20);
        phoneField = new JTextField(20);
        saveButton = new JButton("Save");

        setLayout(new GridLayout(5, 2));
        add(new JLabel("First Name:"));
        add(firstNameField);
        add(new JLabel("Last Name:"));
        add(lastNameField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Phone:"));
        add(phoneField);
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve input fields from the form
                String name = firstNameField.getText() + " " + lastNameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();

                // Add the customer to the database
                Database.addCustomer(name, email, phone);

                // Close the form after saving
                JOptionPane.showMessageDialog(null, "Customer saved successfully!");
                dispose(); // Close the form
            }
        });
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getPhoneField() {
        return phoneField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}
