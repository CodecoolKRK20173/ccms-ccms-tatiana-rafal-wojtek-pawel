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

    public void addNewMentor() {
        view.displayMessage("Enter new mentor's name:");
        String name = view.getStringInput();
        view.displayMessage("Enter new mentor's surname:");
        String surname = view.getStringInput();
        view.displayMessage("Enter new mentor's mail:");
        String mail = view.getStringInput();
        mentorDao.add(name, surname, mail, name, "qwerty");
    }

    public void removeMentor() {
        displayAllMentors();
        view.displayMessage("Enter mentor id you want to remove:");
        int id = view.getIntegerInput();
        mentorDao.delete(id);
    }
}
