/*
 * @lc app=leetcode.cn id=295 lang=java
 *
 * [295] 数据流的中位数
 */

// @lc code=start

class MedianFinder {

    private Heap small = new LHeap(50010);
    private Heap large = new SHeap(50010);
    Boolean even = true;

    public MedianFinder() {

    }
    
    public void addNum(int num) {
        if(even){
            large.offer(num);
            small.offer(large.poll());
        }else{
            small.offer(num);
            large.offer(small.poll());
        }

        even = !even;

    }
    
    public double findMedian() {
        if(even){
            return (small.peek()+large.peek()) / 2.0;
        }else{
            return small.peek();
        }
    }
}

interface Heap{
    boolean isEmpty();
    int peek();
    void offer(int val);
    int poll();
}

class LHeap implements Heap{
    int[] h;
    int size;

    public LHeap(int n){
        h = new int[n+1];
        size = 0;
        h[0] = Integer.MAX_VALUE;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int peek(){
        return h[1];
    }

    public void offer(int val){
        int loc = ++size;

        for(; h[loc/2] < val; loc /= 2){
            h[loc] = h[loc/2];
        }

        h[loc] = val;
    }

    public int poll(){
        int tmp = h[1];

        int val = h[size--];
        int loc = 1;
        int child = 0;

        for(; loc*2<=size; loc = child){
            child = loc*2;
            if(child<size && h[child] < h[child+1]){
                child++;
            }

            if(val > h[child]){
                break;
            }else{
                h[loc] = h[child];
            }
        }

        h[loc] = val;

        return tmp;
    }
}

class SHeap implements Heap{
    int[] h;
    int size;

    public SHeap(int n){
        h = new int[n+1];
        size = 0;
        h[0] = Integer.MIN_VALUE;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int peek(){
        return h[1];
    }

    public void offer(int val){
        int loc = ++size;

        for(; h[loc/2] > val; loc /= 2){
            h[loc] = h[loc/2];
        }

        h[loc] = val;
    }

    public int poll(){
        int tmp = h[1];

        int val = h[size--];
        int loc = 1;
        int child = 0;

        for(; loc*2<=size; loc = child){
            child = loc*2;
            if(child<size && h[child] > h[child+1]){
                child++;
            }

            if(val < h[child]){
                break;
            }else{
                h[loc] = h[child];
            }
        }

        h[loc] = val;

        return tmp;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

