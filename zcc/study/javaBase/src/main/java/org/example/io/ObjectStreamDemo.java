package org.example.io;

import java.io.*;

public class ObjectStreamDemo {

    public static void main(String[] args) {

        objectInputStream();
        //objectOutputStream();

    }

    public static void objectOutputStream(){
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\root\\test10.txt"));
            Person p = new Person(2,"sf","男");
            objectOutputStream.writeObject(p);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void objectInputStream(){
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream("C:\\root\\test10.txt"));
            Object o1 = o.readObject();
            Person p = (Person) o1;
            System.out.println(p.getSex());
            o.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
