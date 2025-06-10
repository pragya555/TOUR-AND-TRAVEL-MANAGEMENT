// TourPackageDAO.java
package com.tourandtravel.dao;

/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tourandtravel.model.TourPackage;

public class TourPackageDAO {
    private Connection connection;

    public TourPackageDAO(Connection connection) {
        this.connection = connection;
    }

    // Create
    public void createTourPackage(TourPackage tourPackage) throws SQLException {
        String query = "INSERT INTO tour_packages (name, description, duration, cost) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, tourPackage.getName());
        statement.setString(2, tourPackage.getDescription());
        statement.setInt(3, tourPackage.getDuration());
        statement.setDouble(4, tourPackage.getCost());
        statement.executeUpdate();
    }

    // Read
    public TourPackage getTourPackageById1(int id) throws SQLException {
        String query = "SELECT * FROM tour_packages WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        TourPackage tourPackage = null;
        if (resultSet.next()) {
            tourPackage = new TourPackage(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"), resultSet.getInt("duration"), resultSet.getDouble("cost"));
        }
        return tourPackage;
    }

// Read
public TourPackage getTourPackageById(int id) throws SQLException 
{
    String query = "SELECT * FROM tour_packages WHERE id = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setInt(1, id);
    ResultSet resultSet = statement.executeQuery();
    TourPackage tourPackage = null;
    if (resultSet.next()) 
    {
        tourPackage = new TourPackage(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"), resultSet.getInt("duration"), resultSet.getDouble("cost"));
    }
    return tourPackage;
}

// Get all tour packages
public List<TourPackage> getAllTourPackages() throws SQLException 
{
    String query = "SELECT * FROM tour_packages";
    PreparedStatement statement = connection.prepareStatement(query);
    ResultSet resultSet = statement.executeQuery();
    List<TourPackage> tourPackages = new ArrayList<>();
    
    while (resultSet.next()) 
    {
        TourPackage tourPackage = new TourPackage(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("description"), resultSet.getInt("duration"), resultSet.getDouble("cost"));
        tourPackages.add(tourPackage);
    }
    
    return tourPackages;
}
}
*/