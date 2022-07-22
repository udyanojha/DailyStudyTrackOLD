/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        return fib_mem(n, new int[n+1]);
    }
    public int fib_mem(int n, int[] strg) {
        if(n==0||n==1) {
            return n;
        }
        if(strg[n]!=0) {
            return strg[n];
        }
        int f1 = fib_mem(n-1, strg);
        int f2 = fib_mem(n-2, strg);
        strg[n] = f1+f2;
        return f1+f2;
    }
}
// @lc code=end

