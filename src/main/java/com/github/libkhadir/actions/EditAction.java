package com.github.libkhadir.actions;

import com.github.libkhadir.controllers.AppController;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EditAction implements DocumentListener {
    private AppController appController;

    public EditAction(final AppController appController) {
        this.appController = appController;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        appController.update(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        appController.update(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        appController.update(e);
    }


}
