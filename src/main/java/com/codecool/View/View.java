package com.codecool.View;

import com.codecool.Model.Assignment;
import com.codecool.Model.Employee;
import com.codecool.Model.Student;

import java.util.HashMap;
import java.util.List;
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
            displayMessage(getWrongInput);
            scanner.nextLine();
        }
        int number = scanner.nextInt();
        return number;
    }

    public String getLogin() {
        displayMessage(getLogin);
        return getStringInput();
    }

    public String getPassword() {
        displayMessage(getPassword);
        return getStringInput();
    }

    public void displayMentorMenu() {
        displayMessage("Certification Candidate Management System:" +
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
        displayMessage("What would you like to do:" +
                    "\n 1. Log in" +
                    "\n 2. Exit");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void displayStudentsTable(List<Employee> students) {
        TableView table = new TableView();
        table.setShowVerticalLines(true);
        table.setHeaders("ID", "Name", "Surname", "Email", "Assignment/Grade");
        for (Employee student: students) {
            table.addRow(String.valueOf(student.getID()),
                                        student.getName(),
                                        student.getSurname(),
                                        student.getEmail(),
                                        assignmentsToString((Student) student));
        }
        table.print();
    }

    public String assignmentsToString(Student student) {
        StringBuilder sb = new StringBuilder();
        HashMap<Assignment, Integer> grades = student.getGrades();
        grades.forEach((key, value) -> sb.append(key.getTitle() + ": " + value + ", "));
        return sb.toString();
    }

    public void getEmptyInput() {
        displayMessage("Press enter to continue ");
        String input = scanner.nextLine();
    }
}
