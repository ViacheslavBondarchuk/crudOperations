package com.org.house.dao.impl;

import com.org.house.dao.Crud;
import com.org.house.model.User;
import com.org.house.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudUserImpl implements Crud<User> {
    private ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "postgres";
    private final String PATTERN_VALUES = "\'%s\', \'%s\',\'%s\',\'%s\',\'%s\'";
    private final String COLUMNS = "(\'id\', \'username\',\'password\',\'firstname\',\'lastname\')";


    @Override
    public void create(User user, final String table) {
        if (user != null && !table.equals("") && table != null) {
            try (Connection connection = connectionFactory.getConnection(URL, USERNAME, PASSWORD)) {
                connectionFactory.getStatement(connection).execute(
                        String.format("insert into %s values(" + PATTERN_VALUES + ");"
                                , table
                                , user.getId()
                                , user.getUsername()
                                , user.getPassword()
                                , user.getFirstName()
                                , user.getLastName()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(User user, final String table, final String username) {
        try (Connection connection = connectionFactory.getConnection(URL, USERNAME, PASSWORD)) {
            connectionFactory.getStatement(connection).execute(String.format(
                    "update %s" +
                            " set " +
                            "id = \'%s\'," +
                            "username = \'%s\'," +
                            " password = \'%s\'," +
                            "firstname = \'%s\'," +
                            "lastname = \'%s\'" +
                            "where username = \'%s\'"
                    , table
                    , user.getId()
                    , user.getUsername()
                    , user.getPassword()
                    , user.getFirstName()
                    , user.getLastName()
                    , username));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(final String table, final String username) {
        try (Connection connection = connectionFactory.getConnection(URL, USERNAME, PASSWORD)) {
            connectionFactory.getStatement(connection).execute(
                    String.format("delete from %s where username = \'%s\'", table, username));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User read(String username, final String table) {
        try (Connection connection = connectionFactory.getConnection(URL, USERNAME, PASSWORD)) {
            ResultSet resultSet = connection.prepareStatement(
                    String.format(
                            "select * from %s where username = \'%s\'", table, username),
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)
                    .executeQuery();
            resultSet.first();
            return new User(Long.parseLong(resultSet.getString("id")),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> readAll(final String table) {
        try (Connection connection = connectionFactory.getConnection(URL, USERNAME, PASSWORD)) {
            if (table != null && !table.equals("")) {
                ResultSet resultSet = connectionFactory.getStatement(connection)
                        .executeQuery(String.format("select * from %s", table));
                if (resultSet != null) {
                    List<User> users = new ArrayList<>();
                    while (resultSet.next()) {
                        users.add(new User(
                                Long.parseLong(resultSet.getString("id"))
                                , resultSet.getString("username")
                                , resultSet.getString("password")
                                , resultSet.getString("firstname")
                                , resultSet.getString("lastname")
                        ));
                    }
                    return users;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
