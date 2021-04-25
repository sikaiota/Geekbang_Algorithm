/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    // 典型的从后往前贪心
    // DP：维护一个bool数组，每步把能到的位置改为true，O(n^2)
    // 贪心：从后向前，更新能到达最后的最小下标，看能不能推回0
    // 或：从前向后，不断更新最远到达点，看能不能推到最后
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int zero = -1;
        for (int i = n - 2; i >= 0; --i) {
            if (zero != -1) {
                if (nums[i] + i > zero) {
                    zero = -1;
                }
            } else if (nums[i] == 0) {
                zero = i;
            }
        }
        if (zero == -1) return true;
        else return false;
    }
}
// @lc code=end

