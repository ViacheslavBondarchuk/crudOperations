package com.org.house.UI;

import javax.swing.*;

/**
  *author: Viacheslav
  *date: 06.12.2019
  *time:
 **/
public abstract class TextFieldAbstract extends JTextField {
    public TextFieldAbstract(int x, int y, int width, int height) {

        setBounds(x, y, width, height);
    }

    public TextFieldAbstract() {
    }
}
