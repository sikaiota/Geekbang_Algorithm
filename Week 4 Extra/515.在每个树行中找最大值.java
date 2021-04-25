import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = queue.peek().val;
            for (int i = 0; i < size; ++i) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                if (curr.val > max) max = curr.val;
            }
            result.add(max);
        }
        return result;
    }
}
// @lc code=end

