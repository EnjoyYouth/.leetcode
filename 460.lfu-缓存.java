/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU 缓存
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    Map<Integer, Bucket> map;
    int capacity;
    int count;
    Bucket head, tail;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        count = 0;
        head = new Bucket(-1);
        tail = new Bucket(-1);

        head.r = tail;
        tail.l = head;
    }

    
    public int get(int key) {
        if(map.containsKey(key)){
            Bucket bucket = map.get(key);
            Bucket.Node n = bucket.remove(key);
            Bucket nb = bucket.r.weight == bucket.weight+1 ? bucket.r : createBucket(bucket);
            nb.ahead(n);
            map.put(key, nb);
            clearBucket(bucket);
            return n.v;
        }
        return -1;
    }

    Bucket createBucket(Bucket l){
        return createBucket(l, l.weight+1);
    }

    Bucket createBucket(Bucket l, int weight){
        Bucket n = new Bucket(weight);
        n.r = l.r;
        l.r.l = n;

        n.l = l;
        l.r = n;

        return n;
    }

    void clearBucket(Bucket bucket){
        if(bucket.isEmpty()){
            bucket.l.r = bucket.r;
            bucket.r.l = bucket.l;

            bucket.l = null;
            bucket.r = null;
        }
    }

    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Bucket bucket = map.get(key);
            Bucket.Node n = bucket.remove(key);
            n.v = value;

            Bucket nb = bucket.r.weight == bucket.weight+1 ? bucket.r : createBucket(bucket);
            nb.ahead(n);
            map.put(key, nb);
            clearBucket(bucket);
        }else{
            if(count>=capacity){
                Bucket bucket = head.r;
                Bucket.Node n = bucket.tail.l;
                bucket.remove(n);
                map.remove(n.k);
                clearBucket(bucket);

                count--;
            }

            Bucket bucket = head.r.weight == 1 ? head.r : createBucket(head, 1);
            bucket.ahead(key, value);
            map.put(key, bucket);
            count++;
        }
    }

    class Bucket{
        Map<Integer, Node> map;
        Node head, tail;
        int weight;
        Bucket l, r;

        public Bucket(int weight){
            this.weight = weight;
            map = new HashMap<>();
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            
            head.r = tail;
            tail.l = head;
        }

        Node remove(int key){
            Node n = map.get(key);
            return remove(n);
        }

        Node remove(Node n){
            n.l.r = n.r;
            n.r.l = n.l;

            n.l = null;
            n.r = null;

            map.remove(n.k);
            return n;
        }

        void ahead(Node n){
            n.r = head.r;
            head.r.l = n;

            n.l = head;
            head.r = n;

            map.put(n.k, n);
        }

        void ahead(int k, int v){
            Node n = new Node(k, v);
            ahead(n);
        }

        boolean isEmpty(){
            return map.isEmpty();
        }

        class Node{
            int k, v;
            Node l, r;

            public Node(int k, int v){
                this.k = k;
                this.v = v;
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

class LFUCache0 {

    Map<Integer, Bucket> map;
    Bucket head, tail;
    int capacity;
    int count;

    public LFUCache0(int capacity) {
        map = new HashMap<>();
        head = new Bucket(-1);
        tail = new Bucket(-1);
        head.r = tail;
        tail.l = head;

        this.capacity = capacity;
        count = 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Bucket t = head;
        while(t != null){
            sb.append(t).append("==>");
            t = t.r;
        }

        return sb.toString().substring(0, sb.length()-3) + "}";
    }
    
    public int get(int key) {
        // System.out.println(this);
        if(map.containsKey(key)){
            Bucket bucket = map.get(key);
            Bucket newBucket = bucket.r.num == bucket.num+1 ? bucket.r : createBucket(bucket, bucket.num+1);
            Node node = remove(bucket, key);

            newBucket.put(node);
            map.put(key, newBucket);

            return node.v;
        }

        return -1;
    }

    Bucket createBucket(Bucket bucket, int num){
        Bucket newBucket = new Bucket(num);

        newBucket.l = bucket;
        newBucket.r = bucket.r;

        bucket.r.l = newBucket;
        bucket.r = newBucket;

        return newBucket;
    }

    Node remove(Bucket bucket, int key){
        map.remove(key);
        Node node = bucket.remove(key);
        if(bucket.isEmpty()){
            bucket.l.r = bucket.r;
            bucket.r.l = bucket.l;

            bucket.l = null;
            bucket.r = null;
        }

        return node;
    }
    
    public void put(int key, int value) {
        // System.out.println(this);
        if(map.containsKey(key)){
            Bucket bucket = map.get(key);
            Bucket newBucket = bucket.r.num == bucket.num+1 ? bucket.r : createBucket(bucket, bucket.num+1);
            Node node = remove(bucket, key);

            node.v = value;
            newBucket.put(node);
            map.put(key, newBucket);
        }else{
            if(count >= capacity){
                Bucket bucket = head.r;
                remove(bucket, bucket.peekLast().k);
                count--;
            }

            Bucket newBucket = head.r.num == 1 ? head.r : createBucket(head, 1);
            newBucket.put(new Node(key, value));
            map.put(key, newBucket);
            count++;
        }
    }

    class Bucket{
        int num;
        Node head, tail;
        Map<Integer, Node> map;
        Bucket l, r;

        public Bucket(int num){
            this.num = num;
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.r = tail;
            tail.l = head;

            map = new HashMap<>();
        }

        Node removeLast(){
            return remove(tail.l);
        }

        Node peekLast(){
            return tail.l;
        }

        Node remove(Node node){
            if(node == null || node == head || node == tail){
                throw new IllegalAccessError();
            }

            node.l.r = node.r;
            node.r.l = node.l;
            node.l = null;
            node.r = null;

            map.remove(node.k);
            return node;
        }

        Node remove(int key){
            if(!map.containsKey(key)){
                throw new IllegalAccessError();
            }

            Node node = map.get(key);
            return remove(node);
        }

        void put(Node node){
            node.l = head;
            node.r = head.r;

            head.r.l = node;
            head.r = node;

            map.put(node.k, node);
        }

        boolean isEmpty(){
            return map.isEmpty();
        }

        public String toString(){
            StringBuilder sb = new StringBuilder("{");
            Node t = head;
            
            while(t != null){
                sb.append(t).append("-->");
                t = t.r;
            }

            return sb.toString().substring(0, sb.length()-3) + "}";
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