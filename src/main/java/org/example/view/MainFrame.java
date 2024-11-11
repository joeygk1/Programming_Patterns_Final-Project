package org.example.view;

import org.example.controller.MainFrameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JButton bookButton = new JButton("Book");
        bookButton.setBounds(10, 80, 150, 25);
        panel.add(bookButton);

        bookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Placeholder: You could gather data from the UI and pass it to the controller
                JOptionPane.showMessageDialog(panel, "Booking Completed!");
            }
        });
    }
}
