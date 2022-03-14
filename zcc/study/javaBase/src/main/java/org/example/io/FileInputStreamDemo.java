package org.example.io;

import java.io.*;

public class FileInputStreamDemo {


    public static void main(String[] args) throws IOException {
        InputStream  is = null;
        try {
            is = new FileInputStream(new File("C:\\root\\test1.txt"));
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes))!=-1){
                String s = new String(bytes,0,len,"utf-8");
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            is.close();
        }
    }
}
