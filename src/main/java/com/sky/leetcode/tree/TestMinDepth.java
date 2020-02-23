package com.sky.leetcode.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个二叉树，找出其最小深度。

 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

 说明: 叶子节点是指没有子节点的节点。

 示例:

 给定二叉树 [3,9,20,null,null,15,7],

          3
         / \
        9  20
          /  \
         15   7
 返回它的最小深度  2.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestMinDepth {

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

    /**
     * 递归法 借用一个参数
     */
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        helper(root,1);
        return res;
        
    }

    /**
     * 递归求最大深度， 顺便求出最小深度
     * @param root
     * @param len
     * @return
     */
    private int helper(TreeNode root,int len){
        if(root == null) return 0;
        if(root.left == null && root.right == null) res = Math.min(res,len);
        return Math.max(helper(root.left,len+1), helper(root.right,len+1));

    }

    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root){
        /**
         * 先处理边界情况
         */
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        int min_depth = Integer.MAX_VALUE;

        if(root.left != null) min_depth = Math.min(minDepth1(root.left),min_depth);
        if(root.right != null) min_depth = Math.min(minDepth1(root.right),min_depth);

        return min_depth + 1;
    }

    /**
     *迭代法 深度优先搜索
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null)return 1;

        Stack<TreeNode> node = new Stack<>();
        Stack<Integer> depth = new Stack<>();

        int min_depth = Integer.MAX_VALUE;
        node.add(root);
        depth.add(1);

        while (!node.isEmpty()){

            TreeNode curr = node.pop();
            int curr_depth = depth.pop();

            if(curr.left == null && curr.right == null) min_depth = Math.min(min_depth,curr_depth);

            if(curr.left != null){
                node.add(curr.left);
                depth.add(curr_depth+1);
            }

            if(curr.right != null){
                node.add(curr.right);
                depth.add(curr_depth+1);
            }

        }
        return min_depth;
    }


    @Test
    public void test1(){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int res = minDepth1(root);
        System.out.println("最小深度 = " + res);


    }
}
