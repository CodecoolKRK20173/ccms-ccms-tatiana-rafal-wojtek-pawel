package com.codecool;


import com.codecool.Dao.StudentDaoImpl;
import com.codecool.Model.Employee;
import com.codecool.Model.Student;
import com.codecool.Model.Assignment;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StudentDaoImpl dao = new StudentDaoImpl();
        List<Employee> studends = dao.getAll();


        for (Employee student: studends) {
            student = (Student) student;
            System.out.println(student.getName() +  "  " +  student.getSurname() + "\n");
            for(Assignment assignment : ((Student) student).getGrades().keySet()){
                System.out.println(assignment.getTitle());
            }
        }

    }
}
