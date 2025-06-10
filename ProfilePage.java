package com.tourandtravel.ui;

import com.tourandtravel.data.UserDatabase;
import com.tourandtravel.data.UserDatabase.User;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class ProfilePage {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField phoneField;
    private JButton editButton;
    private JButton saveButton;

    public ProfilePage() {
        JFrame frame = new JFrame("User Profile");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(255, 213, 128));    
        
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(240, 248, 255));
        contentPanel.setLayout(new GridBagLayout()); // centers child panel
        contentPanel.setBackground(new Color(255, 213, 128));    


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(240, 248, 255));
        centerPanel.setBorder(new EmptyBorder(40, 60, 40, 60));

        JLabel title = new JLabel("Profile Details");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(title);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        centerPanel.setBackground(new Color(255, 213, 128));    


        User user = UserDatabase.loggedInUser;

        nameField = createStyledField(user != null ? user.getUsername() : "Guest", "Name");
        ageField = createStyledField(user != null ? user.getAge() : "", "Age");
        phoneField = createStyledField(user != null ? user.getPhone() : "", "Phone");

        centerPanel.add(nameField);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        centerPanel.add(ageField);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        centerPanel.add(phoneField);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));

        editButton = new JButton("Edit");
        saveButton = new JButton("Save");
        saveButton.setEnabled(false);

        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);

        centerPanel.add(buttonPanel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        JButton goToCitySelectionButton = new JButton("Add Tour");
        goToCitySelectionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(goToCitySelectionButton);

        contentPanel.add(centerPanel); // center everything in the frame

        frame.add(contentPanel);
        frame.setVisible(true);

        // Action listeners
        editButton.addActionListener(e -> enableEditing(true));
        saveButton.addActionListener(e -> {
            if (user != null) {
                user.setAge(ageField.getText());
                user.setPhone(phoneField.getText());
            }
            enableEditing(false);
            JOptionPane.showMessageDialog(null, "Profile updated successfully!");
        });

        goToCitySelectionButton.addActionListener(e -> {
            frame.dispose();
            new CitySelectionPage();
        });
    }

    private JTextField createStyledField(String value, String title) {
        JTextField field = new JTextField(value);
        field.setMaximumSize(new Dimension(400, 50));
        field.setFont(new Font("SansSerif", Font.PLAIN, 16));
        field.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.GRAY, 1, true), title));
        field.setEditable(false);
        return field;
    }

    private void enableEditing(boolean editable) {
        nameField.setEditable(editable); // optional: make non-editable if you don't want name changes
        ageField.setEditable(editable);
        phoneField.setEditable(editable);
        editButton.setEnabled(!editable);
        saveButton.setEnabled(editable);
    }
}
