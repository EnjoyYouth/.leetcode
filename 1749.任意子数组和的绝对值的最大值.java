/*
 * @lc app=leetcode.cn id=1749 lang=java
 *
 * [1749] 任意子数组和的绝对值的最大值
 */

// @lc code=start

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int pre = 0;

        int min = pre, max = pre;
        for(int i=0; i<n; i++){
            int now = pre + nums[i];
            min = Math.min(min, now);
            max = Math.max(max, now);
            pre = now;
        }

        // System.out.println(Arrays.toString(sum));

        return max - min;
    }
}
// @lc code=end

