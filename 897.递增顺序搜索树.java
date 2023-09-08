/*
 * @lc app=leetcode.cn id=897 lang=java
 *
 * [897] 递增顺序搜索树
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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return root;

        Deque<TreeNode> que = new ArrayDeque<>();
        TreeNode res = new TreeNode();
        TreeNode tmp = res;
        while(root != null || !que.isEmpty()){
            while(root != null){
                que.offerLast(root);
                root = root.left;
            }

            if(!que.isEmpty()){
                TreeNode n = que.pollLast();
                root = n.right;

                tmp.right = n;
                n.left=null; n.right=null;
                tmp = tmp.right;
            }
        }

        return res.right;
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