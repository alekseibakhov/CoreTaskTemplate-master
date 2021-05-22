package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private final String USERNAME = "root1234";
    private final String PASSWORD = "1234";
    private static SessionFactory sessionFactory = null;


    public Connection getConnection () {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getConnectionHibernate() throws HibernateException {
        Configuration configuration = new Configuration();

        Properties properties = new Properties();

        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, URL);
        properties.put(Environment.USER, USERNAME);
        properties.put(Environment.PASS, PASSWORD);
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(properties).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
}
