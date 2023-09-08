/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[][] dp = new int[n][2];

        int res_i = 0, res_j = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            dp[i][0] = longestPalindrome(chs, i, i);
            if (dp[i][0] > res) {
                res_i = i;
                res_j = i;
                res = dp[i][0];
            }
            if (i + 1 < n) {
                dp[i][1] = longestPalindrome(chs, i, i + 1);
                if (dp[i][1] > res) {
                    res_i = i;
                    res_j = i + 1;
                    res = dp[i][1];
                }
            }
        }

        int step = res%2 == 0 ? res/2-1 : res/2;
        // System.out.println(String.format("%s, %s, %s", res, res_i, res_j));
        return s.substring(res_i - step, res_j + step + 1);
    }

    int longestPalindrome(char[] chs, int l, int r) {
        int res = 0;

        for (int i = l, j = r; i >= 0 && j < chs.length; i--, j++) {
            if (chs[i] == chs[j]) {
                res += 1;
            } else {
                break;
            }
        }

        return res * 2 + (l == r ? -1 : 0);
    }
}
// @lc code=end
