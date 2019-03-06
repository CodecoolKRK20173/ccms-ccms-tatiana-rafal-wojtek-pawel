package com.codecool.Dao;

<<<<<<< HEAD
=======
import com.codecool.Model.Employee;
>>>>>>> 1ad2c2604cc15c3622b05fe428b6aa640257c9a9

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class LoginDaoImpl{

    private List<Employee> users;
    private DatabaseConnector connector;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public LoginDaoImpl() {
        users = new ArrayList<>();
    }

    private Integer getUserLoginID(String mentorLogin, String mentorPassword) {
        connector = new DatabaseConnector();
        connection = connector.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT  FROM CcMS");
            int id = resultSet.getInt("LoginID");
            String login = resultSet.getString("Login");
            String password = resultSet.getString("AccessRights");
        } catch (SQLException error) {
            error.printStackTrace();
        }

    }


    public List<Employee> getUsers() {
        return this.users;
    }

}
