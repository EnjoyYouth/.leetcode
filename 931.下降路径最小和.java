/*
 * @lc app=leetcode.cn id=931 lang=java
 *
 * [931] 下降路径最小和
 */

// @lc code=start
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // dp[i][j] = min{dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1]} + m[i][j]
        // res = min{dp[n][0]...dp[n][n]}
        // 初始值：dp[0][j] = m[0][j]

        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                int pre = dp[i-1][j];
                if(j-1>=0){
                    pre = Math.min(pre, dp[i-1][j-1]);
                }
                if(j+1<n){
                    pre = Math.min(pre, dp[i-1][j+1]);
                }

                dp[i][j] = pre + matrix[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            res = Math.min(res, dp[n-1][i]);
        }

        return res;
    }
}
// @lc code=end

