/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findKthLargest(int[] nums, int k) {

        Heap h = new Heap(k);
        for(int i=0; i<k; i++){
            h.offer(nums[i]);
        }

        for(int i=k; i<nums.length; i++){
            if(nums[i] > h.peek()){
                h.poll();
                h.offer(nums[i]);
            }
        }

        return h.peek();
    }

    class Heap{
        int[] h;
        int size;

        public Heap(int n){
            h = new int[n+1];
            h[0] = Integer.MIN_VALUE;
            size = 0;
        }

        public void offer(int x){
            if(h.length <= size) throw new IllegalAccessError();
            int loc = ++size;

            for(; h[loc/2] > x; loc /=2){
                h[loc] = h[loc/2];
            }

            h[loc] = x;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public int peek(){
            if(isEmpty()) throw new IllegalAccessError();
            return h[1];
        }

        public int poll(){
            if(isEmpty()) throw new IllegalAccessError();
            int tmp = h[1];
            int x = h[size--];
            int loc = 1;

            for(; loc*2 <= size;){
                int child = loc*2;
                if(child < size && h[child] > h[child+1]){
                    child++;
                }

                if(h[child] < x){
                    h[loc] = h[child];
                    loc = child;
                }else{
                    break;
                }
            }

            h[loc] = x;

            return tmp;
        }
    }
}

// @lc code=end

/**
 * 小顶堆
 */
class Heap {
    int[] h;
    int size;

    public Heap(int size) {
        this.h = new int[size + 1];
        h[0] = Integer.MIN_VALUE;
    }

    public Heap(int[] nums) {
        // TODO O(n)时间复杂度创建堆
    }

    void offer(int num) {
        if (size >= h.length - 1) {
            throw new IllegalStateException();
        }
        int loc = ++size;
        for (; h[loc / 2] > num; loc /= 2) {
            h[loc] = h[loc / 2];
        }

        h[loc] = num;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return h[1];
    }

    int poll() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int tmp = h[1];
        int last = h[size--];

        int loc, child;
        for (loc = 1; loc * 2 <= size; loc = child) {
            child = loc * 2;
            if (child < size && h[child] > h[child + 1]) {
                child++;
            }

            if (h[child] > last) {
                break;
            } else {
                h[loc] = h[child];
            }
        }

        h[loc] = last;
        return tmp;
    }

    public String toString() {
        return Arrays.toString(h);
    }
}