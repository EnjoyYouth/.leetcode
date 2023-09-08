/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        UnionFind uf = new UnionFind(m*n);

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(j>0 && board[i][j] == board[i][j-1]){
                    uf.union(i*n+j, i*n+j-1);
                }

                if(i>0 && board[i][j] == board[i-1][j]){
                    uf.union(i*n+j, i*n+j-n);
                }
            }
        }

        Set<Integer> s = new HashSet<>();
        for(int i=0; i<n; i++){
            if(board[0][i] == 'O'){
                s.add(uf.find(i));
            }

            if(board[m-1][i] == 'O'){
                s.add(uf.find(m*n-n+i));
            }
        }
        for(int i=1; i<m-1; i++){
            if(board[i][0] == 'O'){
                s.add(uf.find(i*n));
            }
            if(board[i][n-1] == 'O'){
                s.add(uf.find(i*n+n-1));
            }
        }

        for(int i=1; i<m-1; i++){
            for(int j=1; j<n-1; j++){
                if(board[i][j] == 'O'){
                    if(!s.contains(uf.find(i*n+j))){
                        board[i][j] = 'X';
                    }
                }
            }
        }

        // System.out.println(s);
        // System.out.println(Arrays.toString(uf.uf));
    }
}

class UnionFind{
    int[] uf;

    UnionFind(int n){
        uf = new int[n];
        for(int i=0; i<n; i++){
            uf[i] = -1;
        }
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
            return;
        }

        if(uf[r1] < uf[r2]){
            uf[r1] += uf[r2];
            uf[r2] = r1;
        }else{
            uf[r2] += uf[r1];
            uf[r1] = r2;
        }
    }
}

// @lc code=end

/**
 * [["X","O","X","X"],
 *  ["O","X","O","X"],
 *  ["X","O","X","O"],
 *  ["O","X","O","X"]]

 */