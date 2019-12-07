package com.org.house.UI.Impl;


import com.org.house.UI.ComboBoxAbstract;

/***
 *author : viacheslav
 *time : 17:11
 *date : 01.12.19
 ***/
public class ComboBoxImpl extends ComboBoxAbstract {
    private static final String[] values = new String[]{"create", "read", "update", "delete", "readAll"};
    private static ComboBoxImpl instance;

    public ComboBoxImpl(String[] items, int x, int y, int width, int height) {
        super(items, x, y, width, height);
        setEditable(false);
    }

    public static ComboBoxImpl getInstance() {
        if (instance == null) {
            instance = new ComboBoxImpl(values, 10, 35, 360, 25);
        }
        return instance;
    }
}
