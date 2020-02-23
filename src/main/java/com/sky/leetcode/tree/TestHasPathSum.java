package com.sky.leetcode.tree;

import java.util.LinkedList;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

 说明: 叶子节点是指没有子节点的节点。

 示例: 
 给定如下二叉树，以及目标和 sum = 22，

          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
     7    2      1
 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/path-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestHasPathSum {

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
     * 每经过一个节点就用sum 减去对应的值，当root 为叶子节点时 判断 sum是否为0
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        sum -= root.val;
        //判断是否为叶子节点
        if(root.left == null && root.right == null) return sum == 0;
        //递归
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);

    }

    /**
     * 递归法
     * 多定义一个变量， total， 当root为叶子节点时，比较 total == sum 返回true
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum1(TreeNode root, int sum){
        return helper(root,sum,0);
    }

    /**
     * 递归法
     * @param root
     * @param sum
     * @param total 将每条路径的值求和
     * @return
     */
    private boolean helper(TreeNode root, int sum, int total) {
        if(root == null) return false;

        total += root.val;

        if(root.left == null && root.right == null) return sum == total;

        return helper(root.left,sum,total) || helper(root.right,sum,total);
    }

    /**
     * 迭代法 使用链表模拟栈
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum2(TreeNode root,int sum){
        if(root == null) return false;
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        //用来存每次sum 每次经过一个节点 减去对应节点后剩下的值 sum - root.val
        LinkedList<Integer> num_stack = new LinkedList<>();

        node_stack.add(root);
        num_stack.add(sum - root.val);

        /**
         * 层序遍历 每次经过一个节点 num_stack存储 sum-curr.val的值
         */
        while(!node_stack.isEmpty()){
           TreeNode curr = node_stack.pollFirst();
           int curr_num = num_stack.pollFirst();

           if(curr.left == null && curr.right == null && curr_num == 0) return true;

           if(curr.right != null){
               node_stack.add(curr.right);
               num_stack.add(curr_num - curr.right.val);
           }

           if(curr.left != null){
               node_stack.add(curr.left);
               num_stack.add(curr_num - curr.left.val);
           }
        }

        return false;
    }
}
