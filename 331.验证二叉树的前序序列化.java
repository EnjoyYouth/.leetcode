/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] tree = preorder.split(",");
        Deque<String> que = new ArrayDeque<>();
        String NULL = "#";

        int index = 0;
        while(index < tree.length && (!tree[index].equals(NULL) || !que.isEmpty())){
            while(index < tree.length && !tree[index].equals(NULL)){
                que.offerLast(tree[index]);
                index++;
            }

            if(!que.isEmpty()){
                que.pollLast();
                index++;
            }
        }

        return index == tree.length-1 && tree[index].equals(NULL);
    }
}
// @lc code=end

/**
 * out == in
 */