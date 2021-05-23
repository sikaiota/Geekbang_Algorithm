/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
// 类似官方题解方法二
// 思路没问题，也不是傻递归，就是一开始没意识到分叉的情况就要用递归处理
// 习惯这种思维就好了
class Solution {
    public void generate(int n, char[] str, int left, int right, int ptr, List<String> result) {
        if (ptr == 2 * n) result.add(new String(str));
        else {
            if (left < right) {
                char[] rp = str.clone();
                rp[ptr] = ')';
                generate(n, rp, left, right - 1, ptr + 1, result);
            }
            if (left != 0) {
                char[] lp = str.clone();
                lp[ptr] = '(';
                generate(n, lp, left - 1, right, ptr + 1, result);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] str = new char[2 * n];
        generate(n, str, n, n, 0, result);
        return result;
    }
}
// @lc code=end

