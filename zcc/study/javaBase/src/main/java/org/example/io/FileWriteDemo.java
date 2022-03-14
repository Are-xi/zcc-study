package org.example.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriteDemo {

    public static void main(String[] args) {
        Writer fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\root\\test2.txt",true);

            String s = "成都hi i粉丝结果i就是个";
            fileWriter.write(s);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
