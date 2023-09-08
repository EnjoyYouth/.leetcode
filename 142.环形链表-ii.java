/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
            if(s == f){
                f = head;
                while(s != f){
                    s = s.next;
                    f = f.next;
                }

                return f;
            }
        }

        return null;
    }
}
// @lc code=end

/**
 * x+y
 * f=2s
 * f-s=ny=s
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}