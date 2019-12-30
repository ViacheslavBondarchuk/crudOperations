package com.org.house.service;

import com.org.house.dao.Crud;

import java.sql.SQLException;
import java.util.List;

/***
 *author : viacheslav
 *time : 15:59
 *date : 01.12.19
 ***/
public abstract class AbstractService<T, R extends Crud<T>> {
    private R repository;

    public AbstractService(R repository) {
        this.repository = repository;
    }

    public T getByUsername(final String username, final String table) {
        return repository.read(username, table);
    }

    public void create(final T t, final String table) {
        repository.create(t, table);
    }

    public void updateByUsername(T t, final String table, final String username) {
        repository.update(t, table, username);
    }

    public void deleteByUsername(final String table, final String username) {
        repository.delete(table, username);
    }

    public List<T> getAll(final String table) {
        return repository.readAll(table);
    }

    public void rollback() throws SQLException {
        repository.rollback();
    }

}
