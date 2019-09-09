package com.sky.datastructure.linked;

public class HeroNode {

        /**
         * 编号
         */
        int no;
        /**
         * 名字
         */
        String name;
        /**
         * 别名
         */
        String nikeName;
        /**
         * 下一个节点
         */
        HeroNode next;


        public HeroNode(int no, String name, String nikeName) {
            this.no = no;
            this.name = name;
            this.nikeName = nikeName;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name=" + name +
                    ", nikeName=" + nikeName +

                    '}';
        }

}
