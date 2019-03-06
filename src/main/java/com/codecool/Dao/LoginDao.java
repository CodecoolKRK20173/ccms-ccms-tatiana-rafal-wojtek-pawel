package com.codecool.Dao;

import com.codecool.Model.Employee;

import java.util.List;

public interface LoginDao {
    List<Employee> getUsers();
    Employee getUserByLogin(String login);
}
