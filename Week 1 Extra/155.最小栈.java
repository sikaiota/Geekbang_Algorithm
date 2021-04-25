/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
import java.util.Stack;

class MinStack {
    private Stack<Integer> _stack, _min;
    /** initialize your data structure here. */
    public MinStack() {
        _stack = new Stack<>();
        _min = new Stack<>();
    }
    
    public void push(int val) {
        _stack.push(val);
        if (_min.empty()) {
            _min.push(val);
        } else {
            _min.push(Math.min(val, _min.peek()));
        }
    }
    
    public void pop() {
        _stack.pop();
        _min.pop();
    }
    
    public int top() {
        return _stack.peek();
    }
    
    public int getMin() {
        return _min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

