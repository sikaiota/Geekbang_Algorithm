/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    // 比较方便的数据结构：用HashMap<Character, String>
    // 以类似于进制的做法按顺序枚举所有组合的字符数组
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int n = digits.length();
        if (n == 0) return result;
        // 字母常量池
        char[][] key = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, 
        {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, 
        {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        // 每个按键对应字母个数的常量池
        int[] choice = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        int[] intDigits = new int[n];
        // 计算有多少种组合
        int comb = 1;
        for (int i = 0; i < n; ++i) {
            intDigits[i] = digits.charAt(i) - '0';
            comb *= choice[intDigits[i]];
        }
        // 构建字符串的buffer
        char[] resultArray = new char[n];
        for (int i = 0; i < comb; ++i) {
            int tmp = i;
            for (int j = n - 1; j >= 0; --j) {
                resultArray[j] = key[intDigits[j]][tmp % choice[intDigits[j]]];
                tmp /= choice[intDigits[j]];
            }
            result.add(new String(resultArray));
        }
        return result;
    }
}
// @lc code=end

