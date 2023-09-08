/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        return bfs(node);
    }

    Node dfs(Node node){
        Node clone = new Node(node.val);
        visited.put(node, clone);
        List<Node> neighbors = new ArrayList<>();
        for(Node n : node.neighbors){
            if(visited.getOrDefault(n, null) == null){
                neighbors.add(dfs(n));
            }else{
                neighbors.add(visited.get(n));
            }
        }
        clone.neighbors = neighbors;

        return clone;
    }

    Node bfs(Node node){
        Node clone = new Node(node.val);
        visited.put(node, clone);

        Deque<Node> que = new ArrayDeque<>();
        que.offerLast(node);

        while(!que.isEmpty()){
            Node top = que.pollFirst();

            List<Node> neighbors = new ArrayList<>();
            for(Node n : top.neighbors){
                if(visited.get(n) == null){
                    que.offerLast(n);
                    visited.put(n, new Node(n.val));
                }

                neighbors.add(visited.get(n));
            }

            visited.get(top).neighbors = neighbors;
        }

        return clone;
    }
}
// @lc code=end

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}