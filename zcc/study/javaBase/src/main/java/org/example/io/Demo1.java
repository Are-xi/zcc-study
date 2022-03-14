package org.example.io;

import java.io.*;

public class Demo1 {

    public static void main(String[] args) {
        InputStream is = null;
        OutputStream out = null;
        File file = new File("C:\\root\\arthas_orion\\threadFile.txt");
        try {
            is = new FileInputStream(file);
            out = new FileOutputStream("C:\\root\\arthas_orion\\t1.txt");

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes))!=-1){
                out.write(bytes,0,len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
