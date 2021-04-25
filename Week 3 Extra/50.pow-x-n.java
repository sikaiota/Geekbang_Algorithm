/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    // n为负整数时直接取相反数会在MIN_VALUE时造成溢出
    // 可以先取倒数，或者可以用long long进行处理
    // 迭代版本使用二进制表示实现
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1.0 / x;
        else {
            double root = myPow(x, n / 2);
            return root * root * myPow(x, n % 2);
        }
    }
}
// @lc code=end

