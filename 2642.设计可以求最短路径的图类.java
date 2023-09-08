/*
 * @lc app=leetcode.cn id=2642 lang=java
 *
 * [2642] 设计可以求最短路径的图类
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Graph {
    
    int[][] grid;
    int BIG_VAL = Integer.MAX_VALUE/3;

    public Graph(int n, int[][] edges) {
        grid = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(grid[i], BIG_VAL);
            grid[i][i] = 0;
        }

        for(int[] e : edges){
            grid[e[0]][e[1]] = e[2];
        }

        // floyd
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] e) {
        int from = e[0], to = e[1], weight=e[2];
        if(weight>=grid[from][to]) return;

        int n = grid.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                grid[i][j] = Math.min(grid[i][j], grid[i][from] + weight + grid[to][j]);
            }
        }
    }
    
    
    public int shortestPath(int node1, int node2) {
        return grid[node1][node2] >= BIG_VAL ? -1 : grid[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
// @lc code=end

class MFGraph {
    int[][] grid;
    int v, e;

    public MFGraph(int n, int[][] edges) {
        grid = new int[n][n];
        v = n;
        e = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    grid[0][0] = 0;
                }else{
                    grid[i][j] = Integer.MAX_VALUE/2;
                }
            }
        }
        for(int[] edge : edges){
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        grid[edge[0]][edge[1]] = edge[2];
        e++;
    }
    
    
    public int shortestPath(int node1, int node2) {
        // floyd
        int[][] dp = new int[v][v];
        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                dp[i][j] = grid[i][j]; 
            }
        }
        // dp[k][i][j] = Math.min(dp[k-1][i][j] , dp[k-1][i][k] + dp[k-1][k][j])
        // 代码实现时为什么可以省去第一维？
        // Floyd算法为什么把k放在最外层？ - m00nlight的回答 - 知乎
        // https://www.zhihu.com/question/30955032/answer/68834307

        for(int k=0; k<v; k++){
            for(int i=0; i<v; i++){
                for(int j=0; j<v; j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        return dp[node1][node2] == Integer.MAX_VALUE/2 ? -1 : dp[node1][node2];
    }
}

class LHGraph {
    //  int[0] is to point, int[1] is weight
    List<int[]>[] grid ;
    // point number, edge number
    int v, e;

    public LHGraph(int n, int[][] edges) {
        v = n;
        grid = new List[v];
        for(int[] edge : edges){
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        e++;
        if(grid[edge[0]] == null){
            grid[edge[0]] = new ArrayList<>();
        }

        grid[edge[0]].add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        boolean[] connected = new boolean[v];
        Arrays.fill(connected, false);
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;

        Queue<int[]> que = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        que.offer(new int[]{node1, 0});

        while(!que.isEmpty()){
            if(connected[node2]){
                return dist[node2];
            }

            int node = que.poll()[0];
            if(connected[node]){
                continue;
            }

            connected[node] = true;
            for(int i=0; grid[node] != null && i<grid[node].size(); i++){
                int[] t = grid[node].get(i);
                if(!connected[t[0]] && t[1] + dist[node] < dist[t[0]]){
                    dist[t[0]] = t[1] + dist[node];
                    que.offer(new int[]{t[0], dist[t[0]]});
                }
            }
        }

        return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
    }
}

class MHGraph {
    int[][] grid;
    int v, e;

    public MHGraph(int n, int[][] edges) {
        grid = new int[n][n];
        v = n;
        e = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    grid[0][0] = 0;
                }else{
                    grid[i][j] = -1;
                }
            }
        }
        for(int[] edge : edges){
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        grid[edge[0]][edge[1]] = edge[2];
        e++;
    }
    
    public int shortestPath(int node1, int node2) {
        // dijkstra
        int[] dist = new int[v];
        boolean[] connected = new boolean[v];
        
        for(int i=0; i<dist.length; i++){
            connected[i] = false;
            dist[i] = Integer.MAX_VALUE;
        }
        dist[node1] = 0;
        Queue<int[]> que = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        que.offer(new int[]{node1, 0});

        while(!que.isEmpty()){
            if(connected[node2]){
                return dist[node2];
            }

            int node = que.poll()[0];
            if(connected[node]){
                continue;
            }
            connected[node] = true;

            for(int i=0; i<v; i++){
                if(!connected[i] && grid[node][i] != -1){
                    if(dist[node] + grid[node][i] < dist[i]){
                        dist[i] = dist[node] + grid[node][i];
                        que.offer(new int[]{i, dist[i]});
                    }
                }
            }
            // System.out.println(que);
        }

        return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
    }
}

class MGraph {
    int[][] grid;
    int v, e;

    public MGraph(int n, int[][] edges) {
        grid = new int[n][n];
        v = n;
        e = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    grid[0][0] = 0;
                }else{
                    grid[i][j] = -1;
                }
            }
        }
        for(int[] edge : edges){
            addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        grid[edge[0]][edge[1]] = edge[2];
        e++;
    }
    
    public int shortestPath(int node1, int node2) {
        // dijkstra
        int[] dist = new int[v];
        boolean[] connected = new boolean[v];
        
        for(int i=0; i<dist.length; i++){
            connected[i] = false;
            if(grid[node1][i] != -1){
                dist[i] = grid[node1][i];
            }else{
                dist[i] = Integer.MAX_VALUE;
            }
        }
        connected[node1] = true;

        while(true){
            if(connected[node2]){
                return dist[node2];
            }

            int node = -1;
            int dis = Integer.MAX_VALUE;
            for(int i=0; i<v; i++){
                if(connected[i]){
                    continue;
                }
                if(dist[i] < dis){
                    dis = dist[i];
                    node = i;
                }
            }

            if(node == -1){
                break;
            }
            connected[node] = true;

            for(int i=0; i<v; i++){
                if(!connected[i] && grid[node][i] != -1){
                    if(dist[node] + grid[node][i] < dist[i]){
                        dist[i] = dist[node] + grid[node][i];
                    }
                }
            }
        }

        return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
    }
}
