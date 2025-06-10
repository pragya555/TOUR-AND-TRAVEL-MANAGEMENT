package com.tourandtravel.ui;

import javax.swing.*;
import java.awt.*;

public class BookingConfirmationPage {
    public BookingConfirmationPage() {
        JFrame frame = new JFrame("Booking Confirmed");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Background panel with color
        JPanel backgroundPanel = new JPanel();
        backgroundPanel.setBackground(new Color(255, 213, 128));
        backgroundPanel.setLayout(new BorderLayout());

        // Message label
        JLabel message = new JLabel(
                "<html><div style='text-align: center;'>"
                + "<h1>Your flights are booked.</h1>"
                + "<h2>You will be called soon.</h2>"
                + "<br><h3>Bye! Thank you for contacting us.</h3>"
                + "</div></html>",
                SwingConstants.CENTER
        );
        message.setFont(new Font("Serif", Font.PLAIN, 28));
        message.setHorizontalAlignment(SwingConstants.CENTER);
        backgroundPanel.add(message, BorderLayout.CENTER);

        // Close button
        JButton closeButton = new JButton("Close");
        closeButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        closeButton.setBackground(Color.WHITE);
        closeButton.setForeground(Color.BLACK);
        closeButton.setPreferredSize(new Dimension(120, 50));
        closeButton.addActionListener(e -> System.exit(0));

        // Panel for button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 213, 128));
        buttonPanel.add(closeButton);

        backgroundPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(backgroundPanel);
        frame.setVisible(true);
    }
}
