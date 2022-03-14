package org.example.io;

import java.io.*;
import java.util.Scanner;

public class FileOutputStreamDemo {

    public static void main(String[] args) {
        OutputStream out = null;

        Scanner scanner = new Scanner(System.in);

        try {
            out = new FileOutputStream(new File("C:\\root\\test2.txt"),true);//true 表示往文件中追加内容
            while (scanner.hasNextLine()){
                String s = scanner.nextLine()+"\r\n";
                try {
                    out.write(s.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }

}
