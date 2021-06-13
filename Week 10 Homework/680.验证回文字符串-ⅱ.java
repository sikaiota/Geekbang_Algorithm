/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return substringValid(s, i, j - 1) || substringValid(s, i + 1, j);
            }
        }
        return true;
    }
    public boolean substringValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
// @lc code=end

