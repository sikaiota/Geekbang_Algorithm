/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int i = 0, j = 0, peak = height[0];
        // 找到两侧都是最大值的最长区间
        for (int k = 1; k < n; ++k) {
            if (peak < height[k]) {
                peak = height[k];
                i = k;
                j = k;
            } else if (peak == height[k]) {
                j = k;
            }
        }
        // 计算左侧到最左的最大值之间的雨水
        int result = 0, currMax = height[0];
        for (int k = 1; k < i; ++k) {
            if (currMax < height[k]) {
                currMax = height[k];
            } else {
                result += currMax - height[k]; 
            }
        }
        // 计算最大值围起来的区间的雨水
        for (int k = i + 1; k < j; ++k) {
            result += peak - height[k];
        }
        // 计算右侧到最右的最大值之间的雨水
        currMax = height[n - 1];
        for (int k = n - 2; k > j; --k) {
            if (currMax < height[k]) {
                currMax = height[k];
            } else {
                result += currMax - height[k];
            }
        }
        return result;
    }
}
// @lc code=end

