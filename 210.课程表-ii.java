/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] grid = new List[numCourses];
        for(int i=0; i<numCourses; i++){
            grid[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree, 0);
        for(int[] e : prerequisites){
            int from = e[1], to = e[0];
            inDegree[to]++;
            grid[from].add(to);
        }

        Queue<Integer> que = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                que.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>(numCourses);
        while(!que.isEmpty()){
            int n = que.poll();
            res.add(n);

            for(int i=0; i<grid[n].size(); i++){
                int to = grid[n].get(i);
                if(--inDegree[to] == 0){
                    que.offer(to);
                }
            }
        }

        return res.size() == numCourses ? res.stream().mapToInt(a->a.intValue()).toArray() : new int[]{};
    }
}
// @lc code=end

