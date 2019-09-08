package com.sw.controller;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Mohammed
 */
public class TextFieldsManager implements DocumentListener
{

    private String text;
    private final JTextField jtextfield;
    private final JLabel jlabel;

    public TextFieldsManager(String text, JTextField jtextfield, JLabel jlabel)
    {
        this.text = text;
        this.jtextfield = jtextfield;
        this.jlabel = jlabel;
    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        text += jtextfield.getText();

        jlabel.setText("");

    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        text += jtextfield.getText();

        jlabel.setText("");

    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {

    }

    public String getText()
    {
        return text;
    }

}
