package com.sky.leetcode.tree;

import org.junit.Test;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TreeMaxDepth {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 递归法
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return  root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    @Test
    public void testMaxDepth(){
        int[] arr = new int[]{3,9,20,15,7};

        TreeNode tree = new TreeNode(arr[0]);
        tree.left = new TreeNode(arr[1]);
        tree.right = new TreeNode(arr[2]);

        tree.right.left = new TreeNode(arr[3]);
        tree.right.right = new TreeNode(arr[4]);

        int resNum = maxDepth(tree);

        System.out.println("树的高度为：" + resNum);
    }


}
