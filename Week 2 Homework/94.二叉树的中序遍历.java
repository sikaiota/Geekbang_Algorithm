import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public void leftToStack(TreeNode subtree, Stack<TreeNode> stack) {
        while (subtree != null) {
            stack.push(subtree);
            subtree = subtree.left;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new Vector<>();
        Stack<TreeNode> _inorder = new Stack<>();
        TreeNode curr = root;
        while (true) {
            leftToStack(curr, _inorder);
            if (_inorder.empty()) break;
            curr = _inorder.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
}
// @lc code=end

