/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maximumSwap(int num) {
        int[] nums = new int[10];
        int len = 0;
        int tmp = num;
        for(int i=nums.length-1; i>=0 && num>0; i--){
            nums[i] = num%10;
            num /= 10;
            len++;
        }

        int begin = nums.length - len;

        for(int i=begin; i<nums.length; i++){
            int f = i;
            for(int j=nums.length-1; j>i; j--){
                if(nums[j] > nums[f]){
                    f = j;
                }
            }

            if(f!=i){
                swap(nums, i, f);
                int res = 0;
                for(int k=begin; k<nums.length; k++){
                    res= res*10 + nums[k];
                }

                return res;
            }
        }

        return tmp;
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

