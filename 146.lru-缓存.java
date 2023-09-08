/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer,Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

class LRUCache0 {

    Map<Integer, Node> map;
    int capacity;
    Node head, tail;

    public LRUCache0(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.r = tail;
        tail.l = head;
    }

    public int get(int key) {
        // out();
        if(map.containsKey(key)){
            Node node = map.get(key);
            // System.out.println(node);
            remove(node);
            ahead(node);
            return node.v;
        }

        return -1;
    }

    void out(){
        StringBuilder sb = new StringBuilder("{");
        Node t = head;
        
        while(t != null){
            sb.append(t).append("-->");
            t = t.r;
        }

        System.out.println(sb.toString().substring(0, sb.length()-3) + "}");
    }

    // 从双向链表中移除
    Node remove(Node node){
        if(node == null || node == head || node == tail){
            throw new IllegalAccessError();
        }

        node.r.l = node.l;
        node.l.r = node.r;

        node.r = null;
        node.l = null;

        return node;
    }

    // 将节点放到双向链表最前端
    void ahead(Node node){
        node.r = head.r;
        node.l = head;

        head.r.l = node;
        head.r = node;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.v = value;
            remove(node);
            ahead(node);
        }else{
            if(map.size()>=capacity){
                Node re = remove(tail.l);
                map.remove(re.k);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            ahead(node);
        }
    }

    class Node{
        int k, v;
        Node l, r;

        public Node(int k, int v){
            this.k = k;
            this.v = v;
        }

        public String toString(){
            return "[" + k + "," + v + "]";
        }
    }
}