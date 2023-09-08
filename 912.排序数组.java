/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class Solution {
    public int[] sortArray(int[] nums) {
        // quickSort(nums, 0, nums.length-1);
        Arrays.sort(nums);
        return nums;
    }

    void quickSort(int[] nums, int begin, int end){
        if(begin>=end){
            return ;
        }

        int loc = new Random().nextInt(end-begin+1) + begin;
        // int loc = (begin+end)/2;
        swap(nums, loc, end);
        int val = nums[end];

        int i=begin, j= begin-1;
        while(i<end){
            if(nums[i] > val){
                i++;
            }else{
                swap(nums, i++, ++j);
            }
        }

        swap(nums, end, j+1);
        quickSort(nums, begin, j);
        quickSort(nums, j+2, end);
    }

    void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
// @lc code=end
