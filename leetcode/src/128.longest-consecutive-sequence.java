/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
import java.util.HashMap;
class Solution {
    public int longestConsecutive(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i< arr.length; i++) {
            map.put(arr[i], true);
        }
        int ansMax = 0;     
        for(int i = 0; i<arr.length; i++) {
            int num = arr[i];
            int currSt = num;
            int currMax = 1;
            if(map.get(num)) {
                int key = num+1;
                while(map.containsKey(key)) {
                    currMax++;
                    key++;
                }
                key = num-1;
                while(map.containsKey(key)) {
                    currMax++;
                    currSt = key;
                    key--;
                }
                if(currMax>ansMax) {
                    ansMax = currMax;
                }
                	// System.out.println(currIdx+" "+ansIdx);
            }
            map.put(num, false);
        }
        return ansMax;
    }
}
// @lc code=end

/*
 * public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		HashMap<Integer, Pair> map = new HashMap<>();
        for(int i = 0; i< arr.length; i++) {
            map.put(arr[i], new Pair(arr[i],i));
        }
        int ansMax = 0;
        int ansStart = arr[0];
        int ansIdx = 0;
        
        for(int i = 0; i<arr.length; i++) {
            int num = arr[i];
            int currSt = num;
            int currMax = 0;
            int currIdx = i;
            if(map.get(num).idx!=-1) {
                int key = num+1;
                while(map.containsKey(key)) {
                    currMax++;
                    key++;
                }
                key = num-1;
                while(map.containsKey(key)) {
                    currMax++;
                    currSt = key;
                    currIdx = map.get(key).idx;
                    key--;
                }
                if(currMax>ansMax) {
                    ansStart = currSt;
                    ansMax = currMax;
                    ansIdx = currIdx;
                } else if(currMax==ansMax) {
                    if(currIdx<ansIdx) {
                        ansIdx = currIdx;
                    }
                	// System.out.println(currIdx+" "+ansIdx);
                }
            }
            // map.put(num, new Pair(num, -1));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ansStart = arr[ansIdx];
        ans.add(ansStart);
        ans.add(ansMax+ansStart);
        return ans;
        
    }
 */