/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
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
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        return tree2str(root, new StringBuilder()).toString();
        
    }
    public StringBuilder tree2str(TreeNode root, StringBuilder s) {
        if(root==null) return s;
        s.append(root.val);
        
        if(root.right==null&&root.left==null) return s;
        
        s.append('(');
        tree2str(root.left, s);
        s.append(')');
        
        if(root.right!=null) {
            s.append('(');
            tree2str(root.right, s);
            s.append(')');
        }
        return s;
    }
}
// @lc code=end

