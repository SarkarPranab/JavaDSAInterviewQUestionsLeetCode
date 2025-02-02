package LinkedList.Leetcode;
class ListNode {
    int value;
    ListNode next;

    // Constructor with no parameters
    ListNode() {}

    // Constructor with value parameter
    ListNode(int value) {
        this.value = value;
    }

    // Constructor with value and next node parameters
    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
