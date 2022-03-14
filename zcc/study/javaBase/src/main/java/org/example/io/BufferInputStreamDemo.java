package org.example.io;

import java.io.*;

public class BufferInputStreamDemo {

    public static void main(String[] args) {
        InputStream  in = null;
        InputStream buffer = null;

        try {
            in = new FileInputStream("C:\\root\\test3.txt");
            buffer = new BufferedInputStream(in);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len= buffer.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len,"utf-8"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                buffer.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
