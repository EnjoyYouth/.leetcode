/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        // swap
        int i=0, n=nums.length;

        while(i<n){
            if(nums[i]<=0 || nums[i] > n || nums[i] == i+1 || nums[nums[i]-1] == nums[i]){
                i++; 
                continue;
            }
            swap(nums, i, nums[i]-1);
        }

        for(int j=0; j<n; j++){
            if(j+1 != nums[j]) return j+1;
        }

        return n+1;
    }

    void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
// @lc code=end

