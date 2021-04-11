/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

class Solution {
    // 类似于官方题解方法二，用两个Queue或者ArrayList实现分层输出；
    // 复制较长的链表用enhanced for loop或iterator
    // 可以尝试使用addAll()的速度
    // 方法一使用当前层节点数量queue.size()实现分层
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new Vector<>();
        Queue<Node> nextLevel = new LinkedList<>();
        Queue<Node> currLevel = new LinkedList<>();
        if (root != null) {
            nextLevel.add(root);
            while (!nextLevel.isEmpty() || !currLevel.isEmpty()) {
                List<Integer> currList = new Vector<>();
                while (!nextLevel.isEmpty()) {
                    root = nextLevel.poll();                
                    currList.add(root.val);
                    currLevel.add(root);
                }
                result.add(currList);
                while (!currLevel.isEmpty()) {
                    root = currLevel.poll();
                    Iterator<Node> it = root.children.iterator();
                    while (it.hasNext()) {
                        nextLevel.add(it.next());
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

