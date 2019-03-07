package com.codecool.Service;

import com.codecool.Dao.CrudAssignmentsDaoImpl;
import com.codecool.Dao.MentorDaoImpl;
import com.codecool.Dao.StudentDaoImpl;
import com.codecool.View.View;

public class MentorService {

    private View view;
    private CrudAssignmentsDaoImpl assignmentsDao;
    private MentorDaoImpl mentorDao;

    public MentorService() {
        this.view = new View();
        this.assignmentsDao = new CrudAssignmentsDaoImpl();
        this.mentorDao = new MentorDaoImpl();
    }

    public void addNewAssignment() {
        view.displayMessage("Enter new assignment's title");
        String title = view.getStringInput();
        assignmentsDao.addAssignment(title);
    }

    public void removeStudent() {
        view.displayMessage("Enter student's ID you want to remove");
        int id = view.getIntegerInput();
        mentorDao.delete(id);
    }
}
