/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    // 属于贪心算法，从小端或大端开始匹配都可以
    public int findContentChildren(int[] g, int[] s) {
        int ng = g.length, ns = s.length;
        int result = 0, i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < ng && j < ns) {
            if (g[i] <= s[j]) {
                ++i;
                ++j;
                ++result;
            } else {
                ++j;
            }
        }
        return result;
    }
}
// @lc code=end

