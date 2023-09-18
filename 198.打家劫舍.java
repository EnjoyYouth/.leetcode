/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // dp[i] = max(dp[i-1], nums[i]+dp[i-2])
        int pre1 = 0, pre2 = 0;
        for(int i=0; i<nums.length; i++){
            int cur = Math.max(pre1, nums[i] + pre2);
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }
}
// @lc code=end

