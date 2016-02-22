
/*
    Implement the following operations of a stack using queues.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.
 */


import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue {
    Queue<Integer> stack;
    public stackUsingQueue(){
        stack = new LinkedList();
    }
    public void push(int x) {
        stack.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(stack.size() == 0)return;
        int i = 0;
        while(i < stack.size()-1){
            stack.offer(stack.poll());
            i++;
        }
        stack.poll();


    }

    // Get the top element.
    public int top() {
        if(stack.size() == 0) return -1;
        int i = 0;
        while(i < stack.size()-1){
            stack.offer(stack.poll());
            i++;
        }
        int val = stack.peek();
        stack.offer(stack.poll());
        return val;

    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.isEmpty();

    }

}
