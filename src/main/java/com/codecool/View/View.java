package com.codecool.View;

import java.util.Scanner;

public class View {

    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void displayMessage(String message){
        System.out.println(message);
    }

    public String getStringInput(){
        return scanner.nextLine();
    }

    public int getIntegerInput() {
        while (!scanner.hasNextInt()) {
            displayMessage("Wrong input.");
            scanner.nextLine();
        }
        int num = scanner.nextInt();
        return num;
    }

    public void getEmptyInput() {
        displayMessage("Press enter to continue ");
        String input = scanner.nextLine();
    }

    public void displayMainMenu() {
        displayMessage("\n Welcome to CcMS!" +
                "\n 1. Log in" +
                "\n 2. Exit");
    }
}
