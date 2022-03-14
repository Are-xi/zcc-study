package main.java.linkedlist;


public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 heroNode2 = new HeroNode2(12,"23","32");
        HeroNode2 heroNode3 = new HeroNode2(13,"23","32");
        HeroNode2 heroNode4 = new HeroNode2(14,"23","32");
        HeroNode2 heroNode1 = new HeroNode2(14,"2323","32");
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.list();
        doubleLinkedList.edit(heroNode1);
        System.out.println("---------------");
        doubleLinkedList.list();
        doubleLinkedList.del(heroNode3);
        System.out.println("---------------");
        doubleLinkedList.list();


    }

    static class DoubleLinkedList{
        private HeroNode2 head = new HeroNode2(0,"","");

        public void list(){
           HeroNode2 temp=head;
           if (temp.next == null){
               return;
           }
           while (true){
               if (temp == null){
                   break;
               }
               System.out.println(temp);
               temp = temp.next;
           }
        }

        public void add(HeroNode2 heroNode2){
            HeroNode2 temp = head;
            while (true){
                if (temp.next == null){

                    break;
                }
                temp =temp.next;
            }
            temp.next = heroNode2;
            heroNode2.pre = temp;
            return;
        }


        //修改根据编号
        public void edit(HeroNode2 heroNode){

            if (head.next == null){
                return;
            }

            HeroNode2 temp = head;
            while (true){
                if (temp == null){
                    break;
                }
                if(temp.no == heroNode.no){
                    temp.name = heroNode.name;
                    temp.nickname = heroNode.nickname;
                    break;
                }
                temp = temp.next;
            }

        }

        //删除
        public void del(HeroNode2 heroNode){

            if (head.next == null){
                return;
            }
            HeroNode2 temp = head.next;
            boolean flag = false;
            while (true){
                if (temp.next == null){
                    break;
                }
                if (temp.no == heroNode.no){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            if (flag){
                temp.pre.next = temp.next;
                if (temp.next!=null){
                    temp.next.pre = temp.pre;
                }
            }

        }




    }


    //节点
    static class HeroNode2{
        public int no;
        public String name;
        public String nickname;
        public HeroNode2 next;
        public HeroNode2 pre;

        public HeroNode2(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
            this.pre = null;
            this.next = null;
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
