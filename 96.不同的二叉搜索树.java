/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] dp =new int[n+1];
        dp[0] = 1; dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            dp[i] = 0;
            int mid = i/2;
            for(int j=1; j<=mid; j++){
                int tmp = dp[j-1]*dp[i-j];
                dp[i] += tmp;
            }
            dp[i] *=2;
            if(i%2 == 1) dp[i] += dp[mid]*dp[mid];
        }

        return dp[n];
    }
}
// @lc code=end

/**
 * 
 * 一种思路
 * r(i)代表以i为根节点的二叉搜索树的数量
 * f(j,k)代表[i,j]所组成的二叉搜索树的数量
 * 
 * f(j,k) = f(j,i-1)*f(i+1,k)  i=j,j+1,....,k
 * 但是f(j,k)其实仅仅跟k-j+1相关，仅跟长度相关，所以最终的推导公式为:
 * d(n)代表长度，初始值：d(0)=1, d(1) = 1
 * 
 * d(n) = d(0)*d(n-1) + d(1)*d(n-2) + .... + d(n/2-1)*d(n/2) + d(n/2)*d(n/2-1) + ...... + d(n-1)*d(0)
 * 
 */