/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    // 较慢的方法：使用有序集合（替代小顶堆）
    // 每次丑数计算都有可能出现不止一个数是最小值
    // 每个得出最小值的下标都应该加1
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int m2 = 0, m3 = 0, m5 = 0, a, b, c;
        for (int i = 1; i < n; ++i) {
            a = nums[m2] * 2;
            b = nums[m3] * 3;
            c = nums[m5] * 5;
            nums[i] = Math.min(Math.min(a, b), c);
            if (nums[i] == a) ++m2;
            if (nums[i] == b) ++m3;
            if (nums[i] == c) ++m5;
        }
        return nums[n - 1];
    }
}
// @lc code=end

