/*
 * @lc app=leetcode id=393 lang=java
 *
 * [393] UTF-8 Validation
 */

// @lc code=start
class Solution {
    public boolean validUtf8(int[] data) {
        int bytesLeft = 0;
        for(int val : data) {
            if(bytesLeft == 0) {
                if(val >> 7 == 0b0) { // for 1 byte char
                    bytesLeft = 0;
                } else if (val >> 5 == 0b110) { // for 2 byte char
                    bytesLeft = 1;
                } else if (val >> 4 == 0b1110) { // for 3 byte char
                    bytesLeft = 2;
                } else if (val >> 3 == 0b11110) { // for 4 byte char
                    bytesLeft = 3;
                } else {
                    return false;
                }
            } else {
                if(val >> 6 == 0b10) bytesLeft--;
                else return false;
            }
        }
        return (bytesLeft==0);
    }
}
// @lc code=end

