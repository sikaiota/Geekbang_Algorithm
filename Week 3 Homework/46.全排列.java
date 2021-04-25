import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    // 没有明显比用HashMap<Integer, Boolean>快
    // 用交换的方法将用过的数放在左侧，未用的留在右侧，就不需要每次都遍历候选数组，但输出顺序就不是字典序了
    public void generate(List<List<Integer>> result, List<Integer> answer, int[] nums, boolean[] used, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(answer));
        } else {
            for (int i = 0; i < n; ++i) {
                if (!used[i]) {
                    answer.add(nums[i]);
                    used[i] = true;
                    generate(result, answer, nums, used, n, k - 1);
                    answer.remove(answer.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        boolean[] used = new boolean[n];
        List<Integer> answer = new ArrayList<>();
        generate(result, answer, nums, used, n, n);
        return result;
    }
}
// @lc code=end

