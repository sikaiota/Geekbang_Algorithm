import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        Integer j;
        for (int i = 0; i < length; ++i) {
            if ((j = map.get(target - nums[i])) != null && j != i) {
                return new int[] {i, j};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end

