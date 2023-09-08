/*
 * @lc app=leetcode.cn id=987 lang=java
 *
 * [987] 二叉树的垂序遍历
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import javafx.util.Pair;

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

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<Pair<TreeNode, int[]>> que = new ArrayDeque<>();
        que.offerLast(new Pair<TreeNode,int[]>(root, new int[]{0, 0}));
        TreeNode l = root;
        int level = 0;

        while(!que.isEmpty()){
            Pair<TreeNode, int[]> p = que.pollFirst();
            TreeNode n = p.getKey();
            int[] c = p.getValue();

            if(n.left != null) que.offerLast(new Pair<TreeNode,int[]>(n.left, new int[]{c[0]+1, c[1]-1}));
            if(n.right != null) que.offerLast(new Pair<TreeNode,int[]>(n.right, new int[]{c[0]+1, c[1]+1}));

            int rc = c[1]+N;
            if(dp[rc] == null){
                dp[rc] = new ArrayList<>();
            }

            if(dp[rc].size()>0 && dp[rc].get(dp[rc].size()-1) == level){

            }

            level = c[0];
        }
        
        return res;
    }

    void verticalTraversal(TreeNode root, int row, int col) {
        if(root == null){
            return ;
        }

        if(dp[col + N] == null){
            dp[col + N] = new ArrayList<>();
        }
        if(dp[col+N].size()>0 && dp[col+N].get(dp[col+N].size()-1)[1] == row && dp[col+N].get(dp[col+N].size()-1)[0] > root.val) {
            dp[col+N].add(new int[]{dp[col+N].get(dp[col+N].size()-1)[0], row});
            dp[col+N].get(dp[col+N].size()-2)[0] = root.val;
        }else{
            dp[col+N].add(new int[]{root.val, row});
        }

        verticalTraversal(root.left, row+1, col-1);
        verticalTraversal(root.right, row + 1, col + 1);
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