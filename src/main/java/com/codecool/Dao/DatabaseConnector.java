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



    public void connectToDatabase() {
        connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/CcMS.dms");
        } catch (ClassNotFoundException e) {
//            System.err.println(e.getClass().getName() + ": " + e.getMessage());
//            System.exit(0);
            e.getStackTrace();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }
}
