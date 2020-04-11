package com.sky.leetcode.tree;

import java.util.Stack;

/**
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestSumOfLeftLeaves {

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
     * 递归法
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;

        return helper(root.left,true) + helper(root.right,false);
    }

    private int helper(TreeNode root, boolean isLeft){
        if(root == null )return 0;

        if(isLeft && root.left == null && root.right == null) return root.val;

        return helper(root.left,true) +  helper(root.right,false);

    }

    /**
     * 迭代法
     * @param root
     * @return
     */
    public int sumOfLeftLeavesNR(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;

        return helperNR(root);

    }

    /**
     * 迭代法 求当前树下的所有左叶子值的和
     * @param root
     * @return
     */
    private int helperNR(TreeNode root) {
        Stack<TreeNode> node = new Stack<>();
        Stack<Boolean>  isLeft = new Stack<>();

        int sum = 0;

        node.push(root);
        isLeft.push(false);

        while (!node.isEmpty()){
            TreeNode curr = node.pop();
            boolean left = isLeft.pop();

            if(left && curr.left == null && curr.right == null) sum+= curr.val;


            if(curr.left != null){
                node.push(curr.left);
                isLeft.push(true);
            }

            if(curr.right != null){
                node.push(curr.right);
                isLeft.push(false);
            }
        }

        return sum;

    }

}
