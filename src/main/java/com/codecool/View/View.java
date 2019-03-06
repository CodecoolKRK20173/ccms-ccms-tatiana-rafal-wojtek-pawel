package com.codecool.View;

import java.util.Scanner;

public class View {

    public Scanner scanner;
    private final String getLogin = "Enter your login:\n";
    private final String getPassword = "Enter your Password:\n";
    public final String getWrongInput = "Wrong input, try again!";

    public View() {
        scanner = new Scanner(System.in);
    }

    public String getStringInput() {
        return scanner.nextLine();
    }

    public Integer getIntegerInput() {
        while(!scanner.hasNextInt()) {
            showMessage(getWrongInput);
            scanner.nextLine();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public String getLogin() {
        showMessage(getLogin);
        return getStringInput();
    }

    public String getPassword() {
        showMessage(getPassword);
        return getStringInput();
    }

    public void displayMentorMenu() {
        showMessage("Certification Candidate Management System:" +
                    "\n (1) List students" +
                    "\n (2) Add an assignment" +
                    "\n (3) Grade an assignment submitted by students" +
                    "\n (4) Check an attendance of students" +
                    "\n (5) Add a student to a class" +
                    "\n (6) Remove a student from a class" +
                    "\n (7) Edit student's data" +
                    "\n (8) Exit");
    }

    public void displayMainMenu() {
        showMessage("What would you like to do:" +
                    "\n 1. Log in" +
                    "\n 2. Create new user" +
                    "\n 3. Exit.");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
