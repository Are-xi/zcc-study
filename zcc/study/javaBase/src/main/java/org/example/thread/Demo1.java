package org.example.thread;

public class Demo1 {

    public static void main(String[] args) {

        Process1 process1 = new Process1();
        Thread thread = new Thread(process1);
        Thread thread2 = new Thread(process1);
        Thread thread3 = new Thread(process1);
        thread.setName("1号窗口");
        thread2.setName("2号窗口");
        thread3.setName("3号窗口");
        thread.start();
        thread2.start();
        thread3.start();

//        Process2 process2 = new Process2();
//        Process2 process3 = new Process2();
//        Process2 process4 = new Process2();
//
//        process2.start();
//        process3.start();
//        process4.start();


    }

    static class Process1 implements Runnable{
        static int ticket = 100;
        public void run() {
            while (ticket>0){
                synchronized (this){
                    System.out.println(Thread.currentThread().getName()+"首票：票号为："+ticket);
                    ticket = ticket-1;
                }

            }

        }
    }

    static class Process2 extends Thread{

        static int ticket = 20;

        @Override
        public void run() {
            while (ticket>0){
                System.out.println(Thread.currentThread().getName()+"售票：票号为："+ticket);
                ticket = ticket-1;
            }
        }
    }

}
