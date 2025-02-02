package Stack.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Stack: Push for a Stack That Uses an ArrayList ( ** Interview Question)
 * Stack: Pop for a Stack That Uses an ArrayList ( ** Interview Question)
 * Stack: Reverse String ( ** Interview Question)
 * Stack: Parentheses Balanced ( ** Interview Question)
 * Stack: Sort Stack ( ** Interview Question)
 * Queue Using Stacks: Enqueue ( ** Interview Question)
 * Queue Using Stacks: Dequeue ( ** Interview Question)
 */
public class LeetCode {
    /**
     * @problem 1441. Build an Array With Stack Operations
     * @link https://leetcode.com/problems/build-an-array-with-stack-operations/description/
     * @solution https://algo.monster/liteproblems/1441
     */
    public List<String> buildArray(int[] target, int n) {
        int current = 0;
        List<String> operations = new ArrayList<>();
        for (int targetValue : target) {
            while (++current < targetValue) {
                operations.add("Push");
                operations.add("Pop");
            }
            operations.add("Push");
        }
        return operations;
    }

    /**
     * @problem 1381. Design a Stack With Increment Operation
     * @link https://leetcode.com/problems/design-a-stack-with-increment-operation/description/
     * @solution https://algo.monster/liteproblems/1381
     */
    class CustomStack {
        private int[] stack; // Array to store stack elements
        private int[] increments; // Array to store increment operations
        private int topIndex; // Points to the next free spot in the 'stack' array (and the xurrent size of the stack)

        // Constructor to initialize the stock and increments array with the given maxSize
        public CustomStack(int maxSize) {
            stack = new int[maxSize];
            increments = new int[maxSize];
            topIndex = 0;
        }

        // Method to push an element onto the top of the stack if there is space available
        public void push(int x) {
            if (topIndex < stack.length) {
                stack[topIndex++] = x;
            }
        }

        // Method to remove and return the top element of the stack; if the stack is empty , returns -1
        public int pop() {
            if (topIndex <= 0) { // Check if stack is empty
                return -1;
            }
            int result = stack[--topIndex] + increments[topIndex]; // Get the top element with the increment
            if (topIndex > 0) { // If there's still an element below the top, transfer the increment
                increments[topIndex - 1] += increments[topIndex];
            }
            increments[topIndex] = 0;
            return result;
        }

        // Method to increment the bottom 'k' elementsby 'val'
        public void increment(int k, int val) {
            if (topIndex > 0) { // Check if stack is not empty
                int index = Math.min(topIndex, k) - 1; // Determine the index until which the increments should be applied
                increments[index] += val; // Apply the increments to the kth element or the current top, whichever is smaller
            }
        }
    }

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */


/**
 * @probleam 232. Implement Queue using Stacks
 * @link https://leetcode.com/problems/implement-queue-using-stacks/description/
 * @solution https://algo.monster/liteproblems/232
 * */
class MyQueue {
    // Use to stack to simulate a queue:
    // stkInput is sused for input operations (push)
    // stkOutput is used for output operations (pop and peek)
    private Deque<Integer> stkInput = new ArrayDeque<>();
    private Deque<Integer> stkOutput = new ArrayDeque<>();

    // Constructor for MyQueue. No initialization needed as
    // member variables are alredy initialized.
    public MyQueue() {
    }

    // Push element x to the back of the queue. Since a stack isLIFO (Last-in, first-out),
    // pushing to stkInpyt will reverse the order when transferred tostkOutput.
    public void push(int x) {
        stkInput.push(x);
    }

    // Pop the element from the front of the queue.
    // If stkOutput is empty, refill it by popping all elements
    // from stkInput and pushing them into stkOutput
    public int pop() {
        move();
        return stkOutput.pop();
    }

    // Get the front element.
    // Similiar to pop, enure stkOutput contains elements by moving
    // them fromstackInpu if necessary and then return the top element
    public int peek() {
        move();
        return stkOutput.peek();
    }

    // Return true if the queue is empty, which is when both stacks are empty
    public boolean empty() {
        return stkInput.isEmpty() && stkOutput.isEmpty();
    }


    // Helper method to move elements from stkInput to stkOutput. It ensures that
    // stkOutput contains elements in correct queue order for peeking or popping
    private void move(){
        // Only move elements if stkOutput is empty
        if(stkOutput.isEmpty()){
            // Move all elements from stkInput to stkOutput
            while(!stkInput.isEmpty()){
                stkOutput.push(stkInput.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

    /**
     * @problem 20. Valid Parentheses
     * @link https://leetcode.com/problems/valid-parentheses/description/?envType=problem-list-v2&envId=stack
     * @solution https://algo.monster/liteproblems/20
     * */
    class Solution20 {
        // Method to determine if an input string has valid parentheses
        public boolean isValid(String s) {
            // Use a deque as a stack to keep track of the opening brackets
            Deque<Character> stack = new ArrayDeque<>();
            // Iterate over each character in the input string
            for (char c : s.toCharArray()) {
                // If the current character is an opening bracket, push it onto the stack
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    // If the stack is empty or the current closing bracket doesn't match
                    // the last opening bracket, the string is not valid
                    if (stack.isEmpty() || !match(stack.pop(), c)) {
                        return false;
                    }
                }
            }
            // If the stack is empty, all brackets were matched correctly
            return stack.isEmpty();
        }

        // Helper method to determine if two brackets are a matching pair
        private boolean match(char leftBracket, char rightBracket) {
            // Return true if pairs match, false otherwise
            return (leftBracket == '(' && rightBracket == ')') ||
                    (leftBracket == '{' && rightBracket == '}') ||
                    (leftBracket == '[' && rightBracket == ']');
        }
    }

    /**
     * @problem 769. Max Chunks To Make Sorted
     * @link https://leetcode.com/problems/max-chunks-to-make-sorted/description/?envType=problem-list-v2&envId=stack
     * @solution https://algo.monster/liteproblems/769
     */
    public int maxChunksToSorted(int[] arr) {
        int chunkCount = 0; // Initialize the count of chunks
        int maxSoFar = 0; // Initialize the maximum value found so far in the array

        // Iterate through the array
        for(int index = 0; index < arr.length; ++index){
            // Update the maximum value seen so far
            maxSoFar = Math.max(maxSoFar, arr[index]);

            // If the current index is equal to the maximum value encountered.
            // it means all values before this index are smaller or equal to 'index'
            // and this position is a valid chunk boundary
            if(index == maxSoFar){
                // Increment the count of chunks
                ++chunkCount;
            }
        }
        return chunkCount; // Return the total number of chunks
    }
}
