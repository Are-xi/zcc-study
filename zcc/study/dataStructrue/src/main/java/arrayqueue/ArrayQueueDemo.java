package main.java.arrayqueue;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

//队列可以用数组或链表实现
public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.addQueue(4);
        arrayQueue.addQueue(5);
        arrayQueue.addQueue(6);
        arrayQueue.showQueue();

    }

static class ArrayQueue {
        private int maxSize;//最大容量
        private int front;//队头
        private int rear;//队尾
        private int[] arr; //存放数据，模拟队列

    //初始化
    public ArrayQueue(int arrMaxSize){

        maxSize = arrMaxSize;
        arr = new int[arrMaxSize];
        front = -1;
        rear = -1;


    }

    //判断队列是否满了
    public boolean isFull(){
        return rear == maxSize -1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return  rear == front;
    }

    //添加
    public void addQueue(int data){
        if (isFull()){
            System.out.println("队列满了");
            return ;
        }
        arr[rear+1] = data;
        rear++;
    }

    //获取队列数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }


    //显示所有数据
    public void showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    }





}
