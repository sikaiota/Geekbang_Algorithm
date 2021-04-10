/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class ListNode {
    int data;
    ListNode prev, next;
    ListNode() {}
    ListNode(int val) {data = val;}
}

class MyCircularDeque {
    private ListNode _head, _tail;
    private int _size, _capacity;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        _capacity = k;
        _size = 0;
        _head = new ListNode();
        _tail = new ListNode();
        _head.next = _tail;
        _tail.prev = _head;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (_size == _capacity) return false;
        ListNode newNode = new ListNode(value);
        newNode.prev = _head;
        newNode.next = _head.next;
        _head.next = newNode;
        newNode.next.prev = newNode;
        ++_size;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (_size == _capacity) return false;
        ListNode newNode = new ListNode(value);
        newNode.next = _tail;
        newNode.prev = _tail.prev;
        _tail.prev = newNode;
        newNode.prev.next = newNode;
        ++_size;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (_size == 0) return false;
        ListNode front = _head.next;
        _head.next = front.next;
        front.next.prev = _head;
        --_size;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (_size == 0) return false;
        ListNode last = _tail.prev;
        _tail.prev = last.prev;
        last.prev.next = _tail;
        --_size;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (_size == 0) return -1;
        return _head.next.data;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (_size == 0) return -1;
        return _tail.prev.data;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return _size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return _size == _capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

