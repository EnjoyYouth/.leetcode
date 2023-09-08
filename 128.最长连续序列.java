/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        UnionFind uf = new UnionFind(n);

        for(int i=0; i<n; i++){
            if(map.containsKey(nums[i])){
                continue;
            }

            if(map.containsKey(nums[i]-1)){
                uf.union(i, map.get(nums[i]-1));
            }

            if(map.containsKey(nums[i]+1)){
                uf.union(i, map.get(nums[i]+1));
            }

            map.put(nums[i], i);
        }

        int res = 0;
        for(int num : uf.uf){
            res = Math.max(res, -num);
        }

        return res;
    }
}

class UnionFind{
    int[] uf;

    public UnionFind(int n){
        uf = new int[n];
        for(int i=0; i<n; i++){
            uf[i] = -1;
        }
    }

    int find(int i){
        if(uf[i] < 0){
            return i;
        }

        return uf[i] = find(uf[i]);
    }

    void union(int a, int b){
        int r1 = find(a);
        int r2 = find(b);

        if(r1 == r2){
            return;
        }

        if(r1 < r2){
            uf[r1] += uf[r2];
            uf[r2] = r1;
        }else{
            uf[r2] += uf[r1];
            uf[r1] = r2;
        }
    }
}
// @lc code=end

