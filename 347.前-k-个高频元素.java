/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map.Entry<Integer, Integer>[] dp =  map.entrySet().toArray(new Map.Entry[0]);

        Queue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>(Map.Entry.comparingByValue());

        for(int i=0; i<k; i++){
            que.offer(dp[i]);
        }

        for(int i=k; i<dp.length; i++){
            Map.Entry<Integer, Integer> m = que.peek();
            if(m.getValue().compareTo(dp[i].getValue()) < 0){
                que.poll();
                que.offer(dp[i]);
            }
        }

        return que.stream().mapToInt( a -> a.getKey().intValue()).toArray();
    }
}
// @lc code=end

