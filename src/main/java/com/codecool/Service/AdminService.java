package com.codecool.Service;

import com.codecool.Dao.CrudAssignmentsDaoImpl;
import com.codecool.Dao.MentorDaoImpl;
import com.codecool.Dao.StudentDaoImpl;
import com.codecool.Model.Employee;
import com.codecool.View.View;

import java.util.List;

public class AdminService {
    private View view;
    private CrudAssignmentsDaoImpl assignmentsDao;
    private MentorDaoImpl mentorDao;
    private StudentDaoImpl studentDao;

    public AdminService() {
        this.view = new View();
        this.assignmentsDao = new CrudAssignmentsDaoImpl();
        this.mentorDao = new MentorDaoImpl();
        this.studentDao = new StudentDaoImpl();
    }

    public void displayAllStudents() {
        List<Employee> students = studentDao.getAll();
        view.displayStudentsTable(students);
        view.getEmptyInput();
    }

    public void displayAllMentors() {
        List<Employee> mentors = mentorDao.getAll();
        view.displayMentorsTable(mentors);
        view.getEmptyInput();
    }
}
