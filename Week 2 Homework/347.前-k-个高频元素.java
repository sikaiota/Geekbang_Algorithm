import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b)->(a.getValue() - b.getValue()));
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (queue.size() == k && item.getValue() < queue.peek().getValue()) {
                continue;
            } else {
                queue.add(item);
                if (queue.size() > k) queue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
// @lc code=end

