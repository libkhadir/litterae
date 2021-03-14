package com.github.libkhadir.controllers;

import com.github.libkhadir.process.Receiver;
import com.github.libkhadir.process.Sender;

import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;

public class AppController {
    private StringBuilder value = new StringBuilder();
    private static Sender sender;

    private String getText() {
        return value.toString();
    }

    public void update(DocumentEvent e) {
        try {
            value.setLength(0);
            value.append(e.getDocument().getText(0, e.getDocument().getLength()));
        } catch (BadLocationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void listen() {
        Thread receiver = new Thread(new Receiver());
        receiver.start();
    }

    public void send() {
        if (sender == null) {
            sender = new Sender();
        }
        sender.send(getText());
    }
}
