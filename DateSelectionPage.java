package com.tourandtravel.ui;

import com.tourandtravel.data.UserDatabase;
import org.jdatepicker.impl.*;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

public class DateSelectionPage 
{
    public DateSelectionPage() 
    {
        JFrame frame = new JFrame("Select Travel Dates");
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(255, 213, 128));    


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 213, 128));    


        JLabel routeLabel = new JLabel("From: " + UserDatabase.cityFrom + "  →  To: " + UserDatabase.cityTo);
        routeLabel.setFont(new Font("Serif", Font.BOLD, 18));
        routeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ===== DEPARTURE DATE PICKER =====
        JLabel depLabel = new JLabel("Departure Date:");
        depLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        UtilDateModel depModel = new UtilDateModel();
        JDatePickerImpl depPicker = createDatePicker(depModel);

        // ===== RETURN DATE PICKER =====
        JLabel retLabel = new JLabel("Return Date:");
        retLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        UtilDateModel retModel = new UtilDateModel();
        JDatePickerImpl retPicker = createDatePicker(retModel);

        // ===== SUBMIT BUTTON =====
        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        submitButton.addActionListener(e -> {
            Date depDate = (Date) depPicker.getModel().getValue();
            Date retDate = (Date) retPicker.getModel().getValue();

            if (depDate == null || retDate == null) {
                JOptionPane.showMessageDialog(frame, "Please select both dates.");
                return;
            }

            if (retDate.before(depDate) || retDate.equals(depDate)) {
                JOptionPane.showMessageDialog(frame, "Return date cannot be before or on the departure date.");
                return;
            }

            try {
                String depStr = new DateLabelFormatter().valueToString(depDate);
                String retStr = new DateLabelFormatter().valueToString(retDate);

                UserDatabase.departureDate = depStr;
                UserDatabase.returnDate = retStr;

                JOptionPane.showMessageDialog(frame,
                        "Dates Saved:\nDeparture: " + depStr + "\nReturn: " + retStr);

                frame.dispose(); // Close current window
                new PriceListPage(); // goes to price selection page

            } catch (ParseException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error parsing date. Please try again.");
            }
        });

        // ===== ADD TO PANEL =====
        panel.add(Box.createVerticalStrut(20));
        panel.add(routeLabel);
        panel.add(Box.createVerticalStrut(30));
        panel.add(depLabel);
        panel.add(depPicker);
        panel.add(Box.createVerticalStrut(20));
        panel.add(retLabel);
        panel.add(retPicker);
        panel.add(Box.createVerticalStrut(20));
        panel.add(submitButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JDatePickerImpl createDatePicker(UtilDateModel model) {
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        return new JDatePickerImpl(datePanel, new DateLabelFormatter());
    }
}
