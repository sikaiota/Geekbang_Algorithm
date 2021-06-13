/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] arr = new int[26];
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (arr[c - 'a'] == 0) {
                arr[c - 'a'] = 1;
            } else {
                arr[c - 'a'] = -1;
            }
        }
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (arr[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

