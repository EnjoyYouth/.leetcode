/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }

        return uf.getSetNum();
    }
}

class UnionFind{
    int[] uf;

    public UnionFind(int n){
        uf = new int[n];
        Arrays.fill(uf, -1);
    }

    int find(int x){
        if(uf[x] < 0){
            return x;
        }

        return uf[x] = find(uf[x]);
    }

    void union(int a, int b){
        int r1 = find(a);
        int r2 = find(b);

        if(r1 == r2){
            return ;
        }

        if(uf[r1] < uf[r2]){
            uf[r1] += uf[r2];
            uf[r2] = r1;
        }else{
            uf[r2] += uf[r1];
            uf[r1] = r2;
        }
    }

    int getSetNum(){
        int count = 0;
        for(int x : uf){
            if(x<0){
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

