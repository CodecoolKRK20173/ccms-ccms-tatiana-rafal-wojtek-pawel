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
        PreparedStatement deleteStudent;
        String deleteString = "DELETE FROM Students WHERE ID = ?";
        try {
            deleteStudent = connector.getConnection().prepareStatement(deleteString);
            deleteStudent.setInt(1, id);
            deleteStudent.executeUpdate();
            deleteStudent.close();
            connector.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(String name, String surname, String mail, String login, String password) {
    }

    public void edit(int id) {

    }

}
