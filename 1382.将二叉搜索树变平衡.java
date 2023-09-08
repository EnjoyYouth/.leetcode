/*
 * @lc app=leetcode.cn id=1382 lang=java
 *
 * [1382] 将二叉搜索树变平衡
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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        inOrder(root, in);

        return createBST(in, 0, in.size()-1);
    }

    TreeNode createBST(List<Integer> in, int begin, int end){
        if(begin > end){
            return null;
        }

        int mid = (begin + end)/2;
        TreeNode l = createBST(in, begin, mid-1);
        TreeNode r = createBST(in, mid+1, end);

        return new TreeNode(in.get(mid), l, r);
    }

    void inOrder(TreeNode root, List<Integer> in){
        if(root == null){
            return ;
        }

        inOrder(root.left, in);
        in.add(root.val);
        inOrder(root.right, in);
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