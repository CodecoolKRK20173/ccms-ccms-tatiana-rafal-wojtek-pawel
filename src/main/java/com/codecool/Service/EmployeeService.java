package com.codecool.Service;

import com.codecool.Dao.StudentDaoImpl;
import com.codecool.Model.Employee;
import com.codecool.View.View;

import java.util.List;

public class EmployeeService {
    private View view;
    private StudentDaoImpl studentDao;

    public EmployeeService() {
        this.view = new View();
        this.studentDao = new StudentDaoImpl();
    }

    public void displayAllStudents() {
        List<Employee> students = studentDao.getAll();
        view.displayStudentsTable(students);
        view.getEmptyInput();
    }
}
