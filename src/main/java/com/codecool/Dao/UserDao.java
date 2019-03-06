package com.codecool.Dao;

import com.codecool.Model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    void delete(int ids);
    void add(String name, String surname, String mail, String loginID);
    void edit(int id);
}
