package com.codecool.Service;

import com.codecool.Dao.MentorDaoImpl;
import com.codecool.Dao.StudentDaoImpl;
import com.codecool.Model.Employee;
import com.codecool.View.View;

import java.util.List;

public class AdminService {
    private View view;
    private MentorDaoImpl mentorDao;
    private StudentDaoImpl studentDao;

    public AdminService() {
        this.view = new View();
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

    public void editMentor() {
        displayAllMentors();
        view.displayMessage("Enter mentor id you want to edit:");
        int id = view.getIntegerInput();
        view.displayMessage("Enter column name you want to edit (Name / Surname / Mail):");
        String columnName = view.getStringInput();
        if (columnName.equals("Name")) {
            columnName = "FirstName";
        } else if (columnName.equals("Surname")) {
            columnName = "SecondName";
        }
        view.displayMessage("Enter new value:");
        String update = view.getStringInput();
        mentorDao.edit(id, columnName, update);
        view.displayMessage("Mentor updated successfully!");

    }
}
