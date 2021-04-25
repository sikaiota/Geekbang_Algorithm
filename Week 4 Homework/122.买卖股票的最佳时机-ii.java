/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    // 典型贪心/DP皆可的题目
    // 贪心：只要涨，每天结算
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int profit = 0, currMin = prices[0];
        for (int i = 1; i < days; ++i) {
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - currMin;
                currMin = prices[i];
            }
        }
        profit += prices[days - 1] - currMin;
        return profit;
    }
}
// @lc code=end

