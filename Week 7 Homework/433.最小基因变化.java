/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    // 虽然当前写法的性能OK，但是
    // 寻找最小值应该用BFS！
    // 可以遍历基因库中未使用过的序列，检查差异是不是1
    // 也可以枚举所有可能的单变异结果，看是不是在集合里边
    public int diff(char[] s1, char[] s2) {
        int result = 0;
        for (int i = 0; i < 8; ++i) {
            if (s1[i] != s2[i]) ++result;
        }
        return result;
    }

    public int distance(char[] curr, char[] dest, char[][] set, int size, int step) {
        if (diff(curr, dest) == 0) return step;
        int minstep = -1;
        for (int i = step; i < size; ++i) {
            if (diff(curr, set[i]) == 1) {
                char[] temp = set[step];
                set[step] = set[i];
                set[i] = temp;
                int result = distance(set[step], dest, set, size, step + 1);
                if (result != -1) {
                    minstep = (minstep == -1) ? result : Math.min(minstep, result);
                }
            }
        }
        return minstep;
    }

    public int minMutation(String start, String end, String[] bank) {
        char[] src = start.toCharArray();
        char[] dest = end.toCharArray();
        int size = bank.length;
        char[][] set = new char[size][];
        for (int i = 0; i < size; ++i) {
            set[i] = bank[i].toCharArray();
        }
        return distance(src, dest, set, size, 0);
    }
}
// @lc code=end

