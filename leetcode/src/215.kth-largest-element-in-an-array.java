import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for(; i<k; i++) {
            pq.add(nums[i]);
        }
        for(; i<nums.length; i++) {
            if(nums[i]>pq.peek()) {
                pq.remove();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
// @lc code=end

