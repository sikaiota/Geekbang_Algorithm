/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        for (int right = 0; right < length; ++right) {
            if (!list.isEmpty() && list.peekFirst() < right - k + 1) {
                list.pollFirst();
            }
            while (!list.isEmpty() && nums[right] >= nums[list.peekLast()]) {
                list.pollLast();
            }
            list.addLast(right);
            if (right >= k - 1) {
                result[right - k + 1] = nums[list.peekFirst()];
            }
        }
        return result;
    }
}
// @lc code=end

