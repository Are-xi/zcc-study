package org.example.io;

import java.io.*;

public class Demo2 {

    public static void main(String[] args) {
        Reader in = null;
        Writer out = null;

        try {
            in = new FileReader("C:\\root\\test1.txt");
            out = new FileWriter("C:\\root\\test3.txt");

            char[] c = new char[10];
            int len = 0;
            while ((len = in.read(c))!=-1){
                //out.write(c);
                out.write(c,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
