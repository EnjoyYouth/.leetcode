/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0) return Arrays.asList(0);
        List<Integer>[] grid = new List[n];
        for(int i=0; i<n; i++){
            grid[i] = new ArrayList<>();
        }
        int[] degree = new int[n];

        for(int[] e : edges){
            int a = e[0], b = e[1];
            grid[a].add(b);
            grid[b].add(a);

            degree[a]++;
            degree[b]++;
        }

        Queue<Integer> que = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(degree[i] == 1) que.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!que.isEmpty()){
            res = new ArrayList<>();
            int size = que.size();
            for(int i=0; i<size; i++){
                int q = que.poll();
                res.add(q);
                for(int j=0; j<grid[q].size(); j++){
                    int t = grid[q].get(j);
                    if(--degree[t] == 1){
                        que.offer(t);
                    }
                }
            }
        }

        return res;
    }
}
// @lc code=end

