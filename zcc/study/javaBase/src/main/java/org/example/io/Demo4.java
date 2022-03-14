package org.example.io;

import java.io.*;

public class Demo4 {

    public static void main(String[] args) {
        InputStream in = null;
        InputStream bufferIn = null;
        OutputStream out = null;
        OutputStream bufferOut = null;

        try {
            in = new FileInputStream("C:\\root\\QaCheck.xls");
            bufferIn = new BufferedInputStream(in);

            out = new FileOutputStream("C:\\root\\QaCheck1.xls");
            bufferOut = new BufferedOutputStream(out);

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bufferIn.read(bytes))!=-1){
                bufferOut.write(bytes,0,len);
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
