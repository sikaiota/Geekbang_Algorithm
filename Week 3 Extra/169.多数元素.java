/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    // 能想到的解法：HashMap
    // 能想到排序，注意无论是降序还是升序，取下标为floor(n/2)的元素即可
    // 最优：Boyce-Moore
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int result = nums[0], count = 1;
        for (int i = 1; i < n; ++i) {
            if (count == 0) {
                result = nums[i];
                count = 1;
            } else if (result == nums[i]) {
                ++count;
            } else --count;
        }
        return result;
    }
}
// @lc code=end

