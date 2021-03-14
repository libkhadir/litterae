package com.github.libkhadir.actions;

import com.github.libkhadir.controllers.AppController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SendAction implements MouseListener {
    AppController appController;

    public SendAction(final AppController appController) {
        this.appController = appController;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        appController.send();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
