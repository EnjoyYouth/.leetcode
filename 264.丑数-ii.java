/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start

class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];

        int index2=0, index3=0, index5=0;
        int candidate2 = 2, candidate3=3, candidate5=5;
        res[0] = 1;
        
        for(int i=1; i<n; i++){
            int min = Math.min(candidate2, Math.min(candidate3, candidate5));

            res[i] = min;
            if(candidate2 == min){
                candidate2 = 2*res[++index2];
            }

            if(candidate3 == min){
                candidate3 = 3*res[++index3];
            }

            if(candidate5 == min){
                candidate5 = 5*res[++index5];
            }
        }

        return res[n-1];
    }
}
// @lc code=end

