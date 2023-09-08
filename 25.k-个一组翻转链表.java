/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode();
        h.next = head;

        ListNode pre = h;
        while(true){
            ListNode t = pre;
            int count = 0;
            while(count<k+1 && t!=null){
                count++;
                t =t.next;
            }

            if(count != k+1) break;
            ListNode s = pre.next;
            ListNode c = s.next;
            for(int i=0; i<k-1; i++){
                s.next = c.next;
                c.next = pre.next;
                pre.next = c;
                c = s.next;
            }

            pre = s;
        }

        return h.next;
    }
}
// @lc code=end

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}