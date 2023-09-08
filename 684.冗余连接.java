/*
 * @lc app=leetcode.cn id=684 lang=java
 *
 * [684] 冗余连接
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(1010);

        for(int[] e : edges){
            if(uf.isConnected(e[0], e[1])){
                return e;
            }

            uf.union(e[0], e[1]);
        }

        return new int[]{};
    }
}

class UnionFind{
    int[] uf;
    
    public UnionFind(int n){
        uf = new int[n];
        Arrays.fill(uf, -1);
    }

    int find(int i){
        if(uf[i] < 0){
            return i;
        }

        return uf[i] = find(uf[i]);
    }

    void union(int a, int b){
        int r1 = find(a);
        int r2 = find(b);

        if(r1 == r2){
            return;
        }

        if(r1 < r2){
            uf[r1] += uf[r2];
            uf[r2] = r1;
        }else{
            uf[r2] += uf[r1];
            uf[r1] = r2;
        }
    }

    boolean isConnected(int a, int b){
        return find(a) == find(b);
    }
}
// @lc code=end

