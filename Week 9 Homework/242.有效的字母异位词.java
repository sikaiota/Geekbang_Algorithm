/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        // 数组大小为256适用于所有ASCII字符；按题目要求只有小写字母，数组大小为26即可
        int[] charCount = new int[26];
        int length = s.length();
        if (t.length() != length) return false;
        for (int i = 0; i < length; ++i) {
            ++charCount[s.charAt(i) - 'a'];
            --charCount[t.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            if (charCount[i] != 0) return false;
        }
        return true;
    }
}
// @lc code=end

