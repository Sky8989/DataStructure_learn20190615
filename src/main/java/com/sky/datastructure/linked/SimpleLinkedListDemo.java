package com.sky.datastructure.linked;

public class SimpleLinkedListDemo {

    public static void main(String[] args) {
        SimpleLinkedList simpleLinkedList = new SimpleLinkedList(0);

        HeroNode h1 = new HeroNode(1,"李白","诗仙");
        HeroNode h2 = new HeroNode(2,"杜甫","诗圣");
        HeroNode h3 = new HeroNode(3,"白居易","诗人");
        HeroNode h4 = new HeroNode(4,"陶渊明","田园诗人");
        simpleLinkedList.add(h1);
//        simpleLinkedList.add(h2);
        simpleLinkedList.add(h3);
        simpleLinkedList.add(h4);
        System.out.println("普通列表");
        simpleLinkedList.list();

        System.out.println("反转列表 ");
        simpleLinkedList.reverse();
        simpleLinkedList.list();

//        HeroNode h5 = new HeroNode(2,"李鬼","诗鬼");
//        simpleLinkedList.update(h5);
//        System.out.println("修改后");
//        simpleLinkedList.list();

        //删除后
//        simpleLinkedList.delete(1);
//        simpleLinkedList.delete(2);
//        simpleLinkedList.delete(3);
//        simpleLinkedList.delete(4);
   //     System.out.println("删除后 =");
     //   simpleLinkedList.list();
    }


    /**
     * 单链表的头
     */
    static class SimpleLinkedList{
        /**
         * 编号
         */
        int no;

        /**
         * 下一个节点
         */
        HeroNode head;

        public SimpleLinkedList(int no) {
            this.no = no;
            head = new HeroNode(0,"","");
        }

        //返回头节点
        public HeroNode getHead() {
            HeroNode temp = new HeroNode(1,"aaa","aaa");
            if (head.next == null){
                System.out.println("链表为空");
                return null;
            }
            temp.next = head.next;
           delete(head.next.no);
            return temp.next;
        }

        public void addHead(HeroNode newNode){
            if(newNode == null){
                System.out.println("传入的节点不能为空");
            }
       //     HeroNode temp = head;
            if(head.next == null){
                head.next = newNode;
            }else{
                newNode.next = head.next;
            }
        }


        public void add(HeroNode heroNode){

            HeroNode temp = this.head;
            while (true){
                if(temp.next == null){
                    //找到了最后一个
                    break;
                }
                //如果没有找到最后, 将将temp后移
                temp = temp.next;
            }
            //当退出while循环时，temp就指向了链表的最后
            temp.next = heroNode;
        }

        /**
         * 通过编号从小到大开始
         * @param heroNode
         */
        public void addByNo(HeroNode heroNode){

            HeroNode temp = this.head;
            boolean flag = false;
            while (true){
                if(temp.next == null){
                    //找到了最后一个
                    break;
                }
                //位置找到，就在temp的后面插入
                if( heroNode.no <  temp.next.no ){
                    break;
                }else if(temp.next.no == heroNode.no) {//说明希望添加的heroNode的编号已然存在
                    flag = true; //说明编号存在
                    break;
                }

                //如果没有找到最后, 将将temp后移
                temp = temp.next;

            }

            if(flag){
                //不能添加，说明编号存在
                System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
            }else {
                //插入到链表中, temp的后面
                heroNode.next = temp.next;
                temp.next = heroNode;
            }

        }


        public  void update(HeroNode heroNode){
            HeroNode temp = head;
            boolean flag = false;
            while (true){

                if(temp.next == null){
                    break;
                }

                if(temp.next.no == heroNode.no){ //编号相等 进行修改
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            if(flag){
                //先将对应本地节点的 next赋值给新的节点
              //  heroNode.next = temp.next.next;
                temp.next.name = heroNode.name;
                temp.next.nikeName = heroNode.nikeName;
            }else {
                System.out.println("没有找到对应的编号 = " + heroNode.no);
            }

        }

        public void delete(int no){

            HeroNode tmep = head;
            boolean flag = false;
            while (true){

                if(tmep.next == null){
                    //到最后
                    break;
                }
                if(tmep.next.no == no){ //找到删除的节点
                    flag = true;
                    break;
                }
                tmep = tmep.next;
            }

            if(flag){
                //删除
                //将需要删除的 tmep.next 的下一个节点的位置传给上一个节点

               tmep.next = tmep.next.next;
            }else{
                System.out.println("没有找到删除节点");
            }

        }

        public void list(){
            HeroNode temp = this.head;
            if(temp == null){
                System.out.println("单链表为空");
                return;
            }

            while (true){
                if(temp.next == null){
                    //最后一个
                    break;
                }

                //移动
                temp = temp.next;
                System.out.println(temp);
            }
        }



        public SimpleLinkedList reverse() {
            HeroNode reverse = new HeroNode(0,"","");
            HeroNode cur = this.head.next;  //当前节点
            HeroNode next = null;       //当前节点的下一个节点
            while (true){
                if(cur == null){
                    break;
                }
                next = cur.next;    //把当前节点的下一个赋值给 next
                cur.next = reverse.next; //反转节点的第一个节点 赋值给当前节点的下一个
                reverse.next = cur; //将当前节点赋值给 反转节点
                cur = next; //将下一个节点赋值给当前节点

            }
            this.head.next = reverse.next;

            return this;
        }
    }


}
