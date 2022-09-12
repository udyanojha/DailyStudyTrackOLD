import java.util.Arrays;

/*
 * @lc app=leetcode id=948 lang=java
 *
 * [948] Bag of Tokens
 */

// @lc code=start
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int st = 0;
        int ed = tokens.length-1;
        int max = 0;
        int curr = 0;
        while(st<=ed) {
            if(power>=tokens[st]) {
                curr+=1;
                power-=tokens[st];
                st++;
            } else if(max>0) {
                power+=tokens[ed];
                ed--;
                curr-=1;
            } else {
                break;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}
// @lc code=end

