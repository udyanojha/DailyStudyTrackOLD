/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        // if(root==null) return new ArrayList<>();
        Queue<TreeNode> pendingQueue = new LinkedList<>();
        pendingQueue.add(root);
        pendingQueue.add(null);
        double total = 0;
        int count = 0;
        List<Double> ans = new ArrayList<>();
        while(pendingQueue.size()!=1) {
            if(pendingQueue.peek()==null) {
                ans.add(total/count);
                total = 0;
                count = 0;
                pendingQueue.remove();
                pendingQueue.add(null);
            }
            TreeNode curr = pendingQueue.poll();
            count++;
            total +=curr.val;
            
            if(curr.left!=null) {
                pendingQueue.add(curr.left);
            }
            if(curr.right!=null) {
                pendingQueue.add(curr.right);
            }
        }
        ans.add(total/count);
        return ans;
    }
}
// @lc code=end

