/*
 * @lc app=leetcode.cn id=2594 lang=java
 *
 * [2594] 修车的最少时间
 */

// @lc code=start
class Solution {

    public long repairCars(int[] ranks, int cars) {
        long max = 100000000000000L;
        long min = 0;

        while(max != min+1 && max != min){
            // System.out.println(String.format("%s, %s", min, max));
            long mid = (max + min)/2;
            long count = 0L;
            for(int i=0; i<ranks.length; i++){
                count += (long)Math.sqrt(mid/ranks[i]);
            }
            if(count>=cars) max = mid;
            else min = mid;
        }

        // System.out.println(max);
        while(true){
            long count = 0;
            for(int i=0; i<ranks.length; i++){
                count += (long)Math.sqrt(max/ranks[i]);
            }
            // System.out.println(count);
            if(count < cars) break;
            max --;
        }

        return max+1;
    }
}
// @lc code=end

