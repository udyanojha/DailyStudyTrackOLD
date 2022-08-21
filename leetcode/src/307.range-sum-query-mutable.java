/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */

// @lc code=start
class NumArray {
    
    class Fenwick {
        int[] farr;
        Fenwick(int[] nums) {
            this.farr = new int[nums.length+1];
        }

        int sum(int index) {
            int pos = index + 1;
            int sum = 0;
            while(pos>0) {
                sum += farr[pos];
                pos -= rsb(pos);
            }
            return sum;
        }

        void updateFa(int index, int delta) {
            int pos = index + 1;
            // int delta =  orr[index]-val;
            while(pos<farr.length) {
                farr[pos] += delta;
                pos += rsb(pos); 
            }
        }

        int rsb (int pos) {
            return pos & -pos;
        }

    }
    Fenwick fa;
    int[] orr;
    public NumArray(int[] nums) {
        fa = new Fenwick(nums);
        orr = nums;
        for(int i = 0; i<nums.length; i++) {
            fa.updateFa(i, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        

        fa.updateFa (index, val - orr[index]);
        orr[index] = val;

    }
    
    public int sumRange(int left, int right) {
        int lsum = fa.sum(left-1);
        int rsum = fa.sum(right);
        return rsum  - lsum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

