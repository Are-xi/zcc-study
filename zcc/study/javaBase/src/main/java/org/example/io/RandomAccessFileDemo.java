package org.example.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    public static void main(String[] args) {

        RandomAccessFile file = null;
        try {
            /**
             * r：以只读方式打开
             * rw：打开以便读取和写入
             * rwd：打开以便读取和写入；同步文件内容的更新
             * rws：打开以便读取和写入；同步文件内容和元数据的更新
             *
             * 如果是在文件的开头或者中间的某个位置开始写的话，就会用写的内容覆盖掉等长度的内容
             */
            file = new RandomAccessFile("C:\\root\\test7.txt","rwd");

            //随机读取文件操作
            file.seek(0);//从开头读写数据，里面的表示第几个字符

            byte[] bytes = new byte[1024];

            int len = 0;

            while ((len = file.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }

            //随机写入文件的操作
            file.seek(file.length());//结尾追加文件

            String s = "参加四间房";

            file.write(s.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
