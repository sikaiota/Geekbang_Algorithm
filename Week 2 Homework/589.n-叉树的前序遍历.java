import java.util.ArrayList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N 叉树的前序遍历
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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            root = stack.pop();
            while (root != null) {
                result.add(root.val);
                int numChild;
                // Java的iterator好像不能反向行走
                // 这里可以用 Collections.reverse(root.children)
                // 再加上iterator或enhanced for loop
                if (root.children != null && (numChild = root.children.size()) != 0) {
                    for (int i = numChild - 1; i > 0; --i) {
                        stack.add(root.children.get(i));
                    }
                    root = root.children.get(0);
                } else break;
            }            
        }
        return result;
    }
}
// @lc code=end

