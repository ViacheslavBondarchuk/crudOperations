package com.org.house.UI;

import javax.swing.*;

/***
 *author : viacheslav
 *time : 16:51
 *date : 01.12.19
 ***/
public abstract class PanelAbstract extends JPanel {
    public PanelAbstract(int x, int y, int width, int height) {
        setLayout(null);

        setBounds(x, y, width, height);
    }

    public PanelAbstract() {
    }
}
