package com.codecool.Dao;

import com.codecool.Model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements UserDao {
    private DatabaseConnector databaseConnector;

    public StudentDaoImpl(){
        this.databaseConnector = DatabaseConnector.getInstance();
    }



    @Override
    public  List<Employee> getAll(){
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
            Integer currentId = 1;
            while(rs.next()){
                if(rs.getInt("id") == currentId){

                }
                currentId = rs.getInt("id");
            }
        }

        catch (SQLException e){
        }
        return students;
    }








    @Override
    public void delete(int ids){

    }
    @Override
    public void add(String name, String surname, String mail, String loginID){

    }
    @Override
    public void edit(int id){

    }


}
