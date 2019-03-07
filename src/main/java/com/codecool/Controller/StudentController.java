package com.codecool.Controller;

import com.codecool.Service.StudentService;
import com.codecool.View.View;

public class StudentController {

    private View view;
    private boolean isRunning;
    private StudentService studentService;

    public StudentController() {
        view = new View();
        isRunning = true;
        studentService = new StudentService();
    }

    public void handleStudentController() {
        while(isRunning) {
            view.clearScreen();
            view.displayStudentMenu();
            handleStudentInput();
        }
    }

    public void handleStudentInput() {
        int userInput = view.getIntegerInput();
        view.clearScreen();
        switch (userInput) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                isRunning = false;
                break;
            default:
                break;

        }

    }

}
