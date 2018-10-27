package com.mohsen.game.socket;

import com.mohsen.game.board.MovementManager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketManager implements SocketManager{
    public void manageSocket(String ip, int port) throws Exception{
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server  ready for play chess");
        Socket sock = serverSocket.accept( );
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = sock.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);

        InputStream inputStream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(inputStream));

        String receiveMessage, sendMessage;
        while(true) {
            if((receiveMessage = receiveRead.readLine()) != null) {
                System.out.println(receiveMessage.substring(0,2));
                System.out.println(receiveMessage.substring(2,4));
                MovementManager manager = new MovementManager();
                System.out.println(manager.manageMovement(Integer.valueOf(receiveMessage.substring(0,1)), Integer.valueOf(receiveMessage.substring(0,1)),
                        Integer.valueOf(receiveMessage.substring(0,1)), Integer.valueOf(receiveMessage.substring(0,1))));
            }
            sendMessage = keyRead.readLine();
            printWriter.println(sendMessage);
            printWriter.flush();
        }
    }
}
