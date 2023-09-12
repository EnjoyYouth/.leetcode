/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start

import java.util.ArrayList;
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
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int begin, int end) {
        List<TreeNode> res = new ArrayList<>();
        if(begin > end) return res;
        if(begin == end) {
            res.add(new TreeNode(begin));
            return res;
        }

        for(int i=begin; i<=end; i++){
            List<TreeNode> l = generateTrees(begin, i-1);
            List<TreeNode> r = generateTrees(i+1, end);

            if(l.isEmpty()){
                for(TreeNode rNode : r){
                    res.add(new TreeNode(i, null, rNode));
                }
                continue;
            }
            if(r.isEmpty()){
                for(TreeNode lNode : l){
                    res.add(new TreeNode(i, lNode, null));
                }
                continue;
            }
            for(TreeNode lNode : l){
                for(TreeNode rNode : r){
                    res.add(new TreeNode(i, lNode, rNode));
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