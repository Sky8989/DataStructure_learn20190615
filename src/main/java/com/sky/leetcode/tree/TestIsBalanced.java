package com.sky.leetcode.tree;

import org.junit.Test;

import java.util.Map;
import java.util.Stack;

/**
 *给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestIsBalanced {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
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

    /**
     *自顶向下的递归
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root){
        if(root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    /**
     * 递归求当前节点的高度 空树的高度为-1
     * @param root
     * @return
     */
    private int height(TreeNode root){
        if(root == null) return -1;

        return Math.max(height(root.left),height(root.right)) + 1;
    }

    /**
     * 迭代法
     *   左右树 深度差不超过1
     * @param root
     * @return
     */
    public boolean isBalancedNR(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> node = new Stack<>();

        node.add(root);

        while(!node.isEmpty()){
            TreeNode curr = node.pop();

            if(curr.left == null && curr.right == null) continue;

            int l = getHeight(curr.left);

            int r = getHeight(curr.right);

            if(Math.abs(l - r) > 1) return false;

            if(curr.left != null) node.push(curr.left);
            if(curr.right != null) node.push(curr.right);
        }
        return true;
    }

    /**
     * 迭代法求树的高度
     * @param root
     * @return
     */
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;

        Stack<TreeNode> node = new Stack<>();
        Stack<Integer> height = new Stack<>();

        int max_height = 0;

        node.push(root);
        height.push(1);


        while (!node.isEmpty()){
            TreeNode curr = node.pop();
            int curr_height = height.pop();

            if(curr.left == null && curr.right == null){
                max_height = Math.max(max_height,curr_height);
                continue;
            }

            if(curr.left != null){
                node.push(curr.left);
                height.push(curr_height + 1);
            }

            if(curr.right != null){
                node.push(curr.right);
                height.push(curr_height + 1);
            }

        }

        return max_height;

    }




    @Test
    public void testMaxDepth(){
        int[] arr = new int[]{3,9,20,15,7};
//        [1,2,2,3,3,null,null,4,4]

//        TreeNode tree = new TreeNode(arr[0]);
//        tree.left = new TreeNode(arr[1]);
//        tree.right = new TreeNode(arr[2]);
//
//        tree.right.left = new TreeNode(arr[3]);
//        tree.right.right = new TreeNode(arr[4]);


        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);

        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(3);

        tree.left.left.left = new TreeNode(4);
        tree.left.left.right = new TreeNode(4);
        System.out.println(tree);

        System.out.println("getHeight = " + getHeight(tree));
//        boolean flag = isBalancedNR(tree);
//
//        System.out.println("是否为平衡树：" + flag);
    }

    /**
     * 自底向上的递归
     *
     * 思路
     *
     * 方法一计算 height\texttt{height}height 存在大量冗余。每次调用 height\texttt{height}height 时，要同时计算其子树高度。但是自底向上计算，每个子树的高度只会计算一次。可以递归先计算当前节点的子节点高度，然后再通过子节点高度判断当前节点是否平衡，从而消除冗余。
     *
     * 算法
     *
     * 使用与方法一中定义的 height\texttt{height}height 方法。自底向上与自顶向下的逻辑相反，首先判断子树是否平衡，然后比较子树高度判断父节点是否平衡。算法如下：
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    // Utility class to store information from recursive calls
    final class TreeInfo {
        public final int height;
        public final boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    // Return whether or not the tree at root is balanced while also storing
    // the tree's height in a reference variable.
    private TreeInfo isBalancedTreeHelper(TreeNode root) {
        // An empty tree is balanced and has height = -1
        if (root == null) {
            return new TreeInfo(-1, true);
        }

        // Check subtrees to see if they are balanced.
        TreeInfo left = isBalancedTreeHelper(root.left);
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo right = isBalancedTreeHelper(root.right);
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }

        // Use the height obtained from the recursive calls to
        // determine if the current node is also balanced.
        if (Math.abs(left.height - right.height) < 2) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }
        return new TreeInfo(-1, false);
    }

    public boolean isBalanced2(TreeNode root) {
        return isBalancedTreeHelper(root).balanced;
    }



}
