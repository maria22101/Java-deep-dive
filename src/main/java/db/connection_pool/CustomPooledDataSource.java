package db.connection_pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.postgresql.ds.PGSimpleDataSource;

import lombok.SneakyThrows;

/**
 * Class is implementation of a custom connection pool for 10 connections based on PGSimpleDataSource
 */
public class CustomPooledDataSource extends PGSimpleDataSource {
    private static final int POOL_SIZE = 10;
    private Queue<Connection> connectionPool;

    @SneakyThrows
    public CustomPooledDataSource(String url, String username, String password) {
        super();
        setURL(url);
        setUser(username);
        setPassword(password);
        connectionPool = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < POOL_SIZE; i++) {
            var physicalConnection = super.getConnection(); // real connection from postgres
            var connectionProxy = new CustomConnectionProxy(physicalConnection, connectionPool); // custom connection proxy
            connectionPool.add(connectionProxy);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return connectionPool.poll();
    }
}
