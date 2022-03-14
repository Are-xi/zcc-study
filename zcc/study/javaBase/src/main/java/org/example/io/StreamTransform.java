package org.example.io;

import java.io.*;

public class StreamTransform {

    public static void main(String[] args) {
        //inputToReader();
        outputToWriter();
    }

    public static  void inputToReader(){
        InputStream in = null;
        InputStreamReader reader = null;

        try {
            in = new FileInputStream("C:\\root\\test7.txt");
            reader = new InputStreamReader(in,"utf-8");
            char[] chars = new char[1024];
            int len = 0;
            while ((len = reader.read(chars))!=-1){
                System.out.println(new String(chars,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void outputToWriter(){
        OutputStream out = null;
        OutputStreamWriter writer = null;

        try {
            out = new FileOutputStream("C:\\root\\test8.txt");
            String s = "飞机搜集覅时间覅金额为";
            writer = new OutputStreamWriter(out,"utf-8");
            writer.write(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
