package com.codecool.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class CrudAssignmentsDaoImpl implements  CrudAssignmentsDao {

    private DatabaseConnector connection;

    public CrudAssignmentsDaoImpl() {
        this.connection = DatabaseConnector.getInstance();
    }

    @Override
    public void addAssignment(String title) {
        connection.connectToDatabase();
    }
}
