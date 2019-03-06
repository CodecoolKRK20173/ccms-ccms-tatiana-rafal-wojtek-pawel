package com.codecool.Dao;

import com.codecool.Model.Employee;

import java.util.List;

public interface UserDao {
    List<Employee> getAll();
    void delete(int ids);
    void add(String name, String surname, String mail, String loginID);
    void edit(int id);
}
