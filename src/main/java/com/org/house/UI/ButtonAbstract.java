package com.org.house.UI;

import javax.swing.*;
import java.awt.event.ActionListener;

/***
 *author : viacheslav
 *time : 16:39
 *date : 01.12.19
 ***/
public abstract class ButtonAbstract extends JButton {
    public ButtonAbstract(String text, int width, int height, final ActionListener actionListener) {
        super(text);

        setSize(width, height);
        addActionListener(actionListener);
    }

    public ButtonAbstract() {
    }
}
