package main.java.arrayqueue;

public class CycleArrayQueue {

    public static void main(String[] args) {

        CycleArrqy cycleArrqy = new CycleArrqy(5);
        cycleArrqy.addQueue(2);
        cycleArrqy.addQueue(2);
        cycleArrqy.addQueue(2);
        cycleArrqy.addQueue(4);
        cycleArrqy.showQueue();


    }

    static class CycleArrqy {
        private int maxSize;//最大容量
        private int front;//指向队列的第一个元素，初始值为0
        private int rear;//指向队列的最后一个元素的后一个位置，初始值为0
        private int[] arr; //存放数据，模拟队列

        //初始化
        public CycleArrqy(int arrMaxSize){

            maxSize = arrMaxSize;
            arr = new int[arrMaxSize];
            front = 0;
            rear = 0;


        }

        //判断队列是否满了
        public boolean isFull(){
            return (rear+1)%maxSize == front;
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
            arr[rear] = data;
            rear=(rear+1)%maxSize;
        }

        //获取队列数据
        public int getQueue(){
            if (isEmpty()){
                throw new RuntimeException("队列为空");
            }
            int value = arr[front];
            front = (front+1)%maxSize;
            return value;
        }


        //显示所有数据
        public void showQueue(){
            if (isEmpty()){
                throw new RuntimeException("队列为空");
            }
            for (int i = front;i<front+(rear+maxSize-front)%maxSize;i++){
                System.out.println(arr[i]);
            }
        }

        public int size(){
            return (rear+maxSize-front)%maxSize;
        }

    }


}
