package com.codecool.Dao;

import com.codecool.Model.User;

import java.util.List;

public class MentorDaoImpl implements UserDao{

    public List<User> mentors;

    public List<User> getAll() {
        return mentors;
    }

    public void delete(int id) {
    }

    public void add(String name, String surname, String mail, String loginID) {
    }

    public void edit(int id) {

    }

}
