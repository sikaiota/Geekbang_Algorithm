/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
// 模仿C++中Vector<T>::uniquify()的实现方式
class Solution {
    public int removeDuplicates(int[] nums) {
        int arrayLength = nums.length;
        if (arrayLength == 0) return 0;
        int j = 0;
        for (int i = 1; i < arrayLength; ++i) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
// @lc code=end

