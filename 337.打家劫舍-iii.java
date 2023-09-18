/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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
    Map<TreeNode, Integer[]> dp = new HashMap<>();
    public int rob(TreeNode root) {
        return Math.max(rob(root, false), rob(root, true));
    }

    public int rob(TreeNode root, boolean parIsRobbed) {
        if(root == null) return 0;
        int index = parIsRobbed ? 0 : 1;

        if(dp.containsKey(root)){
            Integer[] in = dp.get(root);
            if(in[index] != null) return in[index];
        }

        int res = 0;
        if(parIsRobbed){
            int l = rob(root.left, false);
            int r = rob(root.right, false);
            res = l+r;
        }else{
            int l_n = rob(root.left, false);
            int r_n = rob(root.right, false);

            int l_y = rob(root.left, true);
            int r_y = rob(root.right, true);

            res = Math.max(l_y + r_y + root.val, l_n + r_n);
        }

        if(!dp.containsKey(root)) dp.put(root, new Integer[2]);

        return dp.get(root)[index] = res;
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