/*
 * @lc app=leetcode id=1996 lang=java
 *
 * [1996] The Number of Weak Characters in the Game
 */

// @lc code=start
class Solution {
    
    public int numberOfWeakCharacters(int[][] arr) {
        Arrays.sort(arr, (a,b) -> {
            return (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        });
        for(int[] a : arr) System.out.println(a[0]+" "+a[1]);
        int count = 0;
        int max = 0;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i][1]<max) {
                count++;
            }
            max = Math.max(max, arr[i][1]);
        }
        return count;
    }
}
// @lc code=end

