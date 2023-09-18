/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */

// @lc code=start
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key){
            if(root.right == null && root.left == null){
                return null;
            }else if(root.right == null){
                return root.left;
            }else if(root.left == null){
                return root.right;
            }else{
                TreeNode rLeft = root.right.left;
                root.right.left = root.left;
                if(root.left.right == null){
                    root.left.right = rLeft;
                }else{
                    // 寻找l-r的最右节点
                    TreeNode n = root.left.right;
                    while(n.right != null){
                        n = n.right;
                    }
                    n.right = rLeft;
                }
                return root.right;
            }
        }

        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
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