/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Solution {
    public int maxArea(int[] height) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = height.length;
        int[] l = new int[n];
        int[] r = new int[n];
        
        int i=0;
        queue.push(0);
        while(!queue.isEmpty()){
            while(!queue.isEmpty() && height[queue.peekLast()] >)
        }
    }
}
// @lc code=end

