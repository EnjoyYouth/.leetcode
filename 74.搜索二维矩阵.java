/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int min = 0, max = row*col-1;

        while(min != max && min+1 != max){
            int mid = (min+max)/2;
            int c = mid%col;
            int r = mid/col;

            // System.out.println(String.format("%s, %s", r, c));
            if(matrix[r][c] == target) return true;
            else if(matrix[r][c] > target) max = mid;
            else min = mid;
        }
        
        return matrix[max/col][max%col] == target || matrix[min/col][min%col] == target;
    }
}
// @lc code=end

