/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode head = null;
        ListNode temp = head;
        int c = 0;
        int d = 0;
        while(head1!=null&&head2!=null) {
            d = head1.val+head2.val + c;
            c = d/10;
            if(head==null) {
                head = new ListNode(d%10);
                temp = head;
            } else {
                temp.next = new ListNode(d%10);
                temp = temp.next;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        while(head1!=null) {
            d = head1.val+c;
            temp.next = new ListNode(d%10);
            c = d/10;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2!=null) {
            d = head2.val+c;
            temp.next = new ListNode(d%10);
            c = d/10;
            head2 = head2.next;
            temp = temp.next;
        }
        if(c!=0) {
            temp.next = new ListNode(c);
        }
        // head = reverseLL(head);
        return head;
    }
}
// @lc code=end


