package com.codecool.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    protected static DatabaseConnector single_instance = null;
    private Connection connection;

    protected DatabaseConnector(){

    }

    static DatabaseConnector getInstance() {
        if (single_instance == null) {
            single_instance = new DatabaseConnector();
        }
        return single_instance;
    }


    private void connectToDatabase() {
        connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/CcMS.dms");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
