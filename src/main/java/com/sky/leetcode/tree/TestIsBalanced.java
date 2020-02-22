package com.sky.leetcode.tree;

import org.junit.Test;

/**
 *
 */
public class TestIsBalanced {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归法 求最大深度的变式
     * @param root
     * @return
     */
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);

        return result;
    }

    private int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(Math.abs(l - r) > 1) result = false;

        return Math.max(l,r) + 1;
    }

    @Test
    public void testMaxDepth(){
        int[] arr = new int[]{3,9,20,15,7};

        TreeNode tree = new TreeNode(arr[0]);
        tree.left = new TreeNode(arr[1]);
        tree.right = new TreeNode(arr[2]);

        tree.right.left = new TreeNode(arr[3]);
        tree.right.right = new TreeNode(arr[4]);

        boolean flag = isBalanced(tree);

        System.out.println("是否为平衡树：" + flag);
    }
}
