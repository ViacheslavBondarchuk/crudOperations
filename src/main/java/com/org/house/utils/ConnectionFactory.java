package com.org.house.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    private static ConnectionFactory instance;
    Connection connection = null;

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection(final String url, final String username, final String password) throws SQLException {
        if (connection == null) {
            return connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public Statement getStatement(final Connection connection) throws SQLException {
        return connection.createStatement();
    }

}
