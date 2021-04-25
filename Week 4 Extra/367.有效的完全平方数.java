/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        double x = num;
        while (true) {
            double y = (x + num / x) / 2;
            if (x - y < 1E-7) break;
            x = y;
        }
        int sqrt = (int) x;
        if (sqrt * sqrt == num) return true;
        else return false;
    }
}
// @lc code=end

