package com.codecool.Dao;


import com.codecool.Model.Employee;
import com.codecool.Model.Student;

import java.sql.*;

public class LoginDaoImpl{

    private DatabaseConnector connector;

    public LoginDaoImpl() {
        this.connector = DatabaseConnector.getInstance();
    }


    public Employee getUserByLogin(String mentorLogin, String mentorPassword) {
        connector.connectToDatabase();
        Statement statement;
        ResultSet resultSet;
        try {
            connector.connectToDatabase();
            connector.getConnection().setAutoCommit(false);
            statement = connector.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT FirstName, SecondName, Mail, Mentors.Id, AccessRights FROM" +
                    " Mentors LEFT JOIN Logins ON Logins.Id = Mentors.LoginId WHERE Logins.Login = '" + mentorLogin +
                    "' AND Logins.Password = '" + mentorPassword +"';");
            int id = resultSet.getInt("Id");
            String firstName = resultSet.getString("FirstName");
            String secondName = resultSet.getString("SecondName");
            String mail = resultSet.getString("Mail" );
            String accessRights = resultSet.getString("AccessRights");
            resultSet.close();
            statement.close();
            connector.getConnection().close();
            if (accessRights.equals("mentor")) {
                return new Employee(id, firstName, secondName, mail, "mentor");
            } else if (accessRights.equals("admin")) {
                return new Employee(id, firstName, secondName, mail, "admin");
            } else if (accessRights.equals("student")) {
                return new Employee(id, firstName, secondName, mail, "student");
            } else if (accessRights.equals("employee")) {
                return new Employee(id, firstName, secondName, mail, "employee");
            } else {
                return null;
            }

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return null;
    }


}
