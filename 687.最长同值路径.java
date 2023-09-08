/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import javax.swing.plaf.metal.MetalTheme;

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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if(root.left == null && root.right == null) return 0;
        int l=0, r=0, res=0;
        if(root.left != null){
            l = dfs(root.left);
            if(root.val == root.left.val) res = l+1;
        }
        if(root.right != null){
            r = dfs(root.right);
            if(root.val == root.right.val) res = Math.max(res, r+1);
        }

        if(root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val){
            ans = Math.max(ans, l+1+r+1);
        }

        ans = Math.max(ans, res);

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