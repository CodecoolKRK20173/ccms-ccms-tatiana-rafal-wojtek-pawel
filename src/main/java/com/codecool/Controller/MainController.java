package com.codecool.Controller;

import com.codecool.View.View;

public class MainController {

    private boolean isRunning;
    private View view;

    public MainController() {
        this.isRunning = true;
        this.view = new View();
    }

    public void startMainController() {
        view.clearScreen();
        view.displayMainMenu();
        int userInput = view.getIntegerInput();
        switch (userInput) {
            case 1:
                view.displayMessage("hello");
                break;
            case 2:
                isRunning = false;
                break;
            default:
                view.displayMessage("Wrong input!");
                break;
        }
    }
}
