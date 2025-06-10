package com.tourandtravel.ui;

import javax.swing.*;
import java.awt.*;

public class HomePage 
{
    public HomePage() 
    {
        JFrame frame = new JFrame("Tour & Travel - Welcome");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Load background image
        ImageIcon backgroundIcon = new ImageIcon("C:\\users\\aditi\\Downloads\\backgroundPage1.jpg");
        Image backgroundImage = backgroundIcon.getImage();

        // Custom JPanel with background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
        backgroundPanel.setOpaque(false);

        // Create transparent panel for content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        contentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome to Tour & Travel!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 26));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Please choose how you'd like to proceed:");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subtitle.setForeground(Color.WHITE);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginButton = new JButton("Log In/Sign Up");
        JButton exploreButton = new JButton("Explore as Guest");

        Dimension buttonSize = new Dimension(200, 100);
        
        for (JButton btn : new JButton[]{loginButton, exploreButton})
        {
            btn.setMaximumSize(buttonSize);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        // Add action listeners\
        exploreButton.addActionListener(s -> 
        {
        	frame.dispose();
            new CitySelectionPage();
        });
        
        loginButton.addActionListener(e -> 
        {
            new LogInPage();
        });

        // Add components to contentPanel
        contentPanel.add(Box.createVerticalStrut(50));
        contentPanel.add(welcomeLabel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(subtitle);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(loginButton);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(exploreButton);

        // Center content panel inside background panel
        backgroundPanel.add(Box.createVerticalGlue());
        backgroundPanel.add(contentPanel);
        backgroundPanel.add(Box.createVerticalGlue());

        // Set backgroundPanel as content pane
        frame.setContentPane(backgroundPanel);
        frame.setVisible(true);
    }
}
