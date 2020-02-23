package com.sky.leetcode.tree;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

 示例 1:
 给定的树 s:

          3
         / \
        4   5
       / \
      1   2
 给定的树 t：

          4
         / \
        1   2
 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

 示例 2:
 给定的树 s：

              3
             / \
            4   5
           / \
          1   2
         /
        0
 给定的树 t：

          4
         / \
        1   2
 返回 false。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TestIsSubtree {
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
     *  递归法 每个节点，当成一个子树与t 进行比较
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;

        return helper(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    /**
     * 递归判断 子树是否相等
     * @param s
     * @param t
     * @return
     */
    private boolean helper(TreeNode s, TreeNode t){
        //两树的同一个位置相等
        if(s == null && t == null) return  true;
        if(s == null || t == null) return  false;  //同一位置节点不同

        if(s.val != t.val) return  false;
        //向下递归 左右子树同时满足
        return helper(s.left,t.left) && helper(s.right,t.right);
    }


    /***
     * === leetcode 优秀解
     */


    /**
     *
     * 考虑递归解法，则首先考虑如何分解问题。
         题目给出s和t两树，让我们求解t是不是s的子树，那么：
         t就等于s本身
         t是s的左子树的子树
         t是s的右子树的子树

     * 判断 t 树是否是 s 树的子树
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree1(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null) return false;

        //当有一个节点相同时 在考虑进行第二层递归
        if(s.val == t.val){
            return isEqual(s,t) || isSubtree1(s.left, t) || isSubtree1(s.right, t);
        }
        // 根节点不同，那么就不同考虑s和t相等的情形了
        return isSubtree1(s.left, t) || isSubtree1(s.right, t);
    }

    /**
     *
     * 也就是递归体在于以上三步，因此，根据第一点，我们需要一个判断两树相等的函数（同样使用递归）

     问题变成：我们如何判断两树（l、r）相等呢？
     根节点值相等
     l的左子树和r的左子树相等
     l的右子树和r的右子树相等

     *
     * 判断两树是否相等
     * @param l
     * @param r
     * @return
     */
    private boolean isEqual(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;//两树均空自然相等
        if(l == null || r == null) return false;//一空一非空，自然不等
        //递归判断
        if(l.val != r.val) return false;
        return  isEqual(l.left,r.left) && isEqual(l.right,r.right);
    }

//    作者：onthewayLCB
//    链接：https://leetcode-cn.com/problems/subtree-of-another-tree/solution/di-gui-jie-fa-by-onthewaylcb/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
