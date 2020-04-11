package com.sky.leetcode.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。

 找出路径和等于给定数值的路径总数。

 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

 示例：

 root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

          10
         /  \
        5   -3
       / \    \
      3   2   11
     / \   \
    3  -2   1

 返回 3。和等于 8 的路径有:

 1.  5 -> 3
 2.  5 -> 2 -> 1
 3.  -3 -> 11

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/path-sum-iii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestPathSum {
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
     * 递归法  递归每个节点 去调用求路径和
     * @param root
     * @param sum
     * @return
     */
    public int pathSum1(TreeNode root,int sum){
        if(root == null) return 0;

        return  getSum(root,sum) + pathSum1(root.left,sum) + pathSum1(root.right,sum);
    }

    //递归求路径和
    private int getSum(TreeNode root, int sum){
        if(root == null) return  0;

        int res = 0;
        if(sum == root.val) res++;

        res += getSum(root.left, sum - root.val) + getSum(root.right, sum - root.val);
        return res;
    }

    /**
     * 迭代法
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        /**
         *思路
         1：先按层序遍历 存储起来
         2：在每个节点进行递归 计算路径和
         3：退出条件 递归的当前节点 往下递归时，只要出现路径和满足条件记录+1
         */

        Stack<TreeNode> tempStack = new Stack<>();
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        tempStack.push(root);

        while(!tempStack.isEmpty()){
            TreeNode curr = tempStack.pop();

            node_stack.add(curr);

            if(curr.right != null) tempStack.add(curr.right);
            if(curr.left != null) tempStack.add(curr.left);
        }

        int sum1 = 0;
        //每个节点进行递归求符合路径的个数
        while(!node_stack.isEmpty()){
            //递归
            TreeNode curr = node_stack.pollFirst();
            sum1 += helper(curr,sum);

        }
        return sum1;

    }
    private int helper(TreeNode root,int sum){

        //退出条件
        LinkedList<TreeNode> node_stack = new LinkedList<>();
        //用来存每次sum 每次经过一个节点 减去对应节点后剩下的值 sum - root.val
        LinkedList<Integer> num_stack = new LinkedList<>();

        node_stack.add(root);
        num_stack.add(sum - root.val);

        int resNum = 0;
        /**
         * 层序遍历 每次经过一个节点 num_stack存储 sum-curr.val的值
         */
        while(!node_stack.isEmpty()){
            TreeNode curr = node_stack.pollFirst();
            int curr_num = num_stack.pollFirst();

            //满足路径
            if(curr_num == 0)
                 resNum++;


            if(curr.right != null){
                node_stack.add(curr.right);
                num_stack.add(curr_num - curr.right.val);
            }

            if(curr.left != null){
                node_stack.add(curr.left);
                num_stack.add(curr_num - curr.left.val);
            }
        }
        return resNum;
    }


    /**
     * 递归优化版本， 添加两个参数 Array用来存某一次递归时所遍历结点的结果值，index表示当前节点的位置(数组中的下标)
     * @param sum
     * @return
     */
    public int pathSum1Pro(TreeNode root,int sum){
        if(root == null) return 0;
        return helperPro(root,sum,new int[1000],0); //根节点在数组中对应下标为0
    }

    private int helperPro(TreeNode root, int sum, int[] arr, int index) {
        if(root == null) return 0;

        arr[index] = root.val;
        int num = 0;
        int temp = 0;
        /**
         * TreeNode 的节点反向遍历求路径
         */
        for(int i = index; i >= 0; i--){
            temp += arr[i];
            if(temp == sum){
                num++;
            }
        }
        //递归
         return  num + helperPro(root.left,sum,arr,index + 1) + helperPro(root.right, sum,arr,index + 1);
     }


    @Test
    public void test1(){
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.right = new TreeNode(3);
        tree.right.right.right = new TreeNode(4);
        tree.right.right.right.right = new TreeNode(5);

        int i = pathSum1Pro(tree,3);
      //  int i = pathSumN(tree,3);

        System.out.println(" res = " + i);
    }


    public int pathSumN(TreeNode root, int sum) {
        if(root == null) return 0;

        //  return helper(root,sum)  ? 1 : 0;

        return (helperN(root,sum)  ? 1 : 0) + pathSumN(root.left,sum) + pathSumN(root.right,sum);
    }

    public boolean helperN(TreeNode root, int sum){
        if(root == null) return false;

        if(root.val == sum) return true;

        return helperN(root.left,sum - root.val) || helperN(root.right, sum - root.val);
    }
}
