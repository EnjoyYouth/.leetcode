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
    List<Integer>[] grid;
    int[] f1, f2, g, p;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        grid = new List[n];
        f1 = new int[n]; f2 = new int[n]; g = new int[n]; p = new int[n];

        for(int i=0; i<n; i++){
            grid[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            grid[e[0]].add(e[1]);
            grid[e[1]].add(e[0]);
        }

        dfs1(0, -1);
        dfs2(0, -1);

        List<Integer> ans = new ArrayList<>();
        int now = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int cur = Math.max(f1[i], g[i]);
            if(cur < now){
                ans.clear();
                now = cur;
                ans.add(i);
            }else if(cur == now){
                ans.add(i);
            }
        }
        return ans;
    }

    int dfs1(int u, int fa){
        for(int i=0; i<grid[u].size(); i++){
            int t = grid[u].get(i);
            if(t == fa) continue;
            int sub = dfs1(t, u) + 1;
            if(sub > f1[u]){
                f2[u] = f1[u];
                f1[u] = sub;
                p[u] = t;
            }else if(sub > f2[u]){
                f2[u] = sub;
            }
        }

        return f1[u];
    }

    void dfs2(int u, int fa){
        for(int i=0; i<grid[u].size(); i++){
            int t = grid[u].get(i);
            if(t == fa) continue;

            if(p[u] == t) g[t] = f2[u]+1;
            else g[t] = f1[u] + 1;
            g[t] = Math.max(g[t], g[u] + 1);

            dfs2(t, u);
        }
    }
}
// @lc code=end

