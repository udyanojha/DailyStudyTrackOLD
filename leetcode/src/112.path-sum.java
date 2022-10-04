/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        boolean ans = false;
        targetSum-=root.val;
        if(root.left == null && root.right == null && targetSum == 0) {
            return ans = true;
        } else {
            if(root.left!=null) {
                ans = hasPathSum(root.left, targetSum);
            }
            if(root.right != null) {
                ans = ans || hasPathSum(root.right, targetSum);
            }
        }
        return ans;
    }
}
// @lc code=end

