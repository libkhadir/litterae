package com.github.libkhadir.ui;

import com.github.libkhadir.actions.EditAction;
import com.github.libkhadir.actions.SendAction;
import com.github.libkhadir.controllers.AppController;
import com.github.libkhadir.utils.ConfigHelper;

import javax.swing.*;
import java.awt.*;

public class LitteraeFrame extends JFrame {

    AppController appController = new AppController();

    public LitteraeFrame() {
        getContentPane().add(new JScrollPane(initMainPanel()), BorderLayout.CENTER);
        setSize(500, 500);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel initMainPanel() {
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        JTextArea editorArea = new JTextArea();
        editorArea.getDocument().addDocumentListener(new EditAction(appController));
        main.add(editorArea, BorderLayout.CENTER);
        JButton sendButton = new JButton(ConfigHelper.getValue("app.send"));
        sendButton.addMouseListener(new SendAction(appController));
        main.add(sendButton, BorderLayout.SOUTH);
        return main;
    }
}
