/*
 * @lc app=leetcode.cn id=2605 lang=java
 *
 * [2605] 从两个数字数组里生成最小数字
 */

// @lc code=start
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] count = new int[10];
        for(int num : nums1){
            count[num] += 1;
        }
        for(int num : nums2){
            count[num] += 2;
        }

        int a1=0, a2=0;
        for(int i=0; i<=9; i++){
            if(count[i] == 3) return i;
            if(a1==0 && count[i]==1) a1 = i;
            if(a2==0 && count[i]==2) a2 = i;
        }

        return Math.min(a1, a2)*10 + Math.max(a1, a2);
    }
}
// @lc code=end

