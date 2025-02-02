package DoublyLinkedList;


import LinkedList.LinkedList;

public class DoublyLinkedList {

    //    For Node
    private Node head;
    private Node tail;
    private int length;

    // inner class for Node
    class Node {
        int value;
        DoublyLinkedList.Node next;
        DoublyLinkedList.Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    //    Constructor for Doubly Linked list
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    //    Printing the DoublyLinkedList
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    //    Get Head of DoublyLinkedList
    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    //    Get Head of DoublyLinkedList as node
    public Node getHeadNode() {
        return head;
    }

    //    Get Tail of DoublyLinkedList
    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    //    Get Tail of DoublyLinkedList as node

    public Node getTailNode() {
        return tail;
    }

    //    Get Length of DoublyLinkedList
    public int getLength() {
        return length;
    }

    //    Append New node to doubly LinkedList
    public void append(int value) {
        Node appendNode = new Node(value);
        if (length == 0) {
            head = appendNode;
            tail = appendNode;
        } else {
            tail.next = appendNode;
            appendNode.prev = tail;
            tail = appendNode;
        }
        length++;
    }

    //    Remove Last node from doubly LinkedList
    public Node removeLast() {
        if (length == 0)
            return null;
        Node TempNode = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            TempNode.prev = null;
        }
        length--;
        return TempNode;
    }

    //  Prepand : Adding Node in the begaining of doubly linked list
    public void prepend(int val) {
        Node tempNode = new Node(val);
        if (length == 0) {
            head = tempNode;
            tail = tempNode;
        } else {
            tempNode.next = head;
            head.prev = tempNode;
            tempNode.prev = null;
            head = tempNode;
        }
        length++;
    }

    //    Remove First : To remove first node from Doubly Linked List
    public Node removeFirst() {
        if (length == 0)
            return null;
        if (length == 1) {
            head = null;
            tail = null;
            return null;
        }
        Node tempNode = head;
        head = head.next;
        head.prev = null;
        tempNode.next = null;
        length--;
        return tempNode;

    }

    //    Get Node by index in doubly linked list
    public Node get(int index) {
        if (index < 0 || index > length)
            return null;
        Node tempNode;
        if (index < length / 2) {
            tempNode = head;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.next;
            }
        } else {
            tempNode = tail;
            for (int i = length-1 ; i > index ; --i) {
                tempNode = tempNode.prev;
            }
        }

        return tempNode;
    }

//    Set Node by Index in doubly linked list
    public Node set(int index, int value){
        Node tempNode = get(index);
        if(tempNode != null){
            tempNode.value = value;
        }
        return tempNode;
    }

//    Insert Node by Index in doubly linked list
    public boolean Insert(int index, int value){
        if(index > length || index < 0){
            return false;
        }
        if(index == 0){
            append(value);
        }else if(index == length){
            prepend(value);
        }else{
            Node tempNode = new Node(value);
            Node before = get(index).prev;
            Node after = before.next;
            tempNode.prev = before;
            tempNode.next = after;
            before.next = tempNode;
            after.prev = tempNode;
        }
        length++;
        return true;
    }

//    Remove Node By Index in doubly LinkedList
    public boolean remove(int index){
        if(index > length || index < 0){
            return false;
        }

        if(index == 0){
            removeFirst();
        }else if(index == length){
            removeLast();
        }else{
            Node tempNode = get(index);
            tempNode.prev.next = tempNode.next;
            tempNode.next.prev = tempNode.prev;
            tempNode.next = null;
            tempNode.prev = null;
        }
        length--;
        return true;
    }
}