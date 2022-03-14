package org.example.io;

import java.io.*;

public class Demo3 {

    public static void main(String[] args) {
        Reader in = null;
        Reader bufferIn = null;
        Writer out = null;
        Writer bufferOut = null;

        try {
            in = new FileReader("C:\\root\\test6.txt");
            bufferIn = new BufferedReader(in);

            out = new FileWriter("C:\\root\\test7.txt");
            bufferOut = new BufferedWriter(out);

            char[] chars = new char[10];
            int len = 0;
            while ((len = bufferIn.read(chars))!=-1){
                bufferOut.write(chars,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferOut.close();
                out.close();
                bufferIn.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
