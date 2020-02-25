package com.sky.leetcode.tree;

import org.junit.Test;

import java.util.Stack;

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

    /**
     * 迭代法  有两个栈一个存节点, 一个存节点对应的深度
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root){
        if(root == null) return 0;

        Stack<TreeNode> node = new Stack<>();
        Stack<Integer> depth = new Stack<>();

        int max_depth = 0;

        node.push(root);
        depth.push(1);

        while (!node.isEmpty()){
            TreeNode curr = node.pop();
            int curr_depth = depth.pop();

            //到达叶子节点进行判断
            if(curr.left == null && curr.right == null) {
                max_depth = Math.max(max_depth,curr_depth);
                continue;
            }

            if(curr.left != null){
                node.push(curr.left);
                depth.push(curr_depth+1);
            }

            if(curr.right != null){
                node.push(curr.right);
                depth.push(curr_depth+1);
            }
        }
        return max_depth;
    }




    @Test
    public void testMaxDepth(){
        int[] arr = new int[]{3,9,20,15,7};

        TreeNode tree = new TreeNode(arr[0]);
        tree.left = new TreeNode(arr[1]);
        tree.right = new TreeNode(arr[2]);

        tree.right.left = new TreeNode(arr[3]);
        tree.right.right = new TreeNode(arr[4]);

        int resNum = maxDepth1(tree);

        System.out.println("树的高度为：" + resNum);
    }


}
