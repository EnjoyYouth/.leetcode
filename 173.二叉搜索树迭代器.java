/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {
    Deque<TreeNode> que;
    TreeNode root;

    public BSTIterator(TreeNode root) {
        this.root = root;
        que = new ArrayDeque<>();
        while(this.root != null){
            que.offerLast(this.root);
            this.root = this.root.left;
        }
    }
    
    public int next() {
        TreeNode n = que.pollLast();
        this.root = n.right;
        while(this.root != null){
            que.offerLast(this.root);
            this.root = this.root.left;
        }

        return n.val;
    }
    
    public boolean hasNext() {
        return !que.isEmpty() || root != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
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