/*
 * @lc app=leetcode.cn id=1719 lang=java
 *
 * [1719] 重构一棵树的方案数
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int checkWays(int[][] pairs) {
        int n = pairs.length;
        int[] degree = new int[510];
        boolean[][] grid = new boolean[510][510];
        Set<Integer> set = new HashSet<>();

        for(int[] p : pairs){
            int a=p[0], b=p[1];
            degree[a]++;
            degree[b]++;
            grid[a][b] = true;
            grid[b][a] = true;
            set.add(a);
            set.add(b);
        }

        List<Integer> list = new ArrayList<>(set);
        list.sort((a, b) -> degree[b] - degree[a]);
        if(n < list.size()-1) return 0;

        int[] par = new int[list.size()];
        par[0] = -1;
        for(int i=1; i<list.size(); i++){
            int a = list.get(i);
            boolean isOk = false;
            for(int j=i-1; j>=0 && !isOk; j--){
                int b = list.get(j);
                if(grid[b][a]){
                    isOk = true;
                    par[i] = j;
                }
            }

            if(!isOk) return 0;
        }

        // System.out.println(list);
        // System.out.println(Arrays.toString(par));

        int ans = 1, c = 0;
        for(int i=0; i<list.size(); i++){
            int j=i;
            int a = list.get(i);
            // System.out.println(i);
            while(par[j] != -1){
                int b = list.get(par[j]);
                if(!grid[a][b]) return 0;
                if(degree[a] == degree[b]) ans = 2;
                j = par[j];
                c++;
            }
        }

        return c<n ? 0 : ans;
    }
}
// @lc code=end

