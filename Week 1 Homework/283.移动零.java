/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
// 类似于LeetCode官方题解的第二种方法
// 或者从左到右用swap，或课上的手动与0交换，省去第二个循环的置零操作
class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        int arrayLength = nums.length;
        for (int i = 0; i < arrayLength; ++i) {
            if (nums[i] != 0) {
                nums[i - zeroCount] = nums[i];
            } else {
                ++zeroCount;
            }  
        }
        for (int i = arrayLength - zeroCount; i < arrayLength; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

