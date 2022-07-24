/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        ListNode prev1 = null;
        ListNode curr = head;
        ListNode prev2 = null;
        ListNode temp = head;
        while(temp!=null&&curr!=null) {
            // temp = prev2.next;
            while(curr!=null&&curr.val<x) {
                prev1 = curr;
                curr = curr.next;
            }
            if(curr==null) break;
            temp = curr.next;
            prev2 = curr;
            while(temp!=null&&temp.val>=x) {
                prev2 = temp;
                temp = temp.next;
            }
            if(temp==null) break;
            node2BeforeNode1(curr, temp, prev1, prev2);
            prev1 = prev1.next;

        }
        return head;
    }
    public void node2BeforeNode1(ListNode node1, ListNode node2, ListNode prev1, ListNode prev2) {
        if(prev1==null) {
            prev2.next = node2.next;   
            node2.next = prev2;
            prev1 = prev2;

            return;
        } 
        prev2.next = node2.next;
        node2.next = node1;
        prev1.next = node2;
        prev1 = prev1.next;


    }
    
}
// @lc code=end

