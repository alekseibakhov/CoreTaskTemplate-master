package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = new Util().getConnection();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS UsersTable\n" +
                "( id int PRIMARY KEY AUTO_INCREMENT,\n" +
                "  name char(50) NOT NULL,\n" +
package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = new Util().getConnection();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS UsersTable\n" +
                "( id int PRIMARY KEY AUTO_INCREMENT,\n" +
                "  name char(50) NOT NULL,\n" +
                "  lastName char(50),\n" +
                "  age int\n" +
                ") ;";

        try (Statement statement = connection.createStatement()) {

            statement.execute(sql);
            System.out.println("Таблица UsersTable создана");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void dropUsersTable() {

        String sqlDel = "DROP TABLE IF EXISTS UsersTable";

        try (Statement statement = connection.createStatement()) {

            statement.execute(sqlDel);
            System.out.println("Удалена таблица UsersTable");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void saveUser(String name, String lastName, byte age) {
        createUsersTable();


        String sqlSave = "INSERT INTO UsersTable (name, lastName, age) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlSave)) {
            connection.setAutoCommit(false);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
            System.out.println("Пользователь " + name + " добавлен");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void removeUserById(long id) {

        String sqlRem = "DELETE FROM UsersTable WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRem)) {
            connection.setAutoCommit(false);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();

            System.out.println("Удален пользователь с ID = " + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList();
        String sqrGet = "SELECT id, name, lastName, age FROM UsersTable";


        try (Statement statement = connection.createStatement()) {
            createUsersTable();
            connection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery(sqrGet);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                list.add(user);
                connection.commit();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public void cleanUsersTable() {
        String sqlClean = "TRUNCATE TABLE userstable";
        try (Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            createUsersTable();
            statement.execute(sqlClean);
            connection.commit();
            System.out.println("Таблица очищена");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
"  lastName char(50),\n" +
                "  age int\n" +
                ") ;";

        try (Statement statement = connection.createStatement()) {

            statement.execute(sql);
            System.out.println("Таблица UsersTable создана");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void dropUsersTable() {

        String sqlDel = "DROP TABLE IF EXISTS UsersTable";

        try (Statement statement = connection.createStatement()) {

            statement.execute(sqlDel);
            System.out.println("Удалена таблица UsersTable");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void saveUser(String name, String lastName, byte age) {
        createUsersTable();


        String sqlSave = "INSERT INTO UsersTable (name, lastName, age) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlSave)) {
            connection.setAutoCommit(false);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
            System.out.println("Пользователь " + name + " добавлен");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void removeUserById(long id) {

        String sqlRem = "DELETE FROM UsersTable WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRem)) {
            connection.setAutoCommit(false);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.commit();

            System.out.println("Удален пользователь с ID = " + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList();
        String sqrGet = "SELECT id, name, lastName, age FROM UsersTable";


        try (Statement statement = connection.createStatement()) {
            createUsersTable();
            connection.setAutoCommit(false);
            ResultSet resultSet = statement.executeQuery(sqrGet);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                list.add(user);
                connection.commit();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public void cleanUsersTable() {
        String sqlClean = "TRUNCATE TABLE userstable";
        try (Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            createUsersTable();
            statement.execute(sqlClean);
            connection.commit();
            System.out.println("Таблица очищена");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
