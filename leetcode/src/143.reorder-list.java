/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode mid = middleNode(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverseList(head2);
        ListNode c1 = head, c2 = head2;

        while(c2 != null) {
            ListNode f1 = c1.next, f2= c2.next;
            c1.next = c2; // linkup
            c2.next = f1;

            c1 = f1;
            c2 = f2;
         }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = curr;

        while(curr!=null) {
            curr = curr.next;
            temp.next = prev;
            prev = temp;
            temp = curr;
        }

        return prev;
    }
    public ListNode middleNode(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
// @lc code=end

