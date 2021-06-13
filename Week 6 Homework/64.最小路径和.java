/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[n];
        arr[0] = grid[0][0];
        for (int j = 1; j < n; ++j) {
            arr[j] = arr[j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            arr[0] += grid[i][0]; 
            for (int j = 1; j < n; ++j) {
                arr[j] = Math.min(arr[j - 1], arr[j]) + grid[i][j];
            }
        }
        return arr[n - 1];
    }
}
// @lc code=end

