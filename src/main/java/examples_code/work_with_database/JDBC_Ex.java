package examples_code.work_with_database;

import java.sql.*;

public class JDBC_Ex {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "****";

    public static final String INSERT_NEW = "INSERT INTO users VALUES(?, ?, ?, ?)";
    public static final String DELETE = "DELETE FROM users WHERE name=?";

    public static void main(String[] args) {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Driver not registered");
        }

        // try-with-resources example
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_NEW);
             PreparedStatement preparedStatement2 = connection.prepareStatement(DELETE);
                ) {

//            statement.execute("DELETE FROM users WHERE id=7");
//            statement.executeUpdate("UPDATE users SET name='Ron' WHERE id=5");

            preparedStatement1.setInt(1, 8);
            preparedStatement1.setString(2, "Adele");
            preparedStatement1.setInt(3, 35);
            preparedStatement1.setString(4, "ade@gmail.com");
            preparedStatement1.execute();

            preparedStatement2.setString(1, "Rick");
            preparedStatement2.execute();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.printf("%d: %s %s", id, name, email);
                System.out.println();
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
