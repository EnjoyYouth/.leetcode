/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入二叉搜索树
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
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> l = new ArrayDeque<>();
        Deque<TreeNode> r = new ArrayDeque<>();
        TreeNode lNode = root;
        TreeNode rNode = root;

        TreeNode _l = null, _r = null;
        boolean lf = true, rf = true;

        while((lNode != null || !l.isEmpty()) && (rNode != null || !r.isEmpty())){

            while(lNode != null){
                l.offerLast(lNode);
                lNode = lNode.left;
            }

            if(lf && !l.isEmpty()){
                TreeNode n = l.pollLast();
                _l = n;
                lf = false;
                lNode = n.right;
            }

            while(rNode != null){
                r.offerLast(rNode);
                rNode = rNode.right;
            }

            if(rf && !r.isEmpty()){
                TreeNode n = r.pollLast();
                _r = n;
                rf = false;
                rNode = n.left;
            }

            if(_l == _r) return false;

            // System.out.println(String.format("%s, %s", _l.val, _r.val));
            int cur = _l.val + _r.val;
            if(cur == k) return true;
            else if(cur > k){
                rf = true;
            }else{
                lf = true;
            }
        }

        return false;
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