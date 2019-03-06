package com.codecool.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class CrudAssignmentsDaoImpl implements  CrudAssignmentsDao {

    private Connection connection;

    public CrudAssignmentsDaoImpl() {

    }

    @Override
    public void addAssignment(String title) {
        connection.
    }

    private Connection initializeConnection() {
        final String DATABASEPATH = "src/main/resources/CcMS";
        Connector connector = new Connector(DATABASEPATH);
        return connector.getDatabaseConnection();
    }


}
