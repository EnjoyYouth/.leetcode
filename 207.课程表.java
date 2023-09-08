/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] grid = new List[numCourses];
        for(int i=0; i<numCourses; i++){
            grid[i] = new ArrayList<>();
        }

        for(int[] e : prerequisites){
            inDegree[e[0]]++;
            grid[e[1]].add(e[0]);
        }

        Deque<Integer> que = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++){
            if(inDegree[i] == 0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int n = que.poll();
            for(int i=0; i<grid[n].size(); i++){
                int p = grid[n].get(i);
                if(--inDegree[p] == 0){
                    que.add(p);
                }
            }
        }

        for(int in : inDegree){
            if(in > 0) return false;
        }
        return true;
    }
}
// @lc code=end

