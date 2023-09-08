/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        
    }
}
// @lc code=end

/**
 * 
 * d(n) = d(0)*d(n-1) + d(1)*d(n-2) + .... + d(n/2-1)*d(n/2) + d(n/2)*d(n/2-1) + ...... + d(n-1)*d(0)
 * 
 */