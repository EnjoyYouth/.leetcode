/*
 * @lc app=leetcode.cn id=1123 lang=java
 *
 * [1123] 最深叶节点的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int depth = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth(root, 0);
        TreeNode res = lcaDeepestLeaves(root, 0);

        return res;
    }

    public void depth(TreeNode root, int d){
        if(root == null) return ;
        this.depth = Math.max(depth, d);
        depth(root.left, d+1);
        depth(root.right, d+1);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root, int d) {
        if(root == null) return null;
        
        TreeNode l = lcaDeepestLeaves(root.left, d+1);
        TreeNode r =  lcaDeepestLeaves(root.right, d+1);

        if(d == depth){
            return root;
        }

        if(l==null) return r;
        if(r==null) return l;

        return root;
    }
}
// @lc code=end

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}