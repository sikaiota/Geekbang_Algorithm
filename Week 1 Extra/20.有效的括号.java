/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> leftPar = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                leftPar.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (leftPar.empty() || leftPar.pop() != '(') {
                    return false;
                }
            } else if (s.charAt(i) == ']') {
                if (leftPar.empty() || leftPar.pop() != '[') {
                    return false;
                }
            } else {
                if (leftPar.empty() || leftPar.pop() != '{') {
                    return false;
                }
            }
        }
        return leftPar.empty();
    }
}
// @lc code=end

