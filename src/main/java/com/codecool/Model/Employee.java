package com.codecool.Model;

public class Employee {
    int id;
    String name;
    String surname;
    String email;
    String accessRights;
    // String accessRights
    public Employee(int id, String name, String surname, String email, String accessRights) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.accessRights =accessRights;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAccessRights() {
        return accessRights;
    }
}
