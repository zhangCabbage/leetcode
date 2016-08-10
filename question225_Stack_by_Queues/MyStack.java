package zhang.algorithm.leetcode.question225_Stack_by_Queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: zhang_MacPro
 * Date: 16/8/10
 * Time: 下午8:58
 * To change this template use File | Settings | File Templates.
 * <p>
 * 16 / 16 test cases passed
 * Status: Accepted
 * Runtime: 112 - 144 ms, bit 2.60 - 56.11%
 */
public class MyStack {

    Queue<Integer> stack = new LinkedList<>();
    int top = 0;

    // Push element x onto stack.
    public void push(int x) {
        stack.offer(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        for (int i = 1; i < stack.size(); i++) {
            push(stack.poll());
        }
        stack.poll();
    }

    // Get the top element.
    public int top() {
//        int top = 0;
//        for (int i = 0; i < stack.size(); i++) {
//            top = stack.poll();
//            stack.offer(top);
//        }
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.isEmpty();
    }

    //--------------------------------------------------
    // a smart way to impements only O(1)
    // 16 / 16 test cases passed
    // Status: Accepted
    // Runtime: 114 - 122 ms, bit 21.49 - 47.33%
    //--------------------------------------------------
    private Queue queue;

    public void push2(int x) {
        Queue q = new LinkedList<>();
        q.add(x);
        q.add(queue);
        queue = q;
    }

    public void pop2() {
        queue.remove();
        queue = (Queue) queue.peek();
    }

    public int top2() {
        return (int) queue.peek();
    }

    public boolean empty2() {
        return queue == null;
    }
}
