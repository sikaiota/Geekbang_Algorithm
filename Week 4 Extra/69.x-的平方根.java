/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    // 避免乘法溢出，用除法就行了...
    // 或者用牛顿迭代法 (x + a / x) / 2
    public int mySqrt(int x) {
        int lo = 0, hi = 46341;
        while (hi - lo > 1) {
            int mi = (hi + lo) / 2;
            if (mi * mi > x) hi = mi;
            else lo = mi;
        }
        return lo;
    }
}
// @lc code=end
