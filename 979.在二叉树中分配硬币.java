/*
 * @lc app=leetcode.cn id=979 lang=java
 *
 * [979] 在二叉树中分配硬币
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
    int count = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return count;
    }

    int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        int res = l + r + root.val - 1;
        count += Math.abs(res);

        return res;
    }
}
// @lc code=end

