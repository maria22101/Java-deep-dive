package db.connection_pool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.SneakyThrows;

/**
 * Class configures and utilizes connection pool from HikariDataSource
 */
public class HikariConnectionPool {

    private static DataSource dataSource;

    private static final String URL = "jdbc:postgresql://93.175.204.87:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    public static void main(String[] args) throws SQLException {
        initializeHikariCPDataSource();

        try(var connection = dataSource.getConnection()) {
            var statement = connection
                    .prepareStatement("INSERT INTO notes (body, person_id) VALUES (?, ?)");
            statement.setString(1, "need cup of coffee");
            statement.setInt(2, 16);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try(Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from persons");
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(firstName + " " + lastName);
            }
        }
    }

    @SneakyThrows
    private static void initializeHikariCPDataSource() {
        var properties = new Properties();
        var propFileInputStream = HikariConnectionPool.class
                .getClassLoader()
                .getResourceAsStream("hikari.properties"); // a way how to read values from a property file in a maven project
        properties.load(propFileInputStream);
        var config = new HikariConfig(properties);
        dataSource = new HikariDataSource(config);

        //optionally configs can be configured not from property file, but via
        //config.setJdbcUrl, config.setUserName...
    }
}
