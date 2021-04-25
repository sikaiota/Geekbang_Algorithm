/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    // 一次二分查找：与左中右的值都进行比较
    public int search(int[] nums, int target) {
        int n = nums.length, rotation = 0;
        if (nums[0] > nums[n - 1]) {
            int lo = 0, hi = n;
            while (hi - lo > 1) {
                int mi = (lo + hi) >> 1;
                if (nums[lo] < nums[mi]) {
                    lo = mi;
                } else {
                    hi = mi;
                }
            }
            rotation = hi;
        }
        int lo = 0, hi = n;
        while (hi - lo > 1) {
            int mi = (lo + hi) >> 1;
            if (target < nums[(mi + rotation) % n]) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
        int result = (lo + rotation) % n;
        if (target == nums[result]) return result;
        else return -1;
    }
}
// @lc code=end

