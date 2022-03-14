package org.example.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket accept = serverSocket.accept();
            BufferedReader bf  = new BufferedReader(new InputStreamReader(accept.getInputStream()));

            String s = bf.readLine();
            System.out.println(s);

            //serverSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
