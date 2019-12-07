package com.org.house.UI.Impl;

import com.org.house.UI.PanelAbstract;

/***
 *author : viacheslav
 *time : 16:52
 *date : 01.12.19
 ***/
public class PanelImpl extends PanelAbstract {
    private Listener listener = Listener.getInstance();
    private ComboBoxImpl comboBox = ComboBoxImpl.getInstance();
    private static TextFieldInpl dataField = new TextFieldInpl(10, 85, 360, 25);

    public static TextFieldInpl getDataField() {
        return dataField;
    }

    public PanelImpl() {
        super(0, 0, 400, 200);

        add(new LabelImpl("Operation", 10, 10, 360, 25));
        add(new LabelImpl("Data", 10, 60, 360, 25));
        add(dataField);
        add(comboBox);

        //buttons
        add(new ButtonImpl("Execute", 100, 25, 10, 125, listener));
        add(new ButtonImpl("Exit", 100, 25, 280, 125, listener));

    }
}
