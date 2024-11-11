package org.example.view;

import javax.swing.*;
import java.awt.*;

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

