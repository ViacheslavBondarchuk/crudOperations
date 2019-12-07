package com.org.house.UI.Impl;

import com.org.house.UI.WindowAbstract;

import java.awt.*;

/***
 *author : viacheslav
 *time : 16:30
 *date : 01.12.19
 ***/
public class WindowImpl extends WindowAbstract {

    public WindowImpl(String title, int width, int height) throws HeadlessException {
        super(title, width, height);
        add(new PanelImpl());
    }

    public WindowImpl() throws HeadlessException {
    }
}
