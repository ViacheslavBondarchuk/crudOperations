package com.org.house.UI;

import javax.swing.*;
import java.awt.*;

/***
 *author : viacheslav
 *time : 16:29
 *date : 01.12.19
 ***/
public abstract class WindowAbstract extends JFrame {
    public WindowAbstract(String title, int width, int height) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(width, height);
        setResizable(false);
        setVisible(true);
        setLayout(null);
    }

    public WindowAbstract() throws HeadlessException {
    }
}
