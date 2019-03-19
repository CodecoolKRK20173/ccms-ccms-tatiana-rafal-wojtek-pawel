package com.codecool.Service;

import com.codecool.Controller.AdminController;
import com.codecool.Controller.EmployeeController;
import com.codecool.Controller.MentorController;
import com.codecool.Controller.StudentController;
import com.codecool.Dao.LoginDaoImpl;
import com.codecool.Model.Employee;
import com.codecool.Model.Student;
import com.codecool.View.View;

import java.sql.SQLException;

public class LoginService {

    private View view;
    private LoginDaoImpl loginDao;
    private boolean isLogining;
    private Employee user;
    private String mentor = "mentor";
    private String employee = "employee";
    private String admin = "admin";
    private String student = "student";
    private MentorController mentorController;
    private StudentController studentController;
    private AdminController adminController;
    private EmployeeController employeeController;

    public LoginService() {
        view = new View();
        loginDao = new LoginDaoImpl();
        isLogining = true;
    }

    public Employee login() throws SQLException {

            Employee employee = loginDao.getUserByLogin(view.getLogin(), view.getPassword());
            return employee;

    }


    public void chooseController() {
        try {
            view.clearScreen();
            user = login();
            if (user.getAccessRights().equals(mentor)) {
                mentorController = new MentorController();
                mentorController.handleMentorController();
            } else if (user.getAccessRights().equals(student)) {
                studentController = new StudentController(user);
                studentController.handleStudentController();
            } else if (user.getAccessRights().equals(admin)) {
                adminController = new AdminController();
                adminController.handleAdminController();
            } else if (user.getAccessRights().equals(employee)) {
                employeeController = new EmployeeController();
                //to do
            }
        }
        catch (SQLException e){
            System.out.println("There is no such account !");
            view.getEmptyInput();
        }

    }
}
