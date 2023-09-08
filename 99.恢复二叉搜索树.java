/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        Deque<TreeNode> que = new ArrayDeque<>();

        TreeNode pre = null, a = null, b = null;
        while(root != null || !que.isEmpty()){
            while(root != null){
                que.offerLast(root);
                root = root.left;
            }

            if(!que.isEmpty()){
                TreeNode n = que.pollLast();
                
                if(pre != null && a==null && pre.val > n.val){
                    // 找到的问题节点
                    // System.out.println(String.format("%s, %s", pre.val, n.val));
                    a = pre;
                }

                if(a != null && b==null && a.val < n.val){
                    // System.out.println(String.format("%s, %s, %s", a.val, n.val, pre.val));
                    b = pre;
                }

                pre = n;
                root = n.right;
            }
        }
        if(b == null) b = pre;

        // System.out.println(String.format("%s, %s", a.val, b.val));

        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
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