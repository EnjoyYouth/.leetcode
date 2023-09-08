/*
 * @lc app=leetcode.cn id=393 lang=java
 *
 * [393] UTF-8 编码验证
 */

// @lc code=start
class Solution {

    int MAX = 0xff;
    int MIN = 0x00;
    int _1CH = 0x00;
    int _2CH = 0xc0;
    int _3CH = 0xe0;
    int _4CH = 0xf0;
    int _10 = 0x80;
    int[][] nums = {
            { 0x80, 0xe0, 0xf0, 0xf8 },
            { _1CH, _2CH, _3CH, _4CH }
    };

    public boolean validUtf8(int[] data) {

        for (int i = 0; i < data.length;) {
            int num = -1;
            for (int n = nums[0].length - 1; n >= 0; n--) {
                if ((data[i] & nums[0][n]) == nums[1][n]) {
                    num = n + 1;
                    break;
                }
            }
            // 代表初始位置就不合法
            if (num == -1) {
                return false;
            }

            // System.out.println(num);
            for (int j = i + 1; j < i + num; j++) {
                if (j >= data.length || (_10 & data[j]) != _10) {
                    return false;
                }
            }
            i += num;
        }

        return true;
    }
}
// @lc code=end
