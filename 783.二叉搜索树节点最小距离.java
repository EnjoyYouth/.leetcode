/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树节点最小距离
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

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
    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> que = new ArrayDeque<>();

        int res = Integer.MAX_VALUE;
        TreeNode pre = null;
        while(root != null || !que.isEmpty()){
            while(root != null){
                que.offerLast(root);
                root = root.left;
            }

            if(!que.isEmpty()){
                TreeNode n = que.pollLast();
                if(pre != null){
                    res = Math.min(res, Math.abs(n.val - pre.val));
                }

                pre = n;
                root = n.right;
            }
        }

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