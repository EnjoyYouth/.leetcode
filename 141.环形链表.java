/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        while(f != null && f.next != null){
            f= f.next.next;
            s = s.next;

            if(f== s){
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

