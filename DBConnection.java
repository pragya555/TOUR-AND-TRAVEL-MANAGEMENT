package com.tourandtravel.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection
{
    private static final String URL = "jdbc:mysql://localhost:3306/tourandtravel";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection()
    {
        try
        {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e)
        {
            throw new RuntimeException("Failed to establish connection", e);
        }
    }
}
