package com.tourandtravel.ui;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.*;

public class DateLabelFormatter extends AbstractFormatter {

    private final String datePattern = "yyyy-MM-dd"; // or whatever format you want
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parse(text);
    }

    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            if (value instanceof Date) {
                return dateFormatter.format((Date) value);
            } else if (value instanceof Calendar) {
                return dateFormatter.format(((Calendar) value).getTime());
            }
        }
        return "";
    }
}
