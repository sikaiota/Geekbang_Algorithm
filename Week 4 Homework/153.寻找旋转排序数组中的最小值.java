/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    // 最简单的边界条件：是不是比右侧小
    public int findMin(int[] nums) {
        int n = nums.length, rotation = 0;
        if (nums[0] > nums[n - 1]) {
            int lo = 0, hi = n;
            while (hi - lo > 1) {
                int mi = (lo + hi) >> 1;
                if (nums[lo] < nums[mi]) {
                    lo = mi;
                } else {
                    hi = mi;
                }
            }
            rotation = hi;
        }
        return nums[rotation];
    }
}
// @lc code=end

