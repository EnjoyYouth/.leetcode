/*
 * @lc app=leetcode.cn id=2600 lang=java
 *
 * [2600] K 件物品的最大和
 */

// @lc code=start
class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k<=numOnes){
            return k;
        }

        if(k<=numOnes + numZeros){
            return numOnes;
        }

        return numOnes - (k-numOnes-numZeros);
    }
}
// @lc code=end

