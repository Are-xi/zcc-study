package main.java.linkedlist;

import java.security.PublicKey;

/**
 * 单链表面试题
 * 1、求单链表中的节点个数
 * 2、查找单链表的倒数第k个节点，linkedList.length-k+1
 * 3、单链表的反转
 * 4、从头到尾打印单链表
 * 5、合并两个有序的单链表，合并之后依然有序
 */

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode = new HeroNode(23,"23","32");
        HeroNode heroNode1 = new HeroNode(2333,"23","32");
        HeroNode heroNode2 = new HeroNode(234,"23","32");
        HeroNode heroNode4 = new HeroNode(234,"2323","32");
        singleLinkedList.addByNo(heroNode);
        singleLinkedList.addByNo(heroNode1);
        singleLinkedList.addByNo(heroNode2);
        singleLinkedList.edit(heroNode4);
        singleLinkedList.list();
        singleLinkedList.del(heroNode1);
        singleLinkedList.list();
    }


    //定义单链表
    static class SingleLinkedList{

        private HeroNode head = new HeroNode(0,"","");

        public void add(HeroNode heroNode){
            HeroNode temp = head;
            while (true){
                if (temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = heroNode;
            return;
        }

        public void addByNo(HeroNode heroNode){
            HeroNode temp = head;
            while (true){
                if (temp.next == null){
                    break;
                }
                if (temp.next.no>= heroNode.no){
                    temp = temp.next;
                }else {
                    HeroNode te = temp.next;
                    temp.next = heroNode;
                    heroNode.next = te;
                    break;
                }
            }
            temp.next = heroNode;
            return;
        }

        //修改根据编号
        public void edit(HeroNode heroNode){

            HeroNode temp = head;
            while (true){
                if (temp.next == null){
                    break;
                }
                if(temp.next.no == heroNode.no){
                    temp.next.name = heroNode.name;
                    temp.next.nickname = heroNode.nickname;
                    break;
                }
                temp = temp.next;
            }

        }

        //删除
        public void del(HeroNode heroNode){
            HeroNode temp = head;
            while (true){
                if (temp.next == null){
                    break;
                }
                if(temp.next.no == heroNode.no){
                    temp.next = temp.next.next;
                    break;
                }
            }
        }

        //遍历
        public void list(){
            if (head.next == null){
                System.out.println("kong");
                return;
            }
            HeroNode temp = head.next;
            while (true){
                System.out.println(temp);
                if (temp.next == null){
                    break;
                }
                temp = temp.next;
            }
        }


    }


    //节点
    static class HeroNode{
        public int no;
        public String name;
        public String nickname;
        public HeroNode next;

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }





}
