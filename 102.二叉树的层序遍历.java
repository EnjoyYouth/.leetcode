/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Deque<TreeNode> que = new ArrayDeque<>();
        TreeNode level = root;
        List<Integer> t = new ArrayList<>();

        que.offerLast(root);
        while(!que.isEmpty()){
            TreeNode n = que.pollFirst();
            if(n.left != null) que.offerLast(n.left);
            if(n.right != null) que.offerLast(n.right);

            t.add(n.val);
            if(n == level){
                res.add(t);
                t = new ArrayList<>();
                level = que.peekLast();
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