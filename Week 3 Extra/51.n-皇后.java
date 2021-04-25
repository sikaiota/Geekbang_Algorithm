import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    // 完全用set的方法，很慢
    public void solve(int row, int n, List<List<String>> result, HashSet<Integer> queens, HashSet<Integer> slash, HashSet<Integer> backslash) {
        if (row == n) {
            List<String> answer = new ArrayList<>();
            Iterator<Integer> it = queens.iterator();
            while (it.hasNext()) {
                char[] buf = new char[n];
                Arrays.fill(buf, '.');
                buf[it.next()] = 'Q';
                answer.add(new String(buf));
            }
            result.add(answer);
        } else {
            for (int col = 0; col < n; ++col) {
                if (!queens.contains(col) && !slash.contains(row + col) && !backslash.contains(row - col)) {
                    queens.add(col);
                    slash.add(row + col);
                    backslash.add(row - col);
                    solve(row + 1, n, result, queens, slash, backslash);
                    queens.remove(col);
                    slash.remove(row + col);
                    backslash.remove(row - col);
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        HashSet<Integer> queens = new LinkedHashSet<>();
        HashSet<Integer> slash = new HashSet<>();
        HashSet<Integer> backslash = new HashSet<>();
        solve(0, n, result, queens, slash, backslash);
        return result;
    }
}
// @lc code=end

