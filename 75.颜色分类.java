/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        for(int i=0, j=n-1; i<j; ){
            if(nums[i] == 0 || nums[j] != 0){
                if(nums[i] == 0) i++;
                if(nums[j] != 0) j--;
                continue;
            }

            swap(nums, i++, j--);
        }

        for(int i=0, j=n-1; i<j; ){
            if(nums[i] == 0 || nums[i] == 1){
                i++;
                continue;
            }
            if(nums[j] == 2){
                j--;
                continue;
            }

            swap(nums, i++, j--);
        }
    }

    void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
// @lc code=end

