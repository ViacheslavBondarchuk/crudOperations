package com.org.house.utils;

import java.sql.*;

public class ConnectionFactory {
    private static ConnectionFactory instance;

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection(final String url, final String username, final String password) throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public Statement getStatement(final Connection connection) throws SQLException {
        return connection.createStatement();
    }

}
