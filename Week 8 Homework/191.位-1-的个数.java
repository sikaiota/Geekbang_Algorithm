/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int step1_2bit = ((n & 0xaaaaaaaa) >>> 1) + (n & 0x55555555);
        int step2_4bit = ((step1_2bit & 0xcccccccc) >>> 2) + (step1_2bit & 0x33333333);
        int step4_8bit = ((step2_4bit & 0xf0f0f0f0) >>> 4) + (step2_4bit & 0x0f0f0f0f);
        int step8_16bit = ((step4_8bit & 0xff00ff00) >>> 8) + (step4_8bit & 0x00ff00ff);
        int count = (step8_16bit >>> 16) + (step8_16bit & 0x0000ffff);
        return count;
    }
}
// @lc code=end

