/*
 * @lc app=leetcode.cn id=1584 lang=java
 *
 * [1584] 连接所有点的最小费用
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;


class Solution {
    public int minCostConnectPoints(int[][] points) {
        // prim
        int n = points.length;
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] isConnected = new boolean[n];
        Arrays.fill(isConnected, false);
        Queue<int[]> que = new PriorityQueue<>((a, b) -> a[1]-b[1]);

        dist[0] = 0;
        que.offer(new int[]{0, 0});
        int count = 0;
        while(count<n-1 && !que.isEmpty()){
            int node = que.poll()[0];
            if(isConnected[node]) continue;
            isConnected[node] = true;
            count++;

            for(int i=0; i<n; i++){
                if(!isConnected[i] && grid[node][i] < dist[i]){
                    dist[i] = grid[node][i];
                    que.offer(new int[]{i, dist[i]});
                }
            }
        }

        return count==n-1 ? Arrays.stream(dist).sum() : -1;
    }
}

class UnionFind{
    int[] uf;

    public UnionFind(int n){
        uf = new int[n];
        Arrays.fill(uf, -1);
    }

    int find(int x){
        if(uf[x] < 0) return x;
        return uf[x] = find(uf[x]);
    }

    boolean isConnected(int a, int b){
        return find(a) == find(b);
    }

    void unoin(int a, int b){
        int r1 = find(a);
        int r2 = find(b);

        if(r1 == r2) return;

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

class Prim {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] grid = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
            }
        }

        boolean[] isConnected = new boolean[n];
        Arrays.fill(isConnected, false);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        isConnected[0] = true;
        int cur = 0;
        for(int i=0; i<n; i++){
            dist[i] = grid[cur][i];
        }

        while(true){
            int next = -1;
            int d = Integer.MAX_VALUE;
            for(int i=0; i<n; i++){
                if(!isConnected[i] && dist[i] < d){
                    next = i;
                    d = dist[i];
                }
            }

            if(next == -1){
                break;
            }

            isConnected[next] = true;

            for(int i=0; i<n; i++){
                if(!isConnected[i] && grid[next][i] < dist[i]){
                    dist[i] = grid[next][i];
                }
            }
        }

        for(boolean b : isConnected){
            if(!b){
                return -1;
            }
        }

        return Arrays.stream(dist).sum();
    }
}