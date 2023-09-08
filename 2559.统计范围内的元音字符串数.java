/*
 * @lc app=leetcode.cn id=2559 lang=java
 *
 * [2559] 统计范围内的元音字符串数
 * 
 * 经典的区间统计算法题
 */

// @lc code=start
class Solution {
    char[] yuan = {'a', 'e', 'i', 'o', 'u'};

    public int[] vowelStrings(String[] words, int[][] queries) {
        int num = words.length;
        int[] sum = new int[num+1];
        
        int[] res = new int[queries.length];

        int count = 0;
        for(int i=0; i<num; i++){
            String w = words[i];
            char b = w.charAt(0);
            char e = w.charAt(w.length()-1);
            if(contains(b) && contains(e)){
                count++;
            }
            sum[i+1] = count;
        }
        
        for(int i=0; i<queries.length; i++){
            res[i] = sum[queries[i][1]+1] - sum[queries[i][0]];
        }
        return res;
    }

    boolean contains(char ch){
        for(char c : yuan){
            if(ch == c){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

