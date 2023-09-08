/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
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
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    public int sumRootToLeaf(TreeNode root, int x) {
        int cur = x*2 + root.val;
        if(root.left == null && root.right == null) {
            return cur;
        }
        int res = 0;
        if(root.left != null) res+=sumRootToLeaf(root.left, cur);
        if(root.right != null) res+=sumRootToLeaf(root.right, cur);
        return res;
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