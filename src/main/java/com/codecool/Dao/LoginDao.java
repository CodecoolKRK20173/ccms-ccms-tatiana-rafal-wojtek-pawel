package com.codecool.Dao;

import com.codecool.Model.Employee;

public interface LoginDao {
    Employee getUserByLogin(String mentorLogin, String mentorPassword);
}
