import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    // 其他解法：递归，每次的元素加入或不加入两个分支；迭代，每次处理后数组数量翻倍
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        int pow = 1 << length;
        for (int i = 0; i < pow; ++i) {
            int idx = i;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < length; ++j) {
                if ((idx & (1 << j)) != 0) list.add(nums[j]);
            }
            result.add(list);
        }
        return result;
    }
}
// @lc code=end

