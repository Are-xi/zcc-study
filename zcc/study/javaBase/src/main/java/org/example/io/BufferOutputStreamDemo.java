package org.example.io;

import java.io.*;

public class BufferOutputStreamDemo {

    public static void main(String[] args) {
        OutputStream out = null;
        OutputStream buffer = null;

        try {
            out = new FileOutputStream("C:\\root\\test4.txt",true);
            buffer = new BufferedOutputStream(out);
            String s = "sjfisjfosf";
            buffer.write(s.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                buffer.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
