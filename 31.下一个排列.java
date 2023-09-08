/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1) return;

        int index = n-2;
        while(index >=0 && nums[index] >= nums[index+1]){
            index--;
        }
        if(index == -1) swap(nums, 0, n-1);
        else{
            // 从右往左找第一个大于nums[index]的值
            for(int i=n-1; i>=0; i--){
                if(nums[i] > nums[index]){
                    int tmp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = tmp;
                    break;
                }
            }

            swap(nums, index+1, n-1);
        }
    }
    
    void swap(int[] nums, int a, int b){
        if(a>=b) return;

        while(a<b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
            a++;
            b--;
        }
    }
}
// @lc code=end

/**
 * 123
 * 132
 * 213
 * 231
 * 312
 * 321
 */