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
                    "Assignments.Title, GRADE FROM STUDENTS LEFT JOIN " +
                    "StudentAssignment ON Students.Id  = StudentAssignment.StudentId  " +
                    "LEFT JOIN Assignments ON StudentAssignment.assignmentId = Assignments.id ORDER BY STUDENTS.ID;";
            ResultSet rs = stmt.executeQuery(sqlQuery);
            Integer currentId = rs.getInt("id");
            Assignment assignment = new Assignment(rs.getString("title"));
            Integer grade = rs.getInt("grade");
            HashMap<Assignment, Integer> grades = new HashMap<>();
            grades.put(assignment, grade);
            Student student = new Student(rs.getInt("Id"), rs.getString("firstName")
                    , rs.getString("secondName"), rs.getString("mail"), grades);
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
                            , rs.getString("secondname"), rs.getString("mail"), grades);
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
    public void add(String name, String surname, String mail, String loginID){

    }
    @Override
    public void edit(int id){

    }


}
