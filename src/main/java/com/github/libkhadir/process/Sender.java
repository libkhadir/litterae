package com.github.libkhadir.process;

import com.github.libkhadir.utils.ConfigHelper;
import com.github.libkhadir.utils.EncryptionHelper;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Sender {
    private static Socket socket;
    private static BufferedWriter socketWriter;

    private Socket connect() throws IOException {
        return new Socket(ConfigHelper.getValue("app.clientIp"),ConfigHelper.getIntValue("app.clientPort"));
    }

    public void send(final String message) {
            try {
                if (socket == null) socket = connect();
                if (socket.isConnected()) System.out.println("connected to server with success");
                if (socketWriter == null) socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                final String sentMsg = EncryptionHelper.encrypt(message);
                socketWriter.write(sentMsg);
                socketWriter.write("\n");
                socketWriter.flush();
                System.out.println("message sent with success " + sentMsg);
            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
    }

    public static void close() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("client connection closed");
    }
}
