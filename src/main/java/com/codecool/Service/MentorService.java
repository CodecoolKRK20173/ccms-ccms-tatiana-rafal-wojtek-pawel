package com.codecool.Service;

import com.codecool.Dao.CrudAssignmentsDaoImpl;
import com.codecool.Dao.MentorDaoImpl;
import com.codecool.Dao.StudentDaoImpl;
import com.codecool.Model.Employee;
import com.codecool.Model.Student;
import com.codecool.View.View;

import java.util.List;

public class MentorService {

    private View view;
    private CrudAssignmentsDaoImpl assignmentsDao;
    private MentorDaoImpl mentorDao;
    private StudentDaoImpl studentDao;

    public MentorService() {
        this.view = new View();
        this.assignmentsDao = new CrudAssignmentsDaoImpl();
        this.mentorDao = new MentorDaoImpl();
        this.studentDao = new StudentDaoImpl();
    }

    public void addNewAssignment() {
        view.displayMessage("Enter new assignment's title");
        String title = view.getStringInput();
        assignmentsDao.addAssignment(title);
    }

    public void removeAssignment() {
        view.displayMessage("Enter assignment's ID you want to remove");
        int id = view.getIntegerInput();
        assignmentsDao.deleteAssignment(id);
    }

    public void removeStudent() {
        view.displayMessage("Enter student's ID you want to remove");
        int id = view.getIntegerInput();
        mentorDao.delete(id);
    }

    public void displayAllStudents() {
        List<Employee> students = studentDao.getAll();
        view.displayStudentsTable(students);
    }
}
