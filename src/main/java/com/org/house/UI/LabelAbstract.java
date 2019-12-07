package com.org.house.UI;

import javax.swing.*;

/**
 * author: Viacheslav
 * date: 07.12.2019
 * time: 15:45
 **/
public abstract class LabelAbstract extends JLabel {
    public LabelAbstract(String text, int x, int y, int width, int height) {
        super(text);

        setBounds(x, y, width, height);
    }
}
