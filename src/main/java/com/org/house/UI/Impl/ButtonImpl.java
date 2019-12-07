package com.org.house.UI.Impl;


import com.org.house.UI.ButtonAbstract;

import java.awt.event.ActionListener;

/***
 *author : viacheslav
 *time : 16:42
 *date : 01.12.19
 ***/
public class ButtonImpl extends ButtonAbstract {
    public ButtonImpl(String text, int width, int height,
                      int x, int y, ActionListener actionListener) {
        super(text, width, height, actionListener);
        setLocation(x, y);
    }

    public ButtonImpl() {
    }
}
