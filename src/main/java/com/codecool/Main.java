package com.codecool;


import com.codecool.Dao.CrudAssignmentsDaoImpl;

public class Main {
    public static void main(String[] args) {

        CrudAssignmentsDaoImpl dao = new CrudAssignmentsDaoImpl();
        dao.addAssignment("halo");
    }
}
