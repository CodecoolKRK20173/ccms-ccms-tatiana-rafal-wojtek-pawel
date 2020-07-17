package com.codecool.Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudAssignmentsDaoImpl implements  CrudAssignmentsDao {

    private DatabaseConnector connector;

    public CrudAssignmentsDaoImpl() {
        this.connector = DatabaseConnector.getInstance();
    }

    @Override
    public void addAssignment(String title) {
        connector.connectToDatabase();
        PreparedStatement assignment;
        String addString = "INSERT INTO Assignments (Title) VALUES (?)";
        try {
            assignment = connector.getConnection().prepareStatement(addString);
            assignment.setString(1, title);
            assignment.executeUpdate();
            assignment.close();
            connector.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAssignment(int id) {
        connector.connectToDatabase();
        PreparedStatement assignment;
        String deleteString = "DELETE FROM Assignments WHERE ID = ?";
        try {
            assignment = connector.getConnection().prepareStatement(deleteString);
            assignment.setInt(1, id);
            assignment.executeUpdate();
            assignment.close();
            connector.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
