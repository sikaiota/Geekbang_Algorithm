/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0) return n;
        if (n == 0) return m;
        int[][] arr = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            arr[i][0] = i;
        }
        for (int j = 1; j <= n; ++j) {
            arr[0][j] = j;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1];                    
                } else {
                    arr[i][j] = Math.min(Math.min(arr[i - 1][j], arr[i][j - 1]), arr[i - 1][j - 1]) + 1;
                }
            }
        }
        return arr[m][n];
    }
}
// @lc code=end

