package com.org.house.service;

import com.org.house.annotation.Transaction;
import com.org.house.dao.impl.CrudUserImpl;
import com.org.house.model.User;

import java.sql.SQLException;
import java.util.List;

/***
 *author : viacheslav
 *time : 23:26
 *date : 28.11.19
 ***/
public class UserService extends AbstractService<User, CrudUserImpl> {
    public UserService(CrudUserImpl repository) {
        super(repository);
    }

    @Override
    public User getByUsername(String username, String table) {
        return super.getByUsername(username, table);
    }

    @Override
    public void create(User user, String table) {
        super.create(user, table);
    }

    @Override
    @Transaction
    public void updateByUsername(User user, String table, String username) {
        super.updateByUsername(user, table, username);
    }

    @Override
    public void deleteByUsername(String table, String username) {
        super.deleteByUsername(table, username);
    }

    @Override
    public List<User> getAll(String table) {
        return super.getAll(table);
    }

    @Override
    public void rollback() throws SQLException {
        super.rollback();
    }
}
