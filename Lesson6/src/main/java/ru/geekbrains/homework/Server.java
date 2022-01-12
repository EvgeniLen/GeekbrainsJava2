package ru.geekbrains.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8189;
    private static Scanner in;
    private static PrintWriter out;
    private static Scanner scFromServer;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started!");
            socket = server.accept();
            System.out.println("Client connected!");

            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            scFromServer = new Scanner(System.in);

            new Thread(() -> {
                while (true) {
                    out.println(scFromServer.nextLine());
                }
            }).start();

            while (true) {
                String str = in.nextLine();
                if (str.equals("/end")) {
                    break;
                }
                System.out.println("Client: " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Client disconnect!");
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
