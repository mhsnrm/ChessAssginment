package com.mohsen.game.socket;

import com.mohsen.game.board.MovementManager;

import java.io.*;
import java.net.Socket;

public class ClientSocketManager implements SocketManager{
    public void manageSocket(String ip, int port) throws Exception{
        Socket sock = new Socket(ip, port);
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);

        InputStream istream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

        System.out.println("Start the chitchat, type and press Enter key");

        String receiveMessage, sendMessage;
        while(true)
        {
            sendMessage = keyRead.readLine();
            pwrite.println(sendMessage);
            pwrite.flush();
            if((receiveMessage = receiveRead.readLine()) != null)
            {
                if((receiveMessage = receiveRead.readLine()) != null) {
                    System.out.println(receiveMessage.substring(0,2));
                    System.out.println(receiveMessage.substring(2,4));
                    MovementManager manager = new MovementManager();
                    System.out.println(manager.manageMovement(Integer.valueOf(receiveMessage.substring(0,1)), Integer.valueOf(receiveMessage.substring(0,1)),
                            Integer.valueOf(receiveMessage.substring(0,1)), Integer.valueOf(receiveMessage.substring(0,1))));
                }
            }
        }
    }
}