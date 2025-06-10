package com.tourandtravel.ui;

import com.tourandtravel.data.UserDatabase;

import javax.swing.*;
import java.awt.*;

public class PriceListPage {
    public PriceListPage() {
        // Check if user is logged in
        if (UserDatabase.loggedInUser == null) {
            JOptionPane.showMessageDialog(null, "Please log in to view the price list.");
            new LogInPage(); // callback to reopen this page after login
            return;
        }

        JFrame frame = new JFrame("Flight Price List");
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Route label
        JLabel routeLabel = new JLabel("Route: " + UserDatabase.cityFrom + " → " + UserDatabase.cityTo);
        routeLabel.setFont(new Font("Serif", Font.BOLD, 18));
        routeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Travel dates label
        JLabel dateLabel = new JLabel("Dates: " + UserDatabase.departureDate + " to " + UserDatabase.returnDate);
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Class selection label
        JLabel priceListLabel = new JLabel("Select Class");
        priceListLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        priceListLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(20));
        panel.add(routeLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(dateLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(priceListLabel);
        panel.add(Box.createVerticalStrut(20));

        // Flight class buttons
        String[] classes = {"Economy", "Business", "First Class"};
        for (String flightClass : classes) {
            JButton classButton = new JButton(flightClass);
            classButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            classButton.setMaximumSize(new Dimension(200, 40));

            classButton.addActionListener(e -> {
                double price;

                switch (flightClass) {
                    case "Business":
                        price = 10000;
                        break;
                    case "First Class":
                        price = 22000;
                        break;
                    default:
                        price = 5000;
                        break;
                }

                UserDatabase.selectedClass = flightClass;

                JOptionPane.showMessageDialog(frame,
                        String.format("Class: %s\nTotal Fare: ₹%.2f", flightClass, price));

                // Continue to next step or close this window
                frame.dispose();

                // Show confirmation
                new BookingConfirmationPage();

            });

            panel.add(classButton);
            panel.add(Box.createVerticalStrut(10));
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
