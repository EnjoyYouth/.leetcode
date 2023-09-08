/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode h = new ListNode();
       h.next = head;

       ListNode pre = h;
       for(int i=0; i<left-1; i++){
            pre = pre.next;
       }

       ListNode s = pre.next;
       ListNode c = s.next;
       for(int i=0; i<right-left; i++){
            s.next = c.next;
            c.next = pre.next;
            pre.next = c;
            c = s.next;
       }

       return h.next;
    }

    void out(ListNode n){

        String s = "[";
        while(n != null){
            s += n.val + ",";
            n = n.next;
        }

        System.out.println(s.substring(0, s.length()) + "]");
    }
}
// @lc code=end

/**
 * 
 * pre---s---cur---1---2
 * 
 * pre---s---1---2
 * cur---1---2
 * 
 * pre---cur---1---2
 * s---1---2
 * 
 * pre---cur---s---1---2
 * 
 * 
 */

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}