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
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                isRunning = false;
                break;
            default:
                break;

        }

    }

}
