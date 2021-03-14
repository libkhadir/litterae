package com.github.libkhadir;

import com.github.libkhadir.controllers.AppController;
import com.github.libkhadir.process.Receiver;
import com.github.libkhadir.process.Sender;
import com.github.libkhadir.ui.LitteraeFrame;

public class LitteraeApplication {

    public static void main(String[] args) {
        new LitteraeFrame();
        AppController.listen();
        Runtime.getRuntime().addShutdownHook(new Thread(Sender::close));
        Runtime.getRuntime().addShutdownHook(new Thread(Receiver::close));
    }
}
