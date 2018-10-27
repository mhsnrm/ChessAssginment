package com.mohsen.game;

import com.mohsen.game.socket.ClientSocketManager;
import com.mohsen.game.socket.ServerSocketManager;

import java.util.Scanner;

public class App {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 3000;

    public static void main(String[] args) throws Exception {
        System.out.println("Start as a server (Y\'N) ");
        Scanner scanner = new Scanner(System.in);
        String server = scanner.nextLine();
        if (server.equalsIgnoreCase("y")) {
            new ServerSocketManager().manageSocket(IP, PORT);
        } else if (server.equalsIgnoreCase("n")) {
            new ClientSocketManager().manageSocket(IP, PORT);
        } else {
            System.out.println("Invalid value start again");
            System.exit(0);
        }
    }
}
