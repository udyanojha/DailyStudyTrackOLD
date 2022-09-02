/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
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
    public int goodNodes(TreeNode root) {
        return good(root, Integer.MIN_VALUE);
    }
    private int good(TreeNode root, int max) {
        if(root==null) return 0;
        int ans = 0;
        if(root.val>=max) {
            ans+=1;
            max = root.val;
        }
        ans += good(root.left, max) + good(root.right, max);
        return ans;
    }
}
// @lc code=end

