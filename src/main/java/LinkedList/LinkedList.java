package LinkedList;

import java.util.HashMap;

public class LinkedList<N> {
    private Node head;
    private Node tail;
    private int length;

    // inner class for Node
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        // create new node
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void PrintList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        // create new node
        // add node to end
        Node AppendNode = new Node(value);
        if (length == 0) {
            head = AppendNode;
            tail = AppendNode;
        } else {
            tail.next = AppendNode;
            tail = AppendNode;
        }
        length++;
    }

    public void prepend(int value) {
        // create new Node
        // add Node to beginning
        Node temp = head;
        Node valueToPrepend = new Node(value);
        if (length == 0) {
            head = valueToPrepend;
            tail = valueToPrepend;
        } else {
            head = valueToPrepend;
            head.next = temp;
        }
        length++;
    }

    public boolean Insert(int index, int value){
        if(index == 0){
            append(value);
        } else if (index == length) {
            prepend(value);
        }else{
            Node insertNode = new Node(value);
            Node getPreNode = GetAsMap().get(index-1);
            Node getPostNode = getPreNode.next;
            getPreNode.next = insertNode;
            insertNode.next = getPostNode;
        }
        length++;
        return true;
    }

    public boolean Remove(int index){
        if(index == 0){
            removeFirst();
        } else if (index == length) {
            removeLast();
        }else{
            Node getPreNode = GetAsMap().get(index-1);
            Node getPostNode = GetAsMap().get(index+1);
            getPreNode.next = getPostNode;
        }
        length++;
        return true;
    }

    public Node removeLast() {
        // remove a node
        // remove node at last
        if (length == 0) {
            return null;
        }
        Node Temp = head;
        Node Pre = head;
        while (Temp.next != null) {
            Pre = Temp;
            Temp = Temp.next;
        }
        tail = Pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return Temp;
    }

    public Node removeFirst() {
        Node temp = head;
        if (length == 0) {
            return null;
        } else if (length == 1) {
            head = null;
            tail = null;
            length--;
        } else {
            head = temp.next;
            length--;
        }
        return temp;
    }

    public HashMap<Integer, Node> GetAsMap() {
        HashMap<Integer, Node> getMap = new HashMap<>();
        Node temp = head;
        int countIndex = 0;
        while (temp != null) {
            getMap.put(countIndex, temp);
            temp = temp.next;
            countIndex++;
        }
        return getMap;
    }

    public Node Get(int index) {
        return GetAsMap().get(index);
    }

    public Node Set(int index, int value) {
        Node temp = GetAsMap().get(index);
        temp.value = value;
        return temp;
    }

    public void Reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

}
