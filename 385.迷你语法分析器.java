/*
 * @lc app=leetcode.cn id=385 lang=java
 *
 * [385] 迷你语法分析器
 */

// @lc code=start
/* *
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

import java.util.ArrayDeque;
import java.util.Deque;
// import predefined.*;

class Solution {
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> que = new ArrayDeque<>();
        que.addLast(new NestedInteger());

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ','){
                continue;
            }else if(ch == '['){
                NestedInteger par = que.getLast();
                NestedInteger n = new NestedInteger();

                par.add(n);
                que.offerLast(n);
            }else if(ch == ']'){
                que.pollLast();
            }else{
                StringBuilder sb = new StringBuilder();
                int j=i;
                while( j<s.length() && (s.charAt(j)=='-' || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))){
                    sb.append(s.charAt(j));
                    j++;
                }

                NestedInteger n = new NestedInteger(Integer.valueOf(sb.toString()));
                que.peekLast().add(n);
                i = j-1;
            }
        }

        return que.peekLast().getList().get(0);
    }
}
// @lc code=end

