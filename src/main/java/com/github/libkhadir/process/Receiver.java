package com.github.libkhadir.process;

import com.github.libkhadir.utils.ConfigHelper;
import com.github.libkhadir.utils.EncryptionHelper;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver implements Runnable{
    private static ServerSocket serverSocket;

    private void wakeUp() throws IOException {
        serverSocket = new ServerSocket(ConfigHelper.getIntValue("app.listeningPort"), 100, InetAddress.getByName("localhost"));
        System.out.println("Server started  at:  " + serverSocket);
    }

    public static void handleClientRequest(Socket socket) {
        try{
            BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = null;
            while ((message = socketReader.readLine()) != null) {
                System.out.println("Received from  client: " + EncryptionHelper.decrypt(message));
            }
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void close() {
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("end listening server");
    }

    @Override
    public void run() {
        try {
            wakeUp();
            while (true) {
                System.out.println("Waiting for a  connection...");
                final Socket activeSocket = serverSocket.accept();
                System.out.println("Received a  connection from  " + activeSocket);
                Runnable runnable = () -> handleClientRequest(activeSocket);
                new Thread(runnable).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
