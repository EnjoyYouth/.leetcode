/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {
    int[] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        this.nums = nums;
        Heap h = new Heap(n);

        for(int i=0; i<n; i++){
            h.offer(i);
            if(h.size() < k){
                continue;
            }

            while(true){
                if(h.peek() <=i && h.peek() > i-k){
                    res[i-k+1] = nums[h.peek()];
                    break;
                }

                h.poll();
            }
        }

        return res;
    }

    class Heap{
        int[] h;
        int size;
    
        public Heap(int n){
            h = new int[n+1];
            size = 0;
            h[0] = Integer.MAX_VALUE;
        }
    
        public boolean isEmpty(){
            return size == 0;
        }

        public int size(){
            return size;
        }
    
        public int peek(){
            return h[1];
        }
    
        public void offer(int val){
            if(size == h.length-1){
                throw new IllegalAccessError();
            }
    
            int loc = ++size;
            for(; loc > 1 && nums[h[loc/2]] < nums[val]; loc /= 2){
                h[loc] = h[loc/2];
            }
    
            h[loc] = val;
        }
    
        public int poll(){
            if(isEmpty()){
                throw new IllegalAccessError();
            }
    
            int res = h[1];
            int tmp = h[size--];
            int loc = 1;
            int child = 0;
            for(; loc*2 <= size; loc = child){
                child = loc*2;
                if(child<size && nums[h[child+1]] > nums[h[child]]){
                    child++;
                }
    
                if(nums[h[child]] > nums[tmp]){
                    h[loc] = h[child];
                }else{
                    break;
                }
            }
    
            h[loc] = tmp;
    
            return res;
        }
    }
}
// @lc code=end

