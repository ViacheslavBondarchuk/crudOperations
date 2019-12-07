package com.org.house.UI.Impl;

import com.org.house.dao.impl.CrudUserImpl;
import com.org.house.model.User;
import com.org.house.service.UserService;

import javax.swing.*;
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
    private TextFieldInpl usernameField = PanelImpl.getUsernameField();
    private final String TABLE = "users";
    private static Listener listener;

    public static Listener getInstance() {
        if (listener == null) {
            listener = new Listener();
        }
        return listener;
    }

    private User createUser(final String[] data) {
        return User.builder()
                .setId(Integer.parseInt(data[0]))
                .setUsername(data[1])
                .setPassword(data[2])
                .setFirstName(data[3])
                .setLastName(data[4])
                .build();
    }

    private void showMessage(StringBuffer stringBuffer, String title) {
        JOptionPane.showConfirmDialog(
                null
                , String.valueOf(stringBuffer)
                , title, JOptionPane.DEFAULT_OPTION
                , JOptionPane.INFORMATION_MESSAGE);
        stringBuffer.delete(0, stringBuffer.length());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String[] data = dataField.getText().split(",");
        StringBuffer stringBuffer = new StringBuffer();
        switch (actionEvent.getActionCommand()) {
            case "Execute":
                switch (String.valueOf(comboBox.getSelectedItem())) {
                    case "create":
                        userService.create(createUser(data), TABLE);
                        break;
                    case "read":
                        stringBuffer.append(userService.getByUsername(usernameField.getText().trim(), TABLE));
                        showMessage(stringBuffer, "Gotten user by username");
                        break;
                    case "update":
                        userService.updateByUsername(createUser(data), TABLE, usernameField.getText().trim());
                        stringBuffer.append(String.format("User by username: %s,  has been updated", usernameField.getText()));
                        showMessage(stringBuffer, "Updated");
                        break;
                    case "delete":
                        userService.deleteByUsername(TABLE, usernameField.getText().trim());
                        stringBuffer.append(String.format("User by username: %s,  has been deleted", usernameField.getText()));
                        showMessage(stringBuffer, "Updated");
                        break;
                    case "readAll":
                        userService.getAll(TABLE).forEach(user -> {
                            stringBuffer.append(user.toString());
                        });
                        showMessage(stringBuffer, "All users");
                        break;
                }
        }
    }
}
