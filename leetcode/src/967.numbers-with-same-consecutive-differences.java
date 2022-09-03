/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 */

// @lc code=start
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i<10; i++) {
            dfs(n-1, k, ans, i);
        }
        if(n==1) {
            ans.add(0);
        }
        
        int[] res = new int[ans.size()];
        for(int i = 0 ; i<res.length; i++) res[i] = ans.get(i);
        return res;
    }
    
    private void dfs(int n, int k, ArrayList<Integer> ans, int num) {
        if(n==0) {
            ans.add(num);
            return;
        }
        int i = num%10;
        if(i+k<10) {
            dfs(n-1, k, ans, num*10+(i+k));
        }
        if(i-k>=0&&k>0) {
            dfs(n-1, k, ans, num*10+(i-k));
        }
    }
    
}
// @lc code=end

