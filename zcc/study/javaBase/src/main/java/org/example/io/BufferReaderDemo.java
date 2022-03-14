package org.example.io;

import java.io.*;

public class BufferReaderDemo {

    public static void main(String[] args) {
        Reader in = null;
        Reader buffer = null;

        try {
            in = new FileReader("C:\\root\\test5.txt");
            buffer = new BufferedReader(in);
            char[] chars = new char[1024];
            int len = 0;
            while ((len = buffer.read(chars))!=-1){
                System.out.println(new String(chars,0,len));
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
