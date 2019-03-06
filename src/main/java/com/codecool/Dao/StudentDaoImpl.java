package com.codecool.Dao;

import com.codecool.Model.User;

import java.sql.Statement;
import java.util.List;

public class StudentDaoImpl implements UserDao {
    private DatabaseConnector databaseConnector;

    public StudentDaoImpl(){
        this.databaseConnector = DatabaseConnector.getInstance();
    }



    @Override
    public  List<User> getAll(){
       Statement stmt = null;

       try{
           databaseConnector.connectToDatabase();
       }


    }


}
