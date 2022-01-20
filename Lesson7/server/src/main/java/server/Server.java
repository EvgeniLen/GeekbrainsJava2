package server;

import service.ServiceMessages;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8190;

    private List<ClientHandler> clients;
    private AuthService authService;

    public Server() {
        authService = new SimpleAuthService();
        clients = new CopyOnWriteArrayList<>();

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started!");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Server stop");
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
        broadcastClientList();
    }

    public void broadcastMsg(ClientHandler sender, String msg){
        String message = String.format("[ %s ]: %s", sender.getNickname(), msg);
        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    public void sendPrivateMsg(ClientHandler sender, String receiver, String msg) {
        String message = String.format("[ %s ] to [ %s ]: %s", sender.getNickname(), receiver, msg);
        for (ClientHandler c : clients) {
            if (c.getNickname().equals(receiver)) {
                c.sendMsg(message);
                if (!sender.getNickname().equals(receiver)) {
                    sender.sendMsg(message);
                }
                return;
            }
        }
        sender.sendMsg("not found user: " + receiver);
    }

    public boolean isLoginAuthenticated(String login){
        for (ClientHandler client : clients) {
            if (client.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    public void broadcastClientList(){
        StringBuilder sb = new StringBuilder(ServiceMessages.ClLIST);
        for (ClientHandler client : clients) {
            sb.append(" ").append(client.getNickname());
        }

        String message = sb.toString();

        for (ClientHandler client : clients) {
            client.sendMsg(message);
        }
    }

    public AuthService getAuthService() {
        return authService;
    }
}
