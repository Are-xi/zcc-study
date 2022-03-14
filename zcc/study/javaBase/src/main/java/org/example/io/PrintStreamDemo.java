package org.example.io;

import java.io.*;

public class PrintStreamDemo {

    public static void main(String[] args) {
        //test1();
        test2();

    }

    public static void test1(){
        try {
            PrintWriter printWriter = new PrintWriter(new File("C:\\root\\test11.txt"));
            printWriter.print(true);
            printWriter.print(100);
            printWriter.print("慈善基金fig");
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void test2(){
        try {
            PrintStream printStream = new PrintStream(new File("C:\\root\\test11.txt"));
            printStream.print(true);
            printStream.print(200);
            printStream.print("jfsofj复合肥");
            printStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
