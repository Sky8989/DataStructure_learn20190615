package com.sky.datastructure.tree;

import org.junit.Test;

public class RangeSortSum {


    @Test
    public void RangeSumTest(){
//        int l = 6;
        int l = 7;
//        int r = 10;
        int r = 15;

        int[] arr = new int[]{10,5,15,3,7,0,18};
//        int[] arr = new int[]{10,5,15,3,7,13,18,1,0,6};

        TreeNode root = new TreeNode(arr[0]);
        for(int num : arr){
            root.add(num);
        }

        int resultNum = rangeSumBST1(root,l,r);

        System.out.println(resultNum);
    }

    /**
     * 中序遍历范围求和 递归法
     * @param root
     * @param L
     * @param R
     * @return
     */

    int numberSum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }

        if(root.left != null){
            this.rangeSumBST(root.left,L,R);
        }

        if(root.val >= L && root.val <= R){
            numberSum += root.val;
           // System.out.println("val = " + root.val);
        }

        if(root.right != null){
            this.rangeSumBST(root.right,L,R);
        }

        return numberSum;
    }


    /**
     * 非递归
     * @param root
     * @param L
     * @param R
     * @return
     */
    public int rangeSumBST1(TreeNode root, int L, int R) {
        int numberSum = 0;
        if (root == null) {
            return 0;
        }
        return numberSum;
    }


     class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }


      public void add(int num){
              //根为空
              if(val == 0 && left == null && right == null){
                  val = num;
                  return;
              }else {
                  //根不为空
                  if(val == num){
                      val = num;
                  }else if(val > num ){
                      //左边

                      if(this.left == null){
                          this.left = new TreeNode(num);

                      }else{
                          this.left.add(num);
                      }
                  }else if(val < num ){
                      //右边
                      if(this.right == null){
                          this.right = new TreeNode(num);

                      }else{
                          this.right.add(num);
                      }
                  }
              }
      }
  }
}
