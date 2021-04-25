import java.util.Stack;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N 叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // 伪迭代写法，还是大量使用了递归；先序左右互换+遍历的写法最好
    public void toStack(Node root, Stack<Node> stack) {
        if (root != null) {
            stack.add(root);
            int numChild;
            if (root.children != null && (numChild = root.children.size()) != 0) {
                for (int i = numChild - 1; i >= 0; --i) {
                    toStack(root.children.get(i), stack);
                }
            }
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        toStack(root, stack);
        while (!stack.empty()) {
            result.add(stack.pop().val);
        }
        return result;
    }
}
// @lc code=end

