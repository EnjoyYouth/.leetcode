/*
 * @lc app=leetcode.cn id=630 lang=java
 *
 * [630] 课程表 III
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1]-b[1]);
        Queue<Integer> que = new PriorityQueue<>((a, b) -> b-a);
        int sum = 0;
        for(int[] c : courses){
            sum += c[0];
            que.offer(c[0]);
            if(sum > c[1]) sum-=que.poll();
        }

        return que.size();
    }
}
// @lc code=end

