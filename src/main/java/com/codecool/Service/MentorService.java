package com.codecool.Service;

import com.codecool.Dao.CrudAssignmentsDaoImpl;
import com.codecool.Dao.StudentDaoImpl;
import com.codecool.View.View;

public class MentorService {

    private View view;
    private CrudAssignmentsDaoImpl assignmentsDao;
    private StudentDaoImpl studentsDao;

    public MentorService() {
        this.view = new View();
        this.assignmentsDao = new CrudAssignmentsDaoImpl();
        this.studentsDao = new StudentDaoImpl();
    }

    public void addNewAssignment() {
        view.displayMessage("Enter new assignment's title");
        String title = view.getStringInput();
        assignmentsDao.addAssignment(title);
    }
}
