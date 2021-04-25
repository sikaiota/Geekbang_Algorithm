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
    // 改进1：设置hair和end节点使逻辑更清晰
    // 改进2：不检查最后不足k个节点，发现小于k个时回滚操作，减少时间复杂度的常数
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode partTail = head, partHead = null, moveNext = head;
        // 快指针，找出最终的head并检查接下来是否还够k个节点
        ListNode kAhead = head;
        for (int i = 1; i < k; ++i) {
            kAhead = kAhead.next;
        }
        head = kAhead;
        // 依次局部翻转链表
        boolean cont = true;
        while (cont) {
            // 检查接下来是否还够k个节点
            for (int i = 0; i < k; ++i) {
                if ((kAhead = kAhead.next) == null) {
                    cont = false;
                    break;
                }
            }
            // 局部翻转链表，参见206.反转链表
            for (int i = 0; i < k; ++i) {
                ListNode temp = partHead;
                partHead = moveNext;
                moveNext = moveNext.next;
                partHead.next = temp;
            }
            partHead = null;
            partTail.next = cont ? kAhead : moveNext;
            partTail = moveNext;
        }
        return head;
    }
}
// @lc code=end

