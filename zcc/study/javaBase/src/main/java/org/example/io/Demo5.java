package org.example.io;

import java.io.*;

public class Demo5 {

    public static void main(String[] args) {
        InputStream in =null;
        InputStreamReader inReader = null;
        OutputStream out = null;
        OutputStreamWriter outWriter = null;

        try {
            in = new FileInputStream("C:\\root\\test7.txt");
            inReader = new InputStreamReader(in,"utf-8");
            out = new FileOutputStream("C:\\root\\test9.txt");
            outWriter = new OutputStreamWriter(out,"utf-8");
            char[] chars = new char[1024];
            int len = 0;
            while ((len = inReader.read(chars))!=-1){
                outWriter.write(chars,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outWriter.close();
                out.close();
                inReader.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
