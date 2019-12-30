package com.org.house.annotation.impl;

import com.org.house.annotation.Transaction;
import com.org.house.service.AbstractService;
import com.org.house.utils.ConnectionFactory;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import static com.org.house.dao.Crud.DataBaseConst.*;

public class TransactionImpl {
    private static TransactionImpl instance;
    private boolean commit = true;

    public static TransactionImpl getInstance() {
        if (instance == null) {
            instance = new TransactionImpl();
        }
        return instance;
    }

    public void run() {
        Reflections reflections = new Reflections("com.org.house.service");
        Set<Class<? extends AbstractService>> objects = reflections.getSubTypesOf(AbstractService.class);
        for (Class clazz : objects) {
            if (!commit) return;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Transaction.class)) {
                    Transaction transaction = method.getAnnotation(Transaction.class);
                    if (transaction.enable()) {
                        try {
                            commit = false;
                            Connection connection = ConnectionFactory.getInstance().getConnection(URL, USERNAME, PASSWORD);
                            if (connection != null) {
                                connection.setAutoCommit(false);
                                System.out.println("----------------Autocommit turn off--------------------");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
