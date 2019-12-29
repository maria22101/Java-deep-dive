package examples_code.work_with_database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Ex {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "****";

    public static void main(String[] args) {
        Connection connection;
        Driver driver;

        try {
            driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            if(!connection.isClosed()) {
                System.out.println("Connection to the databese is set up.");
            }

            connection.close();

            if(connection.isClosed()) {
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Driver not registered");
        }
    }
}
