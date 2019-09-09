package com.sky.datastructure.linked;

public class DoubleLinkedDemo {

    public static void main(String[] args) {
        DoubleLinked doubleLinked = new DoubleLinked();

        Node n1 = new Node(1,"sky");
        Node n2 = new Node(2,"skt");
        Node n4 = new Node(3,"blue");
        Node n3 = new Node(4,"白开水");
        doubleLinked.addNode(n1);
        doubleLinked.addNode(n2);
   //     doubleLinked.updateNode(n3);
        doubleLinked.addNode(n3);

        doubleLinked.list();

        doubleLinked.delNode(4);
        System.out.println("删除后");

        doubleLinked.list();

    }

    static class DoubleLinked{
        int no;
        Object val;
        Node next ;
        Node prev;

        public DoubleLinked() {
            this.no = no;
            this.val = val;
            this.next = new Node(0,"双向链表的头");
            this.prev = null;
        }

        public void delNode(int no){
            Node temp = next;
            while (!(temp.next == null)){
                temp = temp.next;
                if(temp.no == no){
                    //赋值
                   temp.prev.next = temp.next;
                   if(temp.next != null){ //最后一个节点
                       temp.next.prev = temp.prev.next;
                   }

                    break;
                }
            }
        }

        /**
         * 修改节点
         * @param newNode
         */
        public void updateNode(Node newNode)
        {
            Node temp = next;
            while (!(temp.next == null)){
                temp = temp.next;
                if(temp.no == newNode.no){
                    temp.val = newNode.val;
                    System.out.println("修改成功");
                    break;
                }
            }
        }
        /**
         * 添加节点
         */
        public void addNode(Node newNode){

            Node temp = next;
            while (!(temp.next == null)){
                //下一个节点
                temp = temp.next;
            }
            //添加
            temp.next = newNode;
            newNode.prev = temp;

        }

        public void list(){
            Node temp = next;
            while (!(temp.next == null)){
                System.out.println(temp.next);
                temp = temp.next;
            }
        }




    }

    static class Node{
        int no;
        Object val;
        Node next;
        Node prev;

        public Node(int no, Object val) {
            this.no = no;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", val=" + val +
                    '}';
        }
    }

}
