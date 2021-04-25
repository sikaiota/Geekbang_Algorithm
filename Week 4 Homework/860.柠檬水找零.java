/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    // 属于贪心题目
    public boolean lemonadeChange(int[] bills) {
        int num5 = 0, num10 = 0; // no need to track $20
        int n = bills.length;
        for (int i = 0; i < n; ++i) {
            if (bills[i] == 5) {
                ++num5;
            } else if (bills[i] == 10) {
                if (num5 == 0) return false;
                else {
                    --num5;
                    ++num10;
                }
            } else { // $20 bill
                if (num10 > 0 && num5 > 0) {
                    --num10;
                    --num5;
                } else if (num5 >= 3) {
                    num5 -= 3;
                } else return false;
            }
        }
        return true;
    }
}
// @lc code=end

