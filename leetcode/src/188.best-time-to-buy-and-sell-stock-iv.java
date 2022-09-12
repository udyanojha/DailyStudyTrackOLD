/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        
        return maxProfit(k, prices, prices.length, new Integer[prices.length+1][k+1]);
        
    }
    public int maxProfit(int k, int[] prices, int idx, Integer[][] dp) {
        if(idx == 1 || k == 0) return 0;
        else if(idx == 2 && k>0) return Math.max(0, prices[1] - prices[0]);
        else if(dp[idx][k] != null) return dp[idx][k];
        
        int ans = 0, max_val = 0;
        
        for(int i = idx; i>=1; i--) {
            int leftAns = maxProfit(k-1, prices, i-1, dp);
            ans = Math.max(ans, leftAns + Math.max(0, max_val - prices[i-1]));
            max_val = Math.max(max_val, prices[i-1]);
        }
        dp[idx][k] = ans;
        return ans;
    }
}
// @lc code=end

