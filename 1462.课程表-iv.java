/*
 * @lc app=leetcode.cn id=1462 lang=java
 *
 * [1462] 课程表 IV
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] grid = new boolean[numCourses][numCourses];
        for(int[] p : prerequisites){
            grid[p[0]][p[1]] = true;
        }

        for(int k=0; k<numCourses; k++){
            for(int i=0; i<numCourses; i++){
                for(int j=0; j<numCourses; j++){
                    grid[i][j] = grid[i][j] || (grid[i][k] && grid[k][j]);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] q : queries){
            res.add(grid[q[0]][q[1]]);
        }
        return res;
    }
}
// @lc code=end

