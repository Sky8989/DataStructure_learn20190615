package com.sky.datastructure.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 *  当前节点大于左子树，小于右子树
 */
public class BST {
    //节点
    class Node{
        int val;
        Node left,right;

        public Node(int e) {
            this.val = e;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("val=").append(val);
            sb.append(", left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return sb.toString();
        }
    }
    //根节点
    Node root;
    int size;

    public int size(){
        return size;
    }

    public boolean isEmply(){
        return  size == 0;
    }

    /**
     * 添加 值
     * @param val
     */
    public void add(int val){

       root = add(root,val);
    }

    /**
     * 递归添加 值
     * @param n
     * @param val
     */
    private Node add(Node n,int val){
        if(n == null){
            size++;
            return new Node(val);
        }else if(n.val > val){
            n.left  = add(n.left,val);
        }else if(n.val < val){
            n.right = add(n.right,val);
        }
        return n;
    }




    public boolean contains(int n){
       return contains(root,n);
    }
    private  boolean contains(Node node,int n){
        if(node == null) return false;

        if(node.val == n){
            return true;
        }else if (node.val > n){
            return contains(node.left,n);
        }else{
            return contains(node.right,n);
        }
    }


    /**
     * 前序遍历  根节点->左节点->右节点
     */
    public void prevOrder(){
        prevOrder(root);
    }

    private void prevOrder(Node root){
        if(root == null) return;

        System.out.println(root.val);
        prevOrder(root.left);
        prevOrder(root.right);
    }


    /**
     * 前序遍历 非递归方式  辅助工具栈
     */
    public void prevOrderNR(){

        if(root == null) return;

        //先进后出
        Stack<Node> stack = new Stack<Node>();

        Node curr = root;
        //先添加根节点
        stack.add(curr);
        while (!stack.isEmpty()){
            //取出节点
            curr = stack.pop();
            System.out.println(curr.val);

            //因为栈的特性 先进后出
            if(curr.right != null) stack.add(curr.right);
            if(curr.left != null) stack.add(curr.left);
        }

    }

    /**
     * 中序遍历   左->根->右
     */
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null) return;

        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    /**
     * 中序遍历 非递归方式
     */
    public void inOrderNR(){
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        //当前节点
        Node curr = root;

        //找到最左子节点
        while (curr != null || !stack.isEmpty()){

            //当前节点不为空，将当前节点入栈，以及当前节点的所有左子节点
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }

            //出栈
            curr = stack.pop();
            //打印当前节点
            System.out.println(curr.val);
            //处理右子树
            curr = curr.right;

            }






    }

    /**
     * 后序遍历 左->右->根
     */
    public void afterOrder(){
        afterOrder(root);
    }

    private void afterOrder(Node node){
        if(node == null)return;

        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.val);
    }

    /**
     * 后序遍历非递归
     * 需要两个栈 一个存储数据的栈 一个辅助栈
     */
    public void afterOrderNR(){
        if(root == null) return;

        Stack<Node> stack = new Stack<>();
        Stack<Node> tempStack = new Stack<>();
        Node curr = root;

        tempStack.push(curr);

        while (!tempStack.isEmpty()){
            curr = tempStack.pop();
            //实际的栈存数据
            stack.push(curr);

            //辅助栈 临时存数据
            if(curr.left != null) tempStack.push(curr.left);

            if(curr.right != null) tempStack.push(curr.right);

        }

        //最后通过实际的栈 遍历
        while(!stack.isEmpty()) System.out.println(stack.pop().val);
    }


    /**
     * 层序遍历  从上到下 （广度优先）  辅助工具队列
     */
    public void levelOrder(){
        if(root == null) return;
        /**
         * 存储队列
         */
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //取出节点 并打印
            Node curr = queue.poll();
            System.out.println(curr.val);

           if(curr.left != null){
               queue.add(curr.left);
           }

           if(curr.right != null){
               queue.add(curr.right);
           }
        }


    }





    @Test
    public void testTreeAddVal(){
        int[] arr = new int[]{10,6,12,4,15,8,9,11,6};

        BST bst = new BST();

        for(int i = 0; i < arr.length; i++){
            bst.add(arr[i]);
        }

//        System.out.println("前序遍历");
//        bst.prevOrder();
//        System.out.println("======");
//        bst.prevOrderNR();
//        System.out.println("中序遍历");
//        bst.inOrder();
//        System.out.println("======");
//        bst.inOrderNR();
        System.out.println("后序遍历");
        bst.afterOrder();
        System.out.println("======");
        bst.afterOrderNR();
//        System.out.println("层序遍历");
//        bst.levelOrder();
//        System.out.println(bst);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        generateBSTString(root,0,sb);
        return sb.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder sb) {
        if(node == null){
            sb.append(genrateDepathString(depth) + "null\n");
            return;
        }

        sb.append(genrateDepathString(depth) + node.val + "\n");
        generateBSTString(node.left,depth+1, sb);
        generateBSTString(node.right,depth+1, sb);
    }

    private String genrateDepathString(int depth) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < depth; i++){
            sb.append("==");
        }
        return sb.toString();
    }
}
