package com.codecool.Controller;

import com.codecool.Service.EmployeeService;
import com.codecool.View.View;

public class EmployeeController {

    private View view;
    private boolean isRunning;
    private EmployeeService employeeService;

    public EmployeeController() {
        view = new View();
        isRunning = true;
        employeeService = new EmployeeService();
    }

    public void handleEmployeeController() {
        while (isRunning) {
            view.clearScreen();
            view.displayEmployeeMenu();
            handleEmployeeInput();
        }
    }

    public void handleEmployeeInput() {
        int userInput = view.getIntegerInput();
        view.clearScreen();
        switch (userInput) {
            case 1: //list all students
                employeeService.displayAllStudents();
                break;
            case 2: // exit
                isRunning = false;
                break;
            default:
                view.displayMessage("Enter correct option!");
                break;
        }
    }
}
