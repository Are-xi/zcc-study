package main.java.linkedlist;

import com.sun.deploy.uitoolkit.impl.awt.AWTDragHelper;

//约瑟夫问题，单向环形链表
public class Josepfu {

    public static void main(String[] args) {

        CysleSingleLinkedList cysleSingleLinkedList = new CysleSingleLinkedList();
        cysleSingleLinkedList.addBoy(125);
        //cysleSingleLinkedList.showboy();
        cysleSingleLinkedList.countboy(10,20,125);


    }

    static class CysleSingleLinkedList{
        private Boy first = new Boy(-1);


        //根据用户输入计算出小孩出圈的顺序

        /**
         *
         * @param startNo 第几个开始
         * @param countNum 数多少下
         * @param nums 一开始有多少个
         */
        public void countboy(int startNo,int countNum,int nums){
            if (first == null || startNo<1 || startNo>nums){
                return;
            }
            Boy helper = first;
            while (true){
                if(helper.next == first){
                    break;
                }
                helper = helper.next;
            }

            for (int i =0;i<startNo-1;i++){
                first = first.getNext();
                helper = helper.getNext();
            }

            while (true){
                if (helper == first) break;
                for (int i =0;i<countNum-1;i++){
                    first = first.getNext();
                    helper = helper.getNext();
                }
                System.out.println(first);
                first = first.getNext();
                helper.setNext(first);
            }

            System.out.println(first.getNo());

        }

        public void addBoy(int nums){
            if (nums<1){
                return;
            }

            Boy curr = null;
            for (int i=1;i<=nums;i++){
                Boy  boy = new Boy(i);
                if (i == 1){
                    first = boy;
                    first.setNext(boy);
                    curr = boy;
                }else {
                    curr.setNext(boy);
                    boy.setNext(first);
                    curr = boy;
                }
            }

        }


        public void showboy(){
            if (first == null){
                return;
            }

            Boy curboy = first;
            while (true){
                System.out.println(curboy);
                if (curboy.next == first){
                    break;
                }
                curboy = curboy.next;
            }

        }




    }


    static class Boy{
        private int no;
        private Boy next;

        public Boy(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public Boy getNext() {
            return next;
        }

        public void setNext(Boy next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Boy{" +
                    "no=" + no +
                    '}';
        }
    }



}
