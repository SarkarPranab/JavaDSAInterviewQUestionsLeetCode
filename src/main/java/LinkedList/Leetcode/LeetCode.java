package LinkedList.Leetcode;

public class LeetCode {
    /**
     * @PROBLEM01 1. LL: Find Middle Node ( ** Interview Question)
     * @Link: https://leetcode.com/problems/middle-of-the-linked-list/
     * @Link of Solution https://algo.monster/liteproblems/876
     */
    public static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;

            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 2. LL: Has Loop ( ** Interview Question)
     *
     * @Link: https://leetcode.com/problems/linked-list-cycle/description/
     * @Link of Solution https://algo.monster/liteproblems/19
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 3. LL: Find Kth Node From End ( ** Interview Question)
     *
     * @Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
     * @Link of Solution: https://algo.monster/liteproblems/19
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Lets create a dummy node whilr will be attched at first of the linked list
        ListNode dummyNode = new ListNode(0, head);

        //Now we will use two pointer strategy will create two pointer fast and slow and refer them to previously created dummy node
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        //We will get a input from user to so we will move first pointer to that step as we are using it will be n-- now as its count from 0
        // It wil also handle edgecase here if there is only one or no node
        while (n-- > 0) {
            fast = fast.next;
        }

        //now its time to move bith pointer in this way we will get the n node in gap between slow and fat until fast reaches to the end.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // when above condition satisfied and fast node reaches the end we can point slow to next to next node as next node will node to remove
        slow.next = slow.next.next;

        // now we can return refined node here by refer nodes starting next to dummynode we created
        return dummyNode.next;

    }

    /**
     * 4. LL: Partition List ( ** Interview Question)
     *
     * @Link: https://leetcode.com/problems/partition-list/description/
     * @solution: https://algo.monster/liteproblems/86
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(0); // Dummy node for the 'less' sublist.
        ListNode greaterHead = new ListNode(0); // Dummy node for the 'greater' sublist.
        ListNode lessTail = lessHead; // Tail pointer for the 'less' sublist.
        ListNode greaterTail = greaterHead; // Tail pointer for the 'greater' sublist.

        // Iterate over the original list and divide the nodes into 'less' and 'greater' sublists.
        while (head != null) {
            if (head.value < x) {
                // Append to 'less' sublist.
                lessTail.next = head;
                lessTail = head;
            } else {
                // Append to 'greater' sublist.
                greaterTail.next = head;
                greaterTail = head;
            }
            head = head.next; // Move to the next node in the original list.
        }

        // Connect the 'less' sublist with the 'greater' sublist.
        lessTail.next = greaterHead.next;
        greaterTail.next = null; // Ensure the last node of 'greater' sublist points to null.

        // Return the head of the 'less' sublist, which now contains all nodes in the partitioned order.
        return lessHead.next;
    }
    /**
     5. LL: Remove Duplicates ( ** Interview Question)
     @Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
     @solution: https://algo.monster/liteproblems/83
     */
    /**
     * Deletes all duplicates such that each element appears only once.
     *
     * @param head The head of the input linked list.
     * @return The head of the linked list with duplicates removed.
     */
    public ListNode deleteDuplicates(ListNode head) {
        // Initialize current to the head of the linked list
        ListNode current = head;

        // Iterate over the linked list
        while (current != null && current.next != null) {
            // If the current node's value is equal to the value of the next node, skip the next node
            if (current.value == current.next.value) {
                current.next = current.next.next;
            } else { // Otherwise, move to the next node
                current = current.next;
            }
        }

        // Return the head of the modified list
        return head;
    }

    /**
     * 6. LL: Binary to Decimal ( ** Interview Question)
     *
     * @param head The head of the input linked list.
     * @return decimal value
     * @Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/
     * @solution : https://algo.monster/liteproblems/1290
     */
    public int getDecimalValue(ListNode head) {
        // Let's first assign a number with 0
        int number = 0;
        while (head != null) {
            number = number << 1 | head.value;
            /* (0 * 2^1) + 1 = 1
            (1 * 2^1) + 0 = 2
            (2 * 2^1) + 1 = 5
            */
            head = head.next;
        }
        return number;
    }
    /**
     7. LL: Reverse Between ( ** Interview Question)
     @Link: https://leetcode.com/problems/reverse-linked-list-ii/description/
     @solution: https://algo.monster/liteproblems/92
     */
    /**
     * Reverses a section of a singly-linked list between the given positions.
     *
     * @param head  The head of the linked list.
     * @param left  The position from where to start the reversal (1-indexed).
     * @param right The position where to end the reversal (1-indexed).
     * @return The head of the modified linked list.
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // If there is only one node or no need to reverse, return the original list.
        if (head.next != null && left == right) {
            return head;
        }
        // Dummy node to simplify the handling of the head node.
        ListNode dummyNode = new ListNode(0, head);
        // Pointer to track the node before the reversal section.
        ListNode BeforeNodeReversal = dummyNode;
        for (int i = 0; i < left - 1; ++i) {
            BeforeNodeReversal = BeforeNodeReversal.next;
        }
        // 'firstReversed' will become the last node after the reversal.
        ListNode firstReversed = BeforeNodeReversal.next;
        // 'current' is used to track the current node being processed.
        ListNode current = firstReversed;
        ListNode prev = null;
        // Perform the actual reversal between 'left' and 'right'.
        for (int i = 0; i < right - left + 1; ++i) {
            ListNode tempNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNode;
        }
        // Reconnect the reversed section back to the list.
        BeforeNodeReversal.next = prev;// Connect with node before reversed part.
        firstReversed.next = current;// Connect the last reversed node to the remainder of the list.

        // Return the new head of the list.
        return dummyNode.next;
    }

//    MAIN METHOD TO TEST
    public static void main(String[] args) {
        /**
         * @PROBLEM01 Solution
         * */


    }

}
