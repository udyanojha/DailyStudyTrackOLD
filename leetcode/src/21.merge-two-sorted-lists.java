/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head = null;
        ListNode temp = head;
        while(list1!=null&&list2!=null) {
            
            if(head==null) {
                if(list1.val>list2.val) {
                    head = list2;
                    list2 = list2.next;
                    temp = head;
                } else {
                    head = list1;
                    temp = head;
                    list1 = list1.next;
                }
            } else {
                if(list1.val>list2.val) {
                    temp.next = list2;
                    list2 = list2.next;
                } else {
                    temp.next = list1;
                    list1 = list1.next;
                }
                temp = temp.next;
            }
        }
        if(list1!=null) {
            temp.next = list1;
        }
        if(list2!=null) {
            temp.next = list2;
        }
        return head;
    }
}
// @lc code=end

