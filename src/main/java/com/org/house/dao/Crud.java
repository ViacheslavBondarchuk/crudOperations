package com.org.house.dao;

import java.util.List;

public interface Crud<T> {

    void create(T t, final String table);

    void update(T t, final String table, final String username);

    void delete(final String table, final String username);

    T read(final String username, final String table);

    List<T> readAll(final String table);


    default void print() {
        System.out.println("********Please, implements the crud methods*********");
    }
}
