/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        ListNode newhead = head;
        if (head != null && head.next != null) {
            newhead = head.next;
            head.next = newhead.next;
            newhead.next = head;
            ListNode curr = head.next;
            ListNode prev = head;
            while (curr != null && curr.next != null) {
                prev.next = curr.next;
                curr.next = prev.next.next;
                prev.next.next = curr;
                prev = curr;
                curr = curr.next;
            }
        }
        return newhead;
    }
}
// @lc code=end

