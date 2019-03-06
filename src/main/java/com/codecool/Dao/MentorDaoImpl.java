package com.codecool.Dao;

import com.codecool.Model.Employee;

import java.util.List;

public class MentorDaoImpl implements UserDao{

    public List<Employee> mentors;

    public List<Employee> getAll() {
        return mentors;
    }

    public void delete(int id) {
    }

    public void add(String name, String surname, String mail, String loginID) {
    }

    public void edit(int id) {

    }

}
