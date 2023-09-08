/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */

// @lc code=start

class Solution {
    public boolean isNumber(String s) {
        // ^[\+\-]?((\d\d*(\.\d*)?)|(\.\d\d*))([E|e][\+\-]?\d\d*)?$
        // 正则——>nfa——>dfa
        // TODO dfa最小化
        int res = 0b110011000;
        int[][] dnf = {
            {1, 2, 4, -1},
            {-1, 2, 4, -1},
            {-1, -1, 3, -1},
            {-1, -1, 3, 5},
            {-1, 7, 4, 5},
            {6, -1, 8, -1},
            {-1, -1, 8, -1},
            {-1, -1, 7, 5},
            {-1, -1, 8, -1}
        };

        int state = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int j = index(ch);
            if(j==-1) return false;
            int next = dnf[state][j];
            if(next==-1) return false;
            state = next;
        }

        return ((1<<state)&res) != 0;
    }

    int index(char ch){
        switch(ch){
            case '+': return 0;
            case '-': return 0;
            case '.': return 1;
            case 'e': return 3;
            case 'E': return 3;
            default:
                if(ch>='0' && ch<='9') return 2;
        }

        return -1;
    }
}
// @lc code=end

