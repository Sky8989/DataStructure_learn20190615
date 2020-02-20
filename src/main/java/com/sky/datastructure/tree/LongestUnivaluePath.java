package com.sky.datastructure.tree;

import com.sky.datastructure.linked.ListNode;
import org.junit.Test;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 * 输入:
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 *
 * 输出:
 *
 * 2
 * 示例 2:
 * 输入:
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 *
 *
 */
public class LongestUnivaluePath {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public void addLeft(int n){

            TreeNode curr = this;
            while (curr.left != null){
                curr = curr.left;
            }

            curr.left = new TreeNode(n);
        }

        public void addRight(int n){
            TreeNode curr = this;

            while (curr.right != null){
                curr = curr.right;
            }

            curr.right = new TreeNode(n);
        }


        /**
         * 添加头节点
         * @param num
         */
        public void addHead(int num){
            this.val = num;
        }

        public void addNode(int num){

            if(this.left == null){
                this.left = new TreeNode(num);

            }else if(this.left != null && this.right == null){
                this.right = new TreeNode(num);
            }else if(this.left != null && this.right != null){




            }
        }


        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    @Test
    public void testLongestUnivaluePath(){

//        TreeNode root = new TreeNode(5);

//        root.addLeft(4);
//        root.addLeft(1);
//        root.left.addRight(1);
//        root.addRight(5);
//        root.addRight(5);
        TreeNode root = new TreeNode(1);
        root.addLeft(4);
        root.addLeft(4);
        root.left.addRight(4);

        root.addRight(5);
        root.right.addLeft(5);

        System.out.println("root = " + root);

       int rs =  longestUnivaluePath(root);
        System.out.println("rs = " + rs);

    }

    public int longestUnivaluePath(TreeNode root) {


       int leftNum =  checkLeft(root.left,root.val,0);
       int rightNum =  checkRight(root.right,root.val,0);

       int num =  Math.max(leftNum,rightNum);

        return num;

    }

    private int checkRight(TreeNode node, int val, int num) {

        if(node == null){
            return 0;
        }



       if(node.left != null)
       return checkLeft(node.left,node.val,num);

       if(node.right != null)
       return checkRight(node.right,node.val,num);

       return node.val == val ? num+1 : 0;
    }

    private int checkLeft(TreeNode node, int val, int num) {

        if(node.left != null)
        return checkLeft(node.left,node.val,num);

        if(node.right != null)
        return checkRight(node.right,node.val,num);

        return node.val == val ? num+1 : 0;
    }

}
