package com.sky.datastructure.tree;

import org.junit.Test;

/**
 * 二叉排序树  称二叉查找树（Binary Search Tree），亦称二叉搜索树。
 *  一棵空树，或者是具有下列性质的二叉树：
 * （1）若左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * （2）若右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * （3）左、右子树也分别为二叉排序树；
 * （4）没有键值相等的节点。
 */
public class BinarySortTreeTest {

    class Node {

        int value;

        Node left;

        Node right;


        public Node(int value) {
            this.value = value;
        }

        public void add(Node node) {


            if (node == null) {
                return;
            }

            //小于 到左边
            if (this.value > node.value) {

                //左节点为空 直接赋值
                if (this.left == null) {
                    this.left = node;
                } else {
                    //左节点不为空 递归
                    this.left.add(node);
                }
            } else {

                if (this.right == null) {
                    this.right = node;
                } else {
                    //向右 递归
                    this.right.add(node);
                }
            }
        }

        /**
         * 查找要删除的节点
         */

        public Node search(int value){
            if(this.value == value){
                return this;
            }else if(this.value > value && this.left != null){
               return this.left.search(value);
            }else if(this.value < value && this.right != null){
                return this.right.search(value);
            }else{
                return null;
            }
        }

        /**
         * 查找父节点
         * @param value
         * @return
         */
        public Node searchParent(int value) {
            if(this.left != null && this.left.value == value ||
             this.right != null && this.right.value == value
            ){
                return this;
            }else{
                //不相等 进行 判断大小
                /**
                 * 比左边小
                 */
                if(this.left != null && this.value > value){
                    return this.left.searchParent(value);
                }
                else if(this.right != null && this.value < value){
                    /**
                     * 比左边的值大
                      */
                    return this.right.searchParent(value);
                }else{
                    return  null;
                }


            }

        }

        /**
         * 删除节点
         * 分3种情况:
         *      1:删除叶子节点
         *      2:删除只有一颗子数的节点
         *      3:删除有两颗子树的节点
         */
        public void delNode(int value) {


            //当前节点
            Node targetNode =  search(value);
            if(targetNode == null){
                return;
            }
            else{
                //存在当前节点
               Node parent = searchParent(value);
               //只删除 叶子节点
                if(targetNode.left == null && targetNode.right == null){
                    if(parent.left != null && parent.left.value == value){
                        parent.left = null;
                    }else if(parent.right != null && parent.right.value == value){
                        parent.right = null;
                    }

                }/**
                 * 删除 拥有两个子节点的 节点
                 * */
                else if(targetNode.left != null && targetNode.right != null){

                    int val = delRightTreeMin(targetNode.right);
                    //将最左叶子节点的值 赋值给当前节点的值
                    targetNode.value = val;
                }

                /**
                  *删除 只有一个子节点的节点
                 *  有两种情况:
                 *              1:左子节点不为空
                 *              2:右子节点不为空
                  */
                else if(targetNode.left != null){
                    /**
                     * 左子节点不为空
                     */

                    if(parent.left != null && parent.left.value == value){
                        //父节点 的左子节点为删除的节点
                        parent.left =  targetNode.left;

                    }else if(parent.right != null && parent.right.value == value){
                        // 父节点 的右子节点为删除的节点
                        parent.right = targetNode.left;
                    }
                }else if( targetNode.right != null){
                    /**
                     * 右子节点不为空
                     */
                    if(parent.left != null && parent.left.value == value){
                        //父节点 的左子节点为删除的节点
                        parent.left = targetNode.right;

                    }else if(parent.right != null && parent.right.value == value){
                        // 父节点 的右子节点为删除的节点
                        parent.right = targetNode.right;
                    }
                }


            }

        }


        /**
         * 删除 右节点 下的最小 叶子节点 也就是左叶子节点 并返回对应的值, 用于删除拥有 双子节点 的节点(7,5,12)
         * @param node
         * @return
         */
        public int delRightTreeMin(Node node) {

            Node target = node;
            //找出最小叶子节点
            while (target.left != null){
                target = target.left;
            }

            delNode(target.value);
            return target.value;
        }


        /**
         * 平衡树  左旋转
         * @return
         */
        private void leftRotate(){
        //1:左旋转的步骤

        //a:创建新节点,以当前根节点的值
            Node newNode = new Node(value);

        //b:把新的结点的左子树设置成当前结点的左子结点
            newNode.left = left;

        //c:把新的结点的右子树设置成带你过去结点的右子树的左子树
            newNode.right = right.left;

        //d:把当前结点的值 替换成右子结点的值
            value = right.value;

        //e:把当前结点的右子树设置成当前结点右子树的右子树
            right = right.right;

        //f:把当前结点的左子树(左子结点)设置成为新的结点
            left = newNode;
        }

        /**
         * 平衡树 右旋转
         */
        private void righitRotate(){
            //a: 创建新结点,以当前根结点的值
            Node rightNode = new Node(value);
            //b:新结点的 左子树 以当前结点 左子子树的右子子树
            rightNode.left = left.right;

            //c:新结点的 右子树 以当前结点的右子树
            rightNode.right = right;

            //d:  当前结点的值 为当前结点左子结点的值
            value = left.value;

            //e:当前结点 左子树 为当前结点的左子树的左子树
            left = left.left;

            //f: 将新结点 赋值 给当前结点的右子树
            right = rightNode;
        }

        /**
         *   双旋转
         */
       /* public void doubleRotate(){
            *//**
             * 右旋转 考虑到双旋转
             *//*
            //判断 右旋转
            if (leftHeight() - rightHeight() > 1) {
                //因为 当前结点的左树 的左结点高度 小于 左树右结点的高度 所有要先进行 左旋转(当前节点的左树)
                if (left != null && left.leftHeight() <
                        left.rightHeight()) {
                    left.leftRotate();
                    rightRotate();
                } else {
                    rightRotate();
                }
                return ;
            }

            *//**
             * 左旋转 考虑双旋转
             *//*
            if(rightHeight - leftHeight > 1){

                if(right != null && right.leftHeight > right.rightHeight){
                    righitRotate();
                    leftRotate();
                }else{
                    leftRotate();
                }
                return ;
            }

        }*/



        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("value=").append(value);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return sb.toString();
        }

    }

    Node root ;

    @Test
    public void testBinarySortTree(){
        int[] arr =  {7, 3, 10, 12, 5, 1, 9};

        for(int val : arr){
            add(new Node(val));
        }


        System.out.println("查看树" + root);

      //  root.add(new Node(2));
       // root.add(new Node(0));
     //   root.add(new Node(11));
//        root.add(new Node(13));
      //  root.add(new Node(7));

        System.out.println("查看树" + root);


//       Node node =  root.search(3);

//        System.out.println("7的 = " + node);
//        root.delNode(2);
//        System.out.println("删除叶子节点的数 = " + root);

        root.delNode(7);
        System.out.println("删除 双子节点 的节点 = " + root);

    }



    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            root.add(node);
        }
    }



}
