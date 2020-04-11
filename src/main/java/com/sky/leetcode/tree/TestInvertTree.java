package com.sky.leetcode.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 *  谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestInvertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    
    //递归法
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        
        if(root.left == null && root.right == null) return root;
        
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);

        root.left = r;
        root.right = l;
        
        
        return root;
    }

    //迭代法
    public TreeNode invertTreeNR(TreeNode root){
        if(root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            TreeNode left = curr.left;
            curr.left = curr.right;
            curr.right = left;

            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);

        }
        return root;
    }

    @Test
    public void  testReverse(){
        int[] arr = new int[]{4,2,7,1,3,6,9};

        TreeNode root = new TreeNode(arr[0]);
        root.left = new TreeNode(arr[1]);
        root.right = new TreeNode(arr[2]);
        root.left.left = new TreeNode(arr[3]);
        root.right.right = new TreeNode(arr[4]);
        root.right.left = new TreeNode(arr[5]);
        root.right.right = new TreeNode(arr[6]);

//        TreeNode res = invertTree(root);
        System.out.println("===初始化" );
        System.out.println(root);
        TreeNode res = invertTreeNR(root);

        System.out.println("结果");

        System.out.println(res);
    }


    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;



        return pathSum(root.left,sum) + pathSum(root.right,sum);
    }
    

}
