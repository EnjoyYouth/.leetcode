/*
 * @lc app=leetcode.cn id=2679 lang=java
 *
 * [2679] 矩阵中的和
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int matrixSum(int[][] nums) {
        // n*m*m
        // n*m*logm

        for(int[] num : nums){
            Arrays.sort(num);
        }

        int res = 0;
        int n = nums.length, m = nums[0].length;
        for(int i=m-1; i>=0; i--){
            int tmp = -1;
            for(int j=0; j<n; j++){
                tmp = Math.max(tmp, nums[j][i]);
            }

            res += tmp;
        }

        return res;
    }
}
// @lc code=end

