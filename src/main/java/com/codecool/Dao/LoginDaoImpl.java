package com.codecool.Dao;

import com.codecool.Model.User;

import java.util.List;

public class LoginDaoImpl implements LoginDao{

    List<User> users;

    public List<User> getUsers() {
        return this.users;
    }

    public User getUserByLogin(String login) {
        return users.get(0);//edit it
    }
}
