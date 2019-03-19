package com.codecool.Controller;

import com.codecool.Service.AdminService;
import com.codecool.Service.MentorService;
import com.codecool.View.View;

public class AdminController {
    private View view;
    private boolean isRunning;
    private AdminService adminService;

    public AdminController() {
        view = new View();
        isRunning = true;
        adminService = new AdminService();
    }

    public void handleAdminController() {
        while(isRunning) {
            view.clearScreen();
            view.displayAdminMenu();
            handleAdminInput();
        }
    }

    public void handleAdminInput() {
        int userInput = view.getIntegerInput();
        view.clearScreen();
        switch (userInput) {
            case 1: // list all mentors
                adminService.displayAllMentors();
                break;
            case 2: // add new mentor
                break;
            case 3: // edit mentor's data
                break;
            case 4: // remove mentor
                break;
            case 5: // list all students
                adminService.displayAllStudents();
                break;
            case 6: // exit
                isRunning = false;
                break;
            default:
                view.displayMessage("Enter correct option!");
                break;

        }

    }

}
