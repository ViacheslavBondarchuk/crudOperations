package com.org.house.dao;

import java.sql.SQLException;
import java.util.List;

public interface Crud<T> {

    interface DataBaseConst {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USERNAME = "postgres";
        final String PASSWORD = "postgres";
        final String PATTERN_VALUES = "\'%s\', \'%s\',\'%s\',\'%s\',\'%s\'";
        final String COLUMNS = "(\'id\', \'username\',\'password\',\'firstname\',\'lastname\')";
    }

    void create(T t, final String table);

    void update(T t, final String table, final String username);

    void delete(final String table, final String username);

    T read(final String username, final String table);

    List<T> readAll(final String table);

    void rollback() throws SQLException;

    default void print() {
        System.out.println("********Please, implements the crud methods*********");
    }
}
