package com.codecool.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class CrudAssignmentsDaoImpl implements  CrudAssignmentsDao {
    
    private DatabaseConnector connector;

    public CrudAssignmentsDaoImpl() {
        this.connector = DatabaseConnector.getInstance();
    }

    @Override
    public void addAssignment(String title) {
        connector.connectToDatabase();
        PreparedStatement assignment = null;
        String addString = "INSERT INTO Assignments (Title) VALUES (?)";
        try {
            connector.getConnection().prepareStatement(addString);
            assignment.setString(1, title);
            assignment.executeUpdate();
            assignment.close();
            connector.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
