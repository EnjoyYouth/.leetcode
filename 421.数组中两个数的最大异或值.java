/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    static int N = 5000000;
    static int[][] trie = new int[N][2];
    static int[] count = new int[N];
    static int index = 0;

    public Solution(){
        for(int i=0; i<=index; i++){
            Arrays.fill(trie[i], 0);
        }

        index = 0;
        Arrays.fill(count, 0);
    }

    void insert(int num){
        int loc = 0;
        for(int i=31; i>=0; i--){
            int a = (num >> i) & 1;
            if(trie[loc][a] == 0) trie[loc][a] = ++index;
            loc = trie[loc][a];
        }

        count[loc]++;
    }

    int getVal(int num){
        int loc = 0;
        int val = 0;

        for(int i=31; i>=0; i--){
            int a = (num >> i) & 1;
            int b = 1-a;
            if(trie[loc][b] != 0){
                val |= (b << i);
                loc = trie[loc][b];
            }else{
                val |= (a << i);
                loc = trie[loc][a];
            }
        }

        return val;
    }

    public int findMaximumXOR(int[] nums) {
        int res = 0;

        for(int num : nums){
            insert(num);
            int val = getVal(num);
            res = Math.max(res, num ^ val);
        }

        return res;
    }
}

// @lc code=end

