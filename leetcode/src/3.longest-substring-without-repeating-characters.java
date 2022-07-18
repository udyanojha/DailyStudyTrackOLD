import java.util.HashMap;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        while(i<s.length()) {
            
        }

        return ans;
    }
    // int gMax = 0;
    //     for(int i = 0; i<s.length(); i++) {
    //         HashMap<Character, Boolean> map = new HashMap<>();
    //         int lMax = 0;
    //         int j = i;
    //         while(j<s.length()&&!map.containsKey(s.charAt(j))) {
    //             lMax++;
    //             map.put(s.charAt(j), true);
    //             j++;
    //         }
    //         if(gMax<lMax) {
    //             gMax = lMax;
    //         }
    //     }        

    //     return gMax;
}
// @lc code=end

