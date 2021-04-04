/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] oldNums = nums.clone();
        Arrays.sort(nums);
        int arrayLength = nums.length;
        int i = 0, j = arrayLength - 1;
        while (i < j) {
            if (nums[i] + nums[j] > target) --j;
            else if (nums[i] + nums[j] < target) ++i;
            else break;
        }
        int k = 0, l = 0;
        for (k = 0; k < arrayLength; ++k) {
            if (oldNums[k] == nums[i]) break;
        }
        for (l = 0; l < arrayLength; ++l) {
            if (oldNums[l] == nums[j] && l != k) break;
        }
        return new int[] {k, l};
    }
}
// @lc code=end

