import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    // 使用HashMap达到去重的效果
    // 或者将数组排序，每次加入的数都是一段重复数中最左或最右未使用的数
    // 好像由于去重的需要，无法对遍历数组进行加速
    public void generate(List<List<Integer>> result, ArrayList<Integer> answer, HashMap<Integer, Integer> map, int n, int k) {
        if (k == 0) {
            result.add((List<Integer>) answer.clone());
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    answer.add(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                    generate(result, answer, map, n, k - 1);
                    answer.remove(answer.size() - 1);
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        generate(result, answer, map, n, n);
        return result;
    }
}
// @lc code=end

