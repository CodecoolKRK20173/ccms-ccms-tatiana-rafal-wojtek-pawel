package com.codecool.Controller;

import com.codecool.Service.MentorService;
import com.codecool.View.View;

public class MentorController {
    private View view;
    private boolean isRunning;
    private MentorService mentorService;

    public MentorController() {
        view = new View();
        isRunning = true;
        mentorService = new MentorService();
    }

    public void handleMentorController() {
        while(isRunning) {
            view.clearScreen();
            view.displayMentorMenu();
            handleMentorInput();
        }
    }

    public void handleMentorInput() {
        int userInput = view.getIntegerInput();
        view.clearScreen();
        switch (userInput) {
            case 1: // list all students
                mentorService.displayAllStudents();
                break;
            case 2: // add new assignment
                mentorService.addNewAssignment();
                break;
            case 3: // grade an assignment
                break;
            case 4: // check attendance
                break;
            case 5: // add new student
                break;
            case 6: // remove a student
                mentorService.removeStudent();
                break;
            case 7: // edit student data
                break;
            case 8: // exit
                isRunning = false;
                break;
            default:
                break;

        }

    }

}
