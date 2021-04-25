/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 区间写法；还可以通过中序遍历（迭代递归皆可）的结果是否单调递增来判断
    public boolean isValidBSTHelper(Integer min, Integer max, TreeNode node) {
        if (node == null) return true;
        if ((min == null || min < node.val) && (max == null || node.val < max)) {
            return isValidBSTHelper(min, node.val, node.left)
            && isValidBSTHelper(node.val, max, node.right);
        } else return false;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(null, null, root);
    }
}
// @lc code=end

