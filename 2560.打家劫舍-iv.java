/*
 * @lc app=leetcode.cn id=2560 lang=java
 *
 * [2560] 打家劫舍 IV
 */

// @lc code=start
class Solution {

    /**
     * 二分+dp
     * TODO 二分开闭区间的写法
     */
    public int minCapability(int[] nums, int k) {
        int left = 0, right = 0;
        for(int num : nums){
            right = Math.max(num, right);
        }

        while(left + 1 < right){
            int mid = (left + right)/2;
            if(check(nums, k, mid)){
                right = mid;
            }else{
                left = mid;
            }
        }

        return right;
    }

    boolean check(int[] nums, int k, int mx){
        // f(i) = max{f(i-2) + 1 (nums[i] <= mx), f(i-1)}
        int pre1 = 0, pre2 = 0;
        for(int num : nums){
            if(num > mx) pre2 = pre1;
            else{
                int cur = Math.max(pre2 + 1, pre1);
                pre2 = pre1;
                pre1 = cur;
            }
        }

        return pre1 >= k;
    }
}
// @lc code=end