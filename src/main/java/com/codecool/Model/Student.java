package com.codecool.Model;

import java.util.HashMap;
import java.util.Map;

public class Student extends Employee{
    private HashMap<Assignment, Integer> grades;

    public Student(int id, String name, String surname, String email, String accessRights, HashMap<Assignment, Integer> grades){
        super(id, name, surname, email, accessRights);
        this.grades = grades;
    }

    public HashMap<Assignment, Integer> getGrades() {
        return grades;
    }

    public void setGrades(HashMap<Assignment, Integer> grades) {
        this.grades = grades;
    }
}
