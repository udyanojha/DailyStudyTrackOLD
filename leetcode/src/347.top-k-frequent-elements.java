/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
import java.util.*;
class Solution {
    class Pair {
        int val;
        int idx;
        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Pair> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            map.putIfAbsent(nums[i], new Pair(nums[i], 0));
            map.get(nums[i]).idx++;
        }
        ArrayList<Pair> pairs = new ArrayList<>(map.values());
        // Collections.sort(pairs, new descComp());
        PriorityQueue<Pair> pq = new PriorityQueue<>(new descComp());
        for(Pair p : pairs) {
            pq.add(p);
            while(pq.size()>k) {
                pq.remove();
            }
        }


        int[] ans = new int[k];
        int index = k-1;
        while(!pq.isEmpty()) {
            ans[index--] = pq.remove().val;
        }
        // for(int i = 0; i<k; i++) {
        //     ans[i] = pairs.get(i).val;
        // }
        return ans;
    }

    public class descComp implements Comparator <Pair>{

        @Override
        public int compare(Solution.Pair o1, Solution.Pair o2) {
            if(o1.idx>o2.idx) {
                return 1;
            } else if(o1.idx<o2.idx) {
                return -1;
            }
            return 0;
        }
        
    }
}
// @lc code=end

