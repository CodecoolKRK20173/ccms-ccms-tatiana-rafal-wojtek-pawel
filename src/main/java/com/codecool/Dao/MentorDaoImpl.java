package com.codecool.Dao;

import com.codecool.Model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MentorDaoImpl implements UserDao{

    public List<Employee> mentors;
    private DatabaseConnector connector;

    public MentorDaoImpl() {
        this.connector = DatabaseConnector.getInstance();
    }

    public List<Employee> getAll() {
        List<Employee> mentors = new ArrayList<>();
        Statement stmt = null;
        try {
            connector.connectToDatabase();
            connector.getConnection().setAutoCommit(false);
            stmt = connector.getConnection().createStatement();
            String sqlQuery = "SELECT Mentors.Id, FirstName, SecondName, Mail FROM Mentors";
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                Employee mentor = new Employee(rs.getInt("id"), rs.getString("firstName"),
                        rs.getString("secondName"), rs.getString("mail"), "mentor");
                mentors.add(mentor);
            }
            rs.close();
            stmt.close();
            connector.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentors;
    }

    public void delete(int id) {
        connector.connectToDatabase();
        PreparedStatement deleteMentor;
        String deleteString = "DELETE FROM Mentors WHERE ID = ?";
        try {
            deleteMentor = connector.getConnection().prepareStatement(deleteString);
            deleteMentor.setInt(1, id);
            deleteMentor.executeUpdate();
            deleteMentor.close();
            connector.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(String name, String surname, String mail, String login, String password) {
        createLogin(login, password);
        int loginsId = getLastUsersLoginId();
        String query = "INSERT INTO Mentors(firstname, secondname, mail, loginid) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            connector.connectToDatabase();
            statement = connector.getConnection().prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, mail);
            statement.setInt(4, loginsId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(int id) {

    }

    private void createLogin(String login, String password){
        String query = "INSERT INTO LOGINS(LOGIN, PASSWORD, ACCESSRIGHTS) VALUES(?,?,'mentor')";
        PreparedStatement statement = null;
        try {
            connector.connectToDatabase();
            statement = connector.getConnection().prepareStatement(query);
            statement.setString(1, login);
            statement.setString(2, password);
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private int getLastUsersLoginId(){
        String productsQuery = "SELECT id FROM logins";
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            connector.connectToDatabase();
            statement = connector.getConnection().prepareStatement(productsQuery);
            results = statement.executeQuery();
            int id = 0;
            while (results.next()){
                id = results.getInt("id");
            }
            statement.close();
            connector.getConnection().close();
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
            return Integer.parseInt(null);
        }
    }

}
