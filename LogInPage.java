package com.tourandtravel.ui;

import com.tourandtravel.data.UserDatabase;
import com.tourandtravel.data.UserDatabase.User;

import javax.swing.*;
import java.awt.*;

public class LogInPage
{
    public LogInPage() 
    {
        JFrame choiceFrame = new JFrame("Welcome");
        choiceFrame.setSize(350, 200);
        choiceFrame.setLocationRelativeTo(null);
        choiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choiceFrame.setLayout(new BorderLayout());
        choiceFrame.setBackground(new Color(255, 213, 128));    


        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new BoxLayout(choicePanel, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel("Do you want to log in or sign up?");
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton loginBtn = new JButton("Log In");
        loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton signupBtn = new JButton("Sign Up");
        signupBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginBtn.addActionListener(e -> {
            choiceFrame.dispose();
            showLoginForm();
        });

        signupBtn.addActionListener(e -> {
            choiceFrame.dispose();
            new SignUpPage(null);
        });

        choicePanel.add(Box.createVerticalStrut(20));
        choicePanel.add(questionLabel);
        choicePanel.add(Box.createVerticalStrut(20));
        choicePanel.add(loginBtn);
        choicePanel.add(Box.createVerticalStrut(10));
        choicePanel.add(signupBtn);

        choiceFrame.add(choicePanel, BorderLayout.CENTER);
        choiceFrame.setVisible(true);
    }

	private void showLoginForm() {
        JFrame frame = new JFrame("Login");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("User Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField usernameField = new JTextField();
        usernameField.setMaximumSize(new Dimension(250, 30));
        usernameField.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameField.setBorder(BorderFactory.createTitledBorder("Username"));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(250, 30));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));

        JButton loginButton = new JButton("Log In");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel messageLabel = new JLabel("");
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        loginButton.addActionListener(e -> 
        {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());

            if (UserDatabase.validateLogin(username, password)) 
            {
                JOptionPane.showMessageDialog(frame, "Login successful!");
                User loggedInUser = UserDatabase.getUser(username);
                UserDatabase.loggedInUser = (User) loggedInUser;
                System.out.println("it runs until here");
                frame.dispose();
                new ProfilePage();
                System.out.println("it runs until here too");
                
            } 
            
            else 
            {
                messageLabel.setText("Invalid username or password.");
            }
        });

        panel.add(Box.createVerticalStrut(30));
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(Box.createVerticalStrut(15));
        panel.add(loginButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(messageLabel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
