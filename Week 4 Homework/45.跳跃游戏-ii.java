/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    // 典型贪心问题，记每个位置最短步数的办法有点笨
    // 用两个变量，一个当前步数的最远位置，一个下一步的最远位置
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int reach = 0;
        int[] step = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            if (i + nums[i] >= n - 1) {
                return step[i] + 1;
            } else if (i + nums[i] > reach) {
                for (int j = reach + 1; j <= i + nums[i]; ++j) {
                    step[j] = step[i] + 1;
                }
                reach = i + nums[i];
            }
        }
        return -1;
    }
}
// @lc code=end

