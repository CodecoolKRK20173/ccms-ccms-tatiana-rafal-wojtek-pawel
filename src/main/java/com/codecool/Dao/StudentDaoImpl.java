package com.codecool.Dao;


import com.codecool.Model.Assignment;
import com.codecool.Model.Employee;
import com.codecool.Model.Student;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentDaoImpl implements UserDao {
    private DatabaseConnector databaseConnector;

    public StudentDaoImpl(){
        this.databaseConnector = DatabaseConnector.getInstance();
    }


    @Override
    public List<Employee> getAll(){

        List<Employee> students = new ArrayList<>();
        Statement stmt = null;
        try{
            databaseConnector.connectToDatabase();
            databaseConnector.getConnection().setAutoCommit(false);
            stmt = databaseConnector.getConnection().createStatement();
            String sqlQuery = "SELECT Students.Id, FIRSTNAME, SECONDNAME, MAIL, " +
                    "Assignments.Title, GRADE, ACCESSRIGHTS FROM STUDENTS LEFT JOIN " +
                    "StudentAssignment ON Students.Id  = StudentAssignment.StudentId  " +
                    "LEFT JOIN Assignments ON StudentAssignment.assignmentId = Assignments.id ORDER BY STUDENTS.ID;";
            ResultSet rs = stmt.executeQuery(sqlQuery);
            Integer currentId = rs.getInt("id");
            Assignment assignment = new Assignment(rs.getString("title"));
            Integer grade = rs.getInt("grade");
            HashMap<Assignment, Integer> grades = new HashMap<>();
            grades.put(assignment, grade);
            Student student = new Student(rs.getInt("Id"), rs.getString("firstName")
                    , rs.getString("secondName"), rs.getString("mail"), "student", grades);
            rs.next();
            while(rs.next()){
                if(rs.getInt("id") == currentId){
                    student.getGrades().put(new Assignment(rs.getString("title")), rs.getInt("grade"));
                }
                else{
                    students.add(student);
                    currentId = rs.getInt("id");
                    assignment = new Assignment(rs.getString("title"));
                    grade = rs.getInt("grade");
                    grades = new HashMap<>();
                    grades.put(assignment, grade);
                    student = new Student(rs.getInt("id"), rs.getString("firstname")
                            , rs.getString("secondname"), rs.getString("mail"), "student",  grades);
                }
            }
            students.add(student);
            rs.close();
            stmt.close();
            databaseConnector.getConnection().close();
        }

        catch (SQLException e){

           e.printStackTrace();
        }
        return students;
    }



    @Override
    public void delete(int ids){
        String deleteStudent = "DELETE FROM STUDENTS WHERE id = ?;";
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            databaseConnector.connectToDatabase();
            statement = databaseConnector.getConnection().prepareStatement(deleteStudent);
            statement.setInt(1, ids);
            statement.executeUpdate();
            statement.close();
            databaseConnector.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void add(String name, String surname, String mail, String login, String password) {
        createLogin(login, password);
        int loginsId = getLastUsersLoginId();
        String query = "INSERT INTO Students(firstname, secondname, mail, loginid) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            databaseConnector.connectToDatabase();
            statement = databaseConnector.getConnection().prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, mail);
            statement.setInt(4, loginsId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
    }
    }



    private void createLogin(String login, String password){
        String query = "INSERT INTO LOGINS(LOGIN, PASSWORD, ACCESSRIGHTS) VALUES(?,?,student)";

        String query2 = "INSERT INTO LOGINS(LOGIN, PASSWORD, ACCESSRIGHTS) VALUES(?,?,student)";
        PreparedStatement statement = null;
        try {
            databaseConnector.connectToDatabase();
            statement = databaseConnector.getConnection().prepareStatement(query);
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
            databaseConnector.connectToDatabase();
            statement = databaseConnector.getConnection().prepareStatement(productsQuery);
            results = statement.executeQuery();
            int id = 0;
            while (results.next()){
                id = results.getInt("id");
            }
            statement.close();
            databaseConnector.getConnection().close();
            return id;

        } catch (SQLException e) {
            e.printStackTrace();
    }








    @Override
    public void edit(int id){

    }


}
