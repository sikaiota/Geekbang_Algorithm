/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public void combineHelper(List<List<Integer>> result, ArrayList<Integer> prefix, int n, int k) {
        if (n == k) {
            for (int i = 1; i <= k; ++i) {
                prefix.add(i);
            }
            result.add(prefix);
        } else if (k == 0) {
            result.add(prefix);
        } else {
            ArrayList<Integer> newprefix = (ArrayList) prefix.clone();
            newprefix.add(n);
            combineHelper(result, newprefix, n - 1, k - 1);
            combineHelper(result, prefix, n - 1, k);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> prefix = new ArrayList<>();
        combineHelper(result, prefix, n, k);
        return result;
    }
}
// @lc code=end

