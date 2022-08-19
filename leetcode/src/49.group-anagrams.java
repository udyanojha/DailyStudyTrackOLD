/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            // String temp = ch.toString();
            String temp = new String(ch);
            map.putIfAbsent(temp, new ArrayList<>());
            map.get(temp).add(str);
        }
        // Set<String> keys = map.keySet();
        // for(String s : keys) {
        //     System.out.print(s+" ");
        // }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

