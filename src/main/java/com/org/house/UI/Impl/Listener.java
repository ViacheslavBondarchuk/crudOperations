package com.org.house.UI.Impl;

import com.org.house.dao.impl.CrudUserImpl;
import com.org.house.model.User;
import com.org.house.service.UserService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 *author : viacheslav
 *time : 16:43
 *date : 01.12.19
 ***/
public class Listener implements ActionListener {
    private UserService userService = new UserService(new CrudUserImpl());
    private ComboBoxImpl comboBox = ComboBoxImpl.getInstance();
    private TextFieldInpl dataField = PanelImpl.getDataField();
    private final String TABLE = "users";
    private static Listener listener;

    public static Listener getInstance() {
        if (listener == null) {
            listener = new Listener();
        }
        return listener;
    }

    private User createUser(final String[] data){
        return User.builder()
                .setId(Integer.parseInt(data[0]))
                .setUsername(data[1])
                .setPassword(data[2])
                .setFirstName(data[3])
                .setLastName(data[4])
                .build();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String[] data = dataField.getText().split(",");
        switch (actionEvent.getActionCommand()) {
            case "Execute":
                switch (String.valueOf(comboBox.getSelectedItem())) {
                    case "create":
                        userService.create(createUser(data),TABLE);
                        break;
                    case "read":
                        System.out.println("read");
                        break;
                    case "update":
                        System.out.println("update");
                        break;
                    case "delete":
                        System.out.println("delete");
                        break;
                    case "readAll":
                        System.out.println("readAll");
                        break;
                }
        }
    }
}
