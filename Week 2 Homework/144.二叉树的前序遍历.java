/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
import java.util.Vector;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new Vector<>();
        Stack<TreeNode> preorder = new Stack<>();
        while (true) {
            while (root != null) {
                result.add(root.val);
                preorder.push(root.right);
                root = root.left;
            }
            if (preorder.empty()) break;
            root = preorder.pop();
        }
        return result;
    }
}
// @lc code=end

