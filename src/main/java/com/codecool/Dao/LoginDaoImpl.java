package com.codecool.Dao;

import com.codecool.Model.Employee;

import java.sql.*;

public class LoginDaoImpl{

    private DatabaseConnector connector;

    public LoginDaoImpl() {
        this.connector = DatabaseConnector.getInstance();
    }

    private String getAccessRights(String userLogin, String userPassword) {
        connector.connectToDatabase();
        Statement statement;
        ResultSet resultSet;
        try {
            connector.connectToDatabase();
            connector.getConnection().setAutoCommit(false);
            statement = connector.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT Id, AccessRights FROM" +
                    " Logins WHERE Login = '" + userLogin +
                    "' AND Password = '" + userPassword +"';");
            String accessRights = resultSet.getString("AccessRights");
            resultSet.close();
            statement.close();
            connector.getConnection().close();
            return accessRights;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return null;
    }

    private String getNameOfTable(String userLogin, String userPassword) {
        String userAccessRigths = getAccessRights(userLogin, userPassword);
        String table = "";
        if (userAccessRigths.equals("mentor")) {
            table = "Mentors";
        } else if (userAccessRigths.equals("student")) {
            table = "Students";
        } else if (userAccessRigths.equals("admin")) {
            table = "Admins";
        } else if (userAccessRigths.equals("employee")) {
            table = "Employees";
        }
        return table;
    }

    public Employee getUserByLogin(String userLogin, String userPassword) {
        String table = getNameOfTable(userLogin, userPassword);
        connector.connectToDatabase();
        PreparedStatement getUser;
        ResultSet resultSet = null;
        String user = "SELECT FirstName, SecondName, Mail," + table +".Id, AccessRights FROM " +
                table +" LEFT JOIN Logins ON Logins.Id = "+ table +".LoginId WHERE Logins.Login = ?" +
                " AND Logins.Password = ?";

        try {
            getUser = connector.getConnection().prepareStatement(user);
            getUser.setString(1,userLogin);
            getUser.setString(2,userPassword);
            resultSet = getUser.executeQuery();
            int id = resultSet.getInt("Id");
            String firstName = resultSet.getString("FirstName");
            String secondName = resultSet.getString("SecondName");
            String mail = resultSet.getString("Mail" );
            String accessRights = resultSet.getString("AccessRights");
            resultSet.close();
            getUser.close();
            connector.getConnection().close();
            return new Employee(id, firstName, secondName, mail, accessRights);
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return null;
    }

}
