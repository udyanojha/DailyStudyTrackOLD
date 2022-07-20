import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;

        return mergeKLists(lists, 0, lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if(si==ei) return lists[si];
        int mid = si+(ei-si)/2;
        ListNode l1 = mergeKLists(lists, si, mid);
        ListNode l2 =mergeKLists(lists, mid+1, ei);
        return mergeTwoLists(l1,l2);
    }


    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists.length==0) return null;
    //     ListNode head = null;
    //     for(int i = 0; i<lists.length; i++) {
    //         ListNode temp = lists[i];
    //         head = mergeTwoLists(head, temp);
    //     }
    //     return head;
    // }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null||list2==null) {
        return (list1==null? list2:list1);
        }
        ListNode c1 = list1, c2 = list2, dummy = new ListNode(-1), prev = dummy;
        while(c1!=null&&c2!=null) {
            if(c1.val<c2.val) {
                prev.next = c1;
                c1= c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }
        prev.next = (c1==null?c2:c1);
        ListNode head = dummy.next;
        dummy = null;
        return head;
    }
}
// @lc code=end

