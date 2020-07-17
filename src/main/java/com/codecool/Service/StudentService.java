package com.codecool.Service;

import com.codecool.Model.Employee;
import com.codecool.Model.Student;
import com.codecool.View.View;

public class StudentService {

    private View view;
    private Employee student;

    public StudentService(Employee student) {
        view = new View();
        this.student = student;
    }

}
