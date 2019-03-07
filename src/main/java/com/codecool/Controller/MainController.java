package com.codecool.Controller;



import com.codecool.Service.LoginService;
import com.codecool.View.View;

public class MainController {
    private LoginService loginService;
    private boolean isRunning;
    private View view;
    private int userInput;


    public MainController() {
        isRunning = true;
        view = new View();
        loginService = new LoginService();
    }

    public void handleLoginController() {
        view.clearScreen();
        while(isRunning) {
            view.displayMainMenu();
            userInput = view.getIntegerInput();
            switch (userInput) {
                case 1:
                    loginService.chooseController();
                    break;
                case 2:
                    isRunning = false;
                    break;
                default:
                    view.displayMessage(view.getWrongInput);
                    break;
            }
        }
    }
}
