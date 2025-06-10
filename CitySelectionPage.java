package com.tourandtravel.ui;

import javax.swing.*;
import java.awt.*;

import com.tourandtravel.data.UserDatabase;

public class CitySelectionPage 
{
	CitySelectionPage()
	{
		// Create frame
        JFrame frame = new JFrame("City Selection Page");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBackground(new Color(255, 213, 128));    


        // Create custom panel with background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Set background color first
                g.setColor(new Color(255, 213, 128));
                g.fillRect(0, 0, getWidth(), getHeight());

            }
        };


        // List of Indian airports
        String[] airports = {
            "Agartala – Maharaja Bir Bikram Airport (IXA)",
            "Ahmedabad – Sardar Vallabhbhai Patel International Airport (AMD)",
            "Amritsar – Sri Guru Ram Das Ji International Airport (ATQ)",
            "Ayodhya – Maharishi Valmiki International Airport (AYJ)",
            "Bengaluru – Kempegowda International Airport (BLR)",
            "Bhopal – Raja Bhoj Airport (BHO)",
            "Bhubaneswar – Biju Patnaik International Airport (BBI)",
            "Chennai – Chennai International Airport (MAA)",
            "Coimbatore – Coimbatore International Airport (CJB)",
            "Delhi – Indira Gandhi International Airport (DEL)",
            "Gaya – Gaya Airport (GAY)",
            "Guwahati – Lokpriya Gopinath Bordoloi International Airport (GAU)",
            "Hyderabad – Rajiv Gandhi International Airport (HYD)",
            "Imphal – Imphal Airport (IMF)",
            "Indore – Devi Ahilya Bai Holkar Airport (IDR)",
            "Jaipur – Jaipur International Airport (JAI)",
            "Jammu – Jammu Airport (IXJ)",
            "Kannur – Kannur International Airport (CNN)",
            "Kochi – Cochin International Airport (COK)",
            "Kolkata – Netaji Subhas Chandra Bose International Airport (CCU)",
            "Kozhikode – Calicut International Airport (CCJ)",
            "Lucknow – Chaudhary Charan Singh Airport (LKO)",
            "Madurai – Madurai Airport (IXM)",
            "Mangaluru – Mangaluru International Airport (IXE)",
            "Mumbai – Chhatrapati Shivaji Maharaj International Airport (BOM)",
            "Nagpur – Dr. Babasaheb Ambedkar International Airport (NAG)",
            "Nashik – Nashik Airport (ISK)",
            "Pune – Pune Airport (PNQ)",
            "Ranchi – Birsa Munda Airport (IXR)",
            "Siliguri – Bagdogra International Airport (IXB)",
            "Srinagar – Srinagar Airport (SXR)",
            "Thiruvananthapuram – Trivandrum International Airport (TRV)",
            "Tiruchirappalli – Tiruchirappalli International Airport (TRZ)",
            "Tirupati – Tirupati International Airport (TIR)",
            "Vadodara – Vadodara Airport (BDQ)",
            "Varanasi – Lal Bahadur Shastri Airport (VNS)",
            "Vijayawada – Vijayawada International Airport (VGA)",
            "Visakhapatnam – Visakhapatnam International Airport (VTZ)"
        };

        // Dropdown form panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        panel.setBounds(600, 300, 400, 250);

        // Styling
        Font labelFont = new Font("Serif", Font.BOLD, 18);
        Font comboFont = new Font("Serif", Font.PLAIN, 16);

        // Components
        JLabel fromLabel = new JLabel("Enter city from:");
        fromLabel.setFont(labelFont);
        fromLabel.setForeground(Color.WHITE);
        fromLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JComboBox<String> cityFrom = new JComboBox<>(airports);
        cityFrom.setFont(comboFont);
        cityFrom.setMaximumSize(new Dimension(300, 30));
        cityFrom.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel toLabel = new JLabel("Enter city to:");
        toLabel.setFont(labelFont);
        toLabel.setForeground(Color.WHITE);
        toLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JComboBox<String> cityTo = new JComboBox<>(airports);
        cityTo.setFont(comboFont);
        cityTo.setMaximumSize(new Dimension(300, 30));
        cityTo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Serif", Font.BOLD, 16));
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        nextButton.addActionListener(e -> 
        {
            UserDatabase.cityFrom = (String) cityFrom.getSelectedItem();
            UserDatabase.cityTo = (String) cityTo.getSelectedItem();

            System.out.println("City From: " + UserDatabase.cityFrom);
            System.out.println("City To: " + UserDatabase.cityTo);

            frame.dispose(); // close city selection page

            // Open next page
            new DateSelectionPage();
        });

        // Add components with spacing
        panel.add(fromLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(cityFrom);
        panel.add(Box.createVerticalStrut(20));
        panel.add(toLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(cityTo);
        panel.add(Box.createVerticalStrut(30));
        panel.add(nextButton);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(600, 300, 400, 250);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        backgroundPanel.add(scrollPane);
        frame.setContentPane(backgroundPanel);
        frame.setVisible(true);
	}
}
