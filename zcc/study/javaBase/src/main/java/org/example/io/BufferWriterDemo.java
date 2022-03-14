package org.example.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class BufferWriterDemo {

    public static void main(String[] args) {
        Writer out = null;
        Writer buffer = null;

        try {
            out  = new FileWriter("C:\\root\\test6.txt",true);
            buffer = new BufferedWriter(out);
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                if (s.equals("quit")) break;
                buffer.write(s);
            }
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
