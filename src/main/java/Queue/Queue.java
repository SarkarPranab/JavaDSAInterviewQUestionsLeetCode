package Queue;

import Stack.Stack;

public class Queue {
    Node first;
    Node last;
    int length;

    class Node {
        int value;
        Queue.Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Queue(int value) {
        Node myNode = new Node(value);
        first = myNode;
        last = myNode;
        length = 1;
    }

    // Print whole queue
    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(" Printing Whole Queue : " + temp.value);
            temp = temp.next;
        }
    }

    // Print First Node in Queue
    public void getFirst() {
        System.out.println("Get first : " + first.value);
    }

    // Print Last Node in Queue
    public void getLast() {
        System.out.println("Get last : " + last.value);
    }

    // Print Length of Queue
    public void getLength() {
        System.out.println("Get length : " + length);
    }

    // Enqueue of node (at last)
    public void enqueueNode(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    // Dequeue of node (at first)
    public Node dequeueNode(){
        Node temp;
        if(length == 0)
            return null;
        if(length == 1){
            temp = first;
            first = null;
            last = null;
            return temp;
        } else{
            temp = first;
            first = first.next;
            temp.next = null;
        }
        return temp;
    }
}