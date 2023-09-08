/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start


class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        UnionFind uf = new UnionFind(n*m);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    if(j>0 && grid[i][j-1] == '1'){
                        uf.union(i*m+j, i*m+j-1);
                    }

                    if(i>0 && grid[i-1][j] == '1'){
                        uf.union(i*m+j, i*m+j-m);
                    }
                }
            }
        }

        int res = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && uf.uf[i*m+j] < 0){
                    res++;
                }
            }
        }

        return res;
    }
}

class UnionFind{
    int[] uf;

    public UnionFind(int n){
        uf = new int[n];
        for(int i=0; i<n; i++){
            uf[i] = -1;
        }
    }

    public int find(int x){
        if(uf[x] < 0){
            return x;
        }

        return uf[x] = find(uf[x]);
    }

    public void union(int a, int b){
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

    public int getNumOfSet(){
        int count = 0;
        for(int n : uf){
            if(n<0){
                count++;
            }
        }

        return count;
    }
}
// @lc code=end


/**
 * [["1","0","1","1","1"],
 *  ["1","0","1","0","1"],
 *  ["1","1","1","0","1"]]
 */