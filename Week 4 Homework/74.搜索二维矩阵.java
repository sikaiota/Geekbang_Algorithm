/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo < hi) {
            int mi = (lo + hi) >> 1;
            if (target <= matrix[mi / n][mi % n]) hi = mi;
            else lo = mi + 1;
        }
        return target == matrix[lo / n][lo % n];
    }
}
// @lc code=end

