/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums) totalSum+=num;
        if(totalSum%2!=0) return false;
        int target = totalSum/2;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        for(int i = 0; i<nums.length+1; i++) {
            for(int j = 0; j<target+1; j++) {
                if(j==0) {
                    dp[i][j] = true;
                } else if(i==0&&j>0) {
                    dp[i][j] = false;
                } else {
                    if(nums[i-1]<=j) {
                        dp[i][j] = (dp[i-1][j-nums[i-1]])||(dp[i-1][j]);
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[nums.length][target];
    }
}
// @lc code=end

