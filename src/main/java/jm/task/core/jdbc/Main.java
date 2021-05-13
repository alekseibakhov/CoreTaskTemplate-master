package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        UserDao us = new UserDaoJDBCImpl();
        us.createUsersTable();
        us.saveUser("Alex", "Bakhov", (byte) 4);
        us.saveUser("Lexa", "Bahcha", (byte) 6);
        us.saveUser("Alexa", "Bakhova", (byte) 118);
        us.saveUser("Java", "Mentor", (byte) 118);
        us.getAllUsers();
        us.cleanUsersTable();
        us.dropUsersTable();





    }
}
