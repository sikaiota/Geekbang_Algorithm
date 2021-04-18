/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTreeHelper(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {
        if (pl == pr) return null;
        int val = preorder[pl];
        int ipivot = 0;
        for (int i = il; i < ir; ++i) {
            if (inorder[i] == val) {
                ipivot = i;
                break;
            }
        }
        int ppivot = pl + 1 + ipivot - il;
        return new TreeNode(val, 
        buildTreeHelper(preorder, pl + 1, ppivot, inorder, il, ipivot),
        buildTreeHelper(preorder, ppivot, pr, inorder, ipivot + 1, ir));
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTreeHelper(preorder, 0, n, inorder, 0, n);
    }
}
// @lc code=end

