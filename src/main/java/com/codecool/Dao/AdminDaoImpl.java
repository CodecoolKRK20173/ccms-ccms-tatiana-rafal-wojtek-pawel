package com.codecool.Dao;

import com.codecool.Model.User;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AdminDaoImpl implements UserDao{
    DatabaseConnector databaseConnector;

    public ProductDao() {
        databaseConnector = DatabaseConnector.getInstance();
        try {
            createTables();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void createTables() throws DAOException {
        String Query = "CREATE TABLE IF NOT EXISTS Admin("

                + "id INTEGER PRIMARY KEY, "
                + "mail TEXT NOT NULL, "
                + "loginid INTEGER NOT NULL)";


        try {
            databaseConnector.connectToDatabase();
            Statement statement = databaseConnector.getConnection().createStatement();
            statement.executeUpdate(productQuery);
            statement.executeUpdate(categoryQuery);
            statement.executeUpdate(featuredQuery);
            databaseConnector.c.close();
        } catch (SQLException e) {
            throw new DAOException("Cannot create tables");
        }
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void delete(int ids) {

    }

    @Override
    public void add(String name, String surname, String mail, String loginID) {

    }

    @Override
    public void edit(int id) {

    }
}
