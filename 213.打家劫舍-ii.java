/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        // dp[i] = max{dp[i-1], dp[i-1] + nums[i]}
        int pre1 = 0, pre2 = 0;
        int res = 0;
        for(int i=0; i<nums.length-1; i++){
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }

        res = pre1;
        pre1 = 0; pre2 = 0;
        for(int i=1; i<nums.length; i++){
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }

        return res = Math.max(res, pre1);
    }
}
// @lc code=end

