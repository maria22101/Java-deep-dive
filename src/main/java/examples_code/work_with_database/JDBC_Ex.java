package examples_code.work_with_database;

import java.sql.*;

public class JDBC_Ex {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "****";

    public static void main(String[] args) {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Driver not registered");
        }

        // try-with-resources example
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement()) {

            statement.execute("DELETE FROM users WHERE id=7");
            statement.executeUpdate("UPDATE users SET name='Ron' WHERE id=5");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
