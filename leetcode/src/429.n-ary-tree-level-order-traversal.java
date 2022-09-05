/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            ArrayList<Integer> sans = new ArrayList<>();
            int size = que.size();
            for(int i = 0; i<size; i++) {
                Node curr = que.poll();
                for(Node child : curr.children) {
                    que.add(child);
                }
                sans.add(curr.val);
            }
            ans.add(sans);
        }
        return ans;
    }
}
// @lc code=end

