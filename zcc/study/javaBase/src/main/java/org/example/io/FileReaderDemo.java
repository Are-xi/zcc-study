package org.example.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderDemo {

    public static void main(String[] args) {

        Reader fileReader = null;
        try {

            fileReader = new FileReader("C:\\root\\test2.txt");
            char[] c = new char[10];
            int len = 0;
            while ((len = fileReader.read(c))!=-1){

                String s = new String(c,0,len);
                System.out.println(s);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
