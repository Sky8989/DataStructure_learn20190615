package com.sky.leetcode.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * 合并两颗树
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	        Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * 注意: 合并必须从两个树的根节点开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TestMergeTrees {

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
     * 递归法 类似先序遍历 ,返回t1
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;

        if(t1 == null ) return t2;
        if(t2 == null) return t1;

        t1.val += t2.val;

        t1.left = mergeTrees(t1.left,t2.left);
        t2.right = mergeTrees(t1.right,t2.right);

        return t1;
    }
    /**
     * 不破坏 树结构
     *
     */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null) return null;

        if(t1 == null ) return t2;
        if(t2 == null) return t1;

        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);

        return root;
    }

    /**
     * 迭代法  前序遍历
     * 需要一个栈 栈中存放两个TreeNode 栈的约束类型为TreeNode[]
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2){

        if(t1 == null && t2 == null) return null;
        if(t1 == null) return  t2;
        if(t2 == null) return  t1;

        Stack<TreeNode[]> stack1 = new Stack<>();

        stack1.add(new TreeNode[]{t1,t2});

        while (!stack1.isEmpty()){
            TreeNode[] t = stack1.pop();
            if(t[0] == null && t[1] == null) continue;

            int r = t[1] == null ? 0 : t[1].val;
            //根
            t[0].val += r;

            //左
            if(t[0].left == null){
                t[0].left = r == 0 ? null : t[1].left;
            }else{
                stack1.add(new TreeNode[]{t[0].left,t[1].left});
            }

            //右
            if(t[0].right == null){
                t[0].right = r == 0 ? null : t[1].right;
            }else{
                stack1.add(new TreeNode[]{t[0].right,t[1].right});
            }

        }
        return t1;
    }


    @Test
    public void test1(){
        int[] a1 = new int[]{1,3,2,5};
        int[] a2 = new int[]{2,1,3,0,4,0,5};

        TreeNode t1 = new TreeNode(a1[0]);
        t1.left = new TreeNode(a1[1]);
        t1.right = new TreeNode(a1[2]);
        t1.left.left = new TreeNode(a1[3]);

        TreeNode t2 = new TreeNode(a2[0]);
        t2.left = new TreeNode(a2[1]);
        t2.right = new TreeNode(a2[2]);
        t2.left.left = new TreeNode(a2[3]);
        t2.left.right = new TreeNode(a2[4]);
        t2.right.left = new TreeNode(a2[5]);
        t2.right.right = new TreeNode(a2[6]);


        System.out.println("t1= " + t1);
        System.out.println("t2= " + t2);

       TreeNode res =  mergeTrees2(t1,t2);
        System.out.println("===");

        System.out.println(res);
    }
}
