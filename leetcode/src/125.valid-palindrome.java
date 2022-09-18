/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int st = 0;
        int ed = s.length() -1;
        while(st<ed) {
            if(!isAlphaNumeric(s.charAt(st)) ) {
                st++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(ed)) )  {
                ed--;
                continue;
            }
            if(s.charAt(st)!=s.charAt(ed)) return false;
            st++;
            ed--;
        }
        return true;
    }
    
    private boolean isAlphaNumeric(char c) {
        if(c>='0' && c<='9') return true;
        if(c>='a' && c<='z') return true;
        return false;
    }
}
// @lc code=end

