package com.sky.leetcode.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

             1
            / \
           2   2
          / \ / \
         3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

          1
         / \
        2   2
         \   \
         3    3
 说明:

 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/symmetric-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestIsSymmetric {

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
     * 对称二叉树
     * 递归法
     * 对称的条件
     * 1：空树
     * 2：根节点下面左右节点的值相同
     * 3：左树下的左子 与右树下的右子的值相等。 左数的右子值与 右树的左子值相同。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return  true;
        return  helper(root.left,root.right);
    }

    /**
     * 递归判断左右树 对称
     * @param left
     * @param right
     * @return
     */
    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        if(left.val != right.val) return false;
        /**
         * 左树下的左子 与右树下的右子的值相等。 左数的右子值与 右树的左子值相同。
         */
        return helper(left.left,right.right) && helper(left.right,right.left);
    }


    /**
     * 迭代法
     * 将左右子树的值按照一个规律加入到字符串中对比是否相同
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
//        if(root == null || (root.left == null && root.right == null))return true;
        /**
         * 这样写减少边界判断
         */
       return helper1(root,root);
//       return helper1(root.left,root.right);

    }

    private boolean helper1(TreeNode left, TreeNode right) {
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();

        lStack.push(left);
        rStack.push(right);

        while (lStack.size() == rStack.size() && lStack.size() > 0){
            TreeNode currL = lStack.pop();
            TreeNode currR = rStack.pop();
            //跳过为空的比较
            if(currL == null && currR == null) continue;
            if(currL == null || currR == null) return false;

            if(currL.val != currR.val) return  false;

                lStack.push(currL.left);
                rStack.push(currR.right);


                lStack.push(currR.left);
                rStack.push(currL.right);



        }

        return true;

    }
    
    
    @Test
    public void test1(){
        int[] arr = new int[]{1,2,3,4,5};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(" 对称 = " + isSymmetric1(root));

    }


}
