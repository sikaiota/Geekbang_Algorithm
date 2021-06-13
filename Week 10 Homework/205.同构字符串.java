/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        char[] forward = new char[255];
        char[] backward = new char[255];
        for (int i = 0; i < n; ++i) {
            char target = forward[s.charAt(i) + 128];
            if (target == 0) {
                forward[s.charAt(i) + 128] = t.charAt(i);
            } else if (t.charAt(i) != target) {
                return false;
            }
            target = backward[t.charAt(i) + 128];
            if (target == 0) {
                backward[t.charAt(i) + 128] = s.charAt(i);
            } else if (s.charAt(i) != target) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

