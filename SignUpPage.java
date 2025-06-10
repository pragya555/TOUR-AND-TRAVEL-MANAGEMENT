package com.tourandtravel.ui;

import com.tourandtravel.data.UserDatabase;
import com.tourandtravel.data.UserDatabase.User;

import javax.swing.*;
import java.awt.*;

public class SignUpPage {
    public SignUpPage(Runnable onSuccess) {
        JFrame frame = new JFrame("Sign Up");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(255, 213, 128));    


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Create Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField usernameField = new JTextField();
        usernameField.setMaximumSize(new Dimension(250, 30));
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(250, 30));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel messageLabel = new JLabel("");
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        signUpButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Please fill in all fields.");
                return;
            }

            if (UserDatabase.userExists(username)) {
                messageLabel.setText("Username already taken.");
                return;
            }

            User newUser = new User(username, password);
            UserDatabase.addUser(newUser);
            UserDatabase.loggedInUser = newUser;

            JOptionPane.showMessageDialog(frame, "Sign-up successful! Logged in.");
            frame.dispose();
            new ProfilePage();
            if (onSuccess != null) onSuccess.run();
        });

        panel.add(Box.createVerticalStrut(20));
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(10));
        panel.add(signUpButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(messageLabel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
