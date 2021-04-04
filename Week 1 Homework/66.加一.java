/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int numLength = digits.length;
        int carry = 1;
        for (int i = numLength - 1; i >= 0; --i) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                ++digits[i];
                carry = 0;
                break;
            }
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] result = new int[numLength + 1];
            result[0] = 1;
            // 一定是999...9进位，利用new数组元素缺省为0
            // for (int i = 0; i < numLength; ++i) {
            //     result[i + 1] = digits[i];
            // }
            return result;
        }        
    }
}
// @lc code=end

