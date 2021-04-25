/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
// 枚举-O(n^2) 超时
// 从最大宽度向内收敛，因宽度变小，最小高度必须变高才可能有更大的面积；同时，增加较矮的一侧才会有收益
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int area = 0;
        int currHeight = 0;
        int heightCount = height.length;
        for (int i = 0, j = heightCount - 1; i < j; ) {
            currHeight = height[i] < height[j] ? height[i++] : height[j--];
            area = (j - i + 1) * currHeight;
            max = area > max ? area : max;
        }
        return max;
    }
}
// @lc code=end

