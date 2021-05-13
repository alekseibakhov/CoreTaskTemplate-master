package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private final String USERNAME = "root1234";
    private final String PASSWORD = "1234";

    public Connection getConnection () {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
//
//        Driver driver = null;
//        try {
//            driver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//             Statement statement = connection.createStatement()) {
//            statement.execute("INSERT into users (name, age, email) values ('telka', 24, 'badu@inbox.ru');");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }
}
