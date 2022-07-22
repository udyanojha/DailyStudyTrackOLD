/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new int[n+1]);
    }
    // might give error due to stack size since we are using java
    public int climbStairs(int n, int[] strg) {
        if(n==0){
            return 1;
        } else if(n<0){
            return 0;
        }
        if(strg[n]!=0) {
            return strg[n];
        }

        int pathAfterStep1 = climbStairs(n-1, strg);
        int pathAfterStep2 = climbStairs(n-2, strg);
        int totalPath = pathAfterStep1 + pathAfterStep2;
        strg[n] = totalPath;
        return totalPath;

    }
}
// @lc code=end

