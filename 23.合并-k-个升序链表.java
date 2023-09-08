/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 */

// @lc code=start

import java.util.Arrays;

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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = 500010;
        Heap h = new Heap(n);

        ListNode res = new ListNode();
        ListNode tmp = res;
        for(ListNode list : lists){
            while(list != null){
                ListNode l = list;
                h.offer(l);
                list = list.next;
                // 断开链表，防止环形链表的出现
                l.next = null;
            }
        }

        while(!h.isEmpty()){
            tmp.next = h.poll();
            tmp = tmp.next;
        }

        return res.next;
    }

    /**
     * 分治
     */
    ListNode mergeKLists(ListNode[] lists, int begin, int end) {
        if(begin > end){
            return null;
        }

        if(begin == end){
            return lists[begin];
        }

        int mid = (begin + end)/2;

        ListNode l = mergeKLists(lists, begin, mid);
        ListNode r = mergeKLists(lists, mid+1, end);

        ListNode res = new ListNode();
        ListNode ret = res;
        while(l != null || r != null){
            if(l == null){
                res.next = r;
                r = r.next;
            }else if(r == null){
                res.next = l;
                l = l.next;
            }else if(l.val > r.val){
                res.next = r;
                r = r.next;
            }else{
                res.next = l;
                l = l.next;
            }

            res = res.next;
        }

        return ret.next;
    }
}

class Heap{
    ListNode[] h;
    int size;

    public Heap(int n){
        h = new ListNode[n+1];
        h[0] = new ListNode(Integer.MIN_VALUE);
        size = 0;
    }

    public Boolean isEmpty(){
        return size<=0;
    }

    public ListNode peek(){
        if(isEmpty()){
            throw new IllegalAccessError();
        }
        return h[1];
    }

    public void offer(ListNode val){
        if(size >= h.length-1){
            throw new IllegalAccessError();
        }

        int loc = ++size;
        for(; h[loc/2].val > val.val; loc /= 2){
            h[loc] = h[loc/2];
        }

        h[loc] = val;
    }

    public ListNode poll(){
        if(isEmpty()){
            throw new IllegalAccessError();
        }

        ListNode res = h[1];
        ListNode tmp = h[size--];
        int loc = 1;
        int child = 0;
        for(; loc*2 <= size; loc = child){
            child = loc*2;
            if(child < size && h[child].val > h[child+1].val){
                child++;
            }

            if(h[child].val >= tmp.val){
                break;
            }else{
                h[loc] = h[child];
            }
        }

        h[loc] = tmp;
        return res;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i=1; i<=size; i++){
            sb.append(h[i].val).append(",");
        }
        sb.append("]");
        return sb.toString();
    }

}

// @lc code=end

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    public String toString(){
        return String.valueOf(val);
    }
}