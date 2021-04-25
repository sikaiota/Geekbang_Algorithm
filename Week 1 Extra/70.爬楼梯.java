/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
// 爬n阶楼梯有Fib(n+1)中方法
class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        for (int i = 1; i < n; ++i) {
            b = b + a;
            a = b - a;
        }
        return b;
    }
}
// @lc code=end

