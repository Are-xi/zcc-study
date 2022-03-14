package bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) throws IOException {


        ExecutorService threadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(7777);

        System.out.println("开始监听是否有客户端连接");

        while (true){
            System.out.println("等待连接");
            final Socket socket = serverSocket.accept();
            System.out.println("已连接某个客户端");

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });

        }



    }


    public static void handler(Socket socket) {

        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];

            while (true){

                int read = inputStream.read(bytes);

                if (read!=-1){
                    String s = new String(bytes,0,read);
                    System.out.println(s);
                }else {
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        System.out.println("客户端断开连接");


    }

}
