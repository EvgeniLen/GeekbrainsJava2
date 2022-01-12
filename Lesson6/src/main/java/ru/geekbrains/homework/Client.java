package ru.geekbrains.homework;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    private static final String SERVER_ADR = "localhost";
    private static final int PORT = 8189;
    private static Socket socket;

    public static void main(String[] args) {
        try {
            socket = new Socket(SERVER_ADR, PORT);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scFromClient = new Scanner(System.in);

            new Thread(() -> {
                while (true){
                    String strFromServ = in.nextLine();
                    System.out.println("Server: " + strFromServ);
                }
            }).start();

            while (true){
                String strFromClient = scFromClient.nextLine();
                if (strFromClient.equalsIgnoreCase("/end")){
                    break;
                }
                out.println(strFromClient);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
