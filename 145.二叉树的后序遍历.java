/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();

        TreeNode pre = null;
        while(root!=null || !que.isEmpty()){
            while(root != null){
                que.offerLast(root);
                root = root.left;
            }

            if(!que.isEmpty()){
                TreeNode n = que.peekLast();
                if(n.right == null || n.right == pre){
                    que.pollLast();
                    res.add(n.val);
                    pre = n;
                }else{
                    root = n.right;
                }
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