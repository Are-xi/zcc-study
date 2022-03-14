package org.example.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1",9999);

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String s = "hello world";
            bufferedWriter.write(s);

            bufferedWriter.flush();

            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
