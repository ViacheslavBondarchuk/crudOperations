package com.org.house.UI;

import javax.swing.*;

/***
 *author : viacheslav
 *time : 17:09
 *date : 01.12.19
 ***/
public abstract class ComboBoxAbstract extends JComboBox {
    public ComboBoxAbstract(Object[] items, int x, int y, int width, int height) {
        super(items);

        setEditable(false);
        setBounds(x, y, width, height);
    }

    public ComboBoxAbstract() {
    }
}
