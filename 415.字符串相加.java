/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i=n1.length-1, j=n2.length-1;
        int pre = 0;
        for(; i>=0 || j>=0 || pre>0; i--, j--){
            int a = i>=0 ? n1[i] - '0' : 0;
            int b = j>=0 ? n2[j] - '0' : 0;

            int t = a+b + pre;
            if(t >= 10){
                pre = t/10;
                t = t%10;
            }else{
                pre = 0;
            }

            sb.append(t);
        }

        return sb.reverse().toString();
    }
}
// @lc code=end

