/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
// 如果k不能整除数组长度，那么隔k个数连续逆序右移能遍历所有数
// 否则需要多轮隔k个数移动才能遍历所有数
// 逻辑不如数组倒置的方法简明，且最大公约数计算略微有些耗时，两数交换并不比一次赋值慢很多
// 内存消耗一直很高是什么原因？不太懂
class Solution {
    public static int getGCD(int x, int y) {
        int temp;
        while ((temp = x % y) != 0) {
            x = y;
            y = temp;
        }
        return y;
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        if (k == 0) return;
        int round = getGCD(length, k);
        for (int i = 0; i < round; ++i) {
            int curr = length - k + i;
            int temp = nums[i];
            while (curr != i) {
                nums[(curr + k) % length] = nums[curr];
                curr = (curr + length - k) % length;
            }
            nums[(i + k) % length] = temp;            
        }
    }
}
// @lc code=end

