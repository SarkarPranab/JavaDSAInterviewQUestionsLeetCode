package Tree;

import java.lang.reflect.Array;
import java.util.LinkedList;

import java.util.ArrayList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    class Node {
        int value;
        BinarySearchTree.Node left;
        BinarySearchTree.Node right;

        Node(int value) {
            this.value = value;
        }
    }


    //    public BinarySearchTree(int value){
//        Node newNode = new Node(value);
//        root = newNode;
//    }
//    To insert value to BST
    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                }
                temp = temp.left;
            }
            if (newNode.value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                }
                temp = temp.right;
            }

        }

    }

    // Check if BST contains value
    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    // Check if BST contains value using recursion
    private boolean rContains(Node currentNode, int value){
        if(currentNode == null) return false;
        if(currentNode.value == value) return true;
        if (value < currentNode.value){
            return rContains(currentNode.left, value);
        }else {
            return rContains(currentNode.right, value);
        }
    }

    // Check if BST contains value using recursion
    public boolean rContains(int value){
        return rContains(root, value);
    }

    // Insert a value eto binary tree using recursion
    private Node rInsert(Node currentNode, int value){
        if(currentNode == null) return new Node(value);
        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
        }else if(value > currentNode.value){
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    // Public record to access rInsert
    public void rInsert(int value){
        if(root == null) root = new Node(value);
        rInsert(root, value);
    }

    // Delete Node using recursion
    private Node deleteNode(Node currentNode, int value){
        if(currentNode == null) return null;
        if( value < currentNode.value){
            currentNode = currentNode.left;
        }else if(value > currentNode.value){
            currentNode = currentNode.right;
        }else {
            if(currentNode.left == null && currentNode.right == null){
                return null;
            }else if(currentNode.left == null) {
                currentNode = currentNode.right;
            }else if (currentNode.right == null) {
                currentNode = currentNode.left;
            }else{
                int subtreeMin = minvalue(currentNode.right);
                currentNode.value = subtreeMin;
                currentNode.right = deleteNode(currentNode.right, subtreeMin);
            }
        }
        return currentNode;
    }

    public void deleteNode(int value){
        deleteNode(root,value);
    }

    // Get minimum value form BST
    public int minvalue(Node currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    // BFS - Breadth First Search for BFS
    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> searchQueue = new LinkedList<>();
        ArrayList<Integer> BFSResults = new ArrayList<>();
        searchQueue.add(currentNode);
        while(searchQueue.size() > 0){
            currentNode = searchQueue.remove();
            BFSResults.add(currentNode.value);
            if(currentNode.left != null){
                searchQueue.add(currentNode.left);
            }
            if(currentNode.right != null){
                searchQueue.add(currentNode.right);
            }
        }
        return BFSResults;
    }

    // DFS - Depth First Search {Pre Order}
    public ArrayList<Integer> DFSPreorder(){
        ArrayList<Integer> results = new ArrayList<Integer>();
        class Traverse{
            Traverse(Node currentNode){
                results.add(currentNode.value);
                if(currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                if(currentNode.right != null){
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }
    // DFS - Depth First Search {Post Order}
    public ArrayList<Integer> DFSPostorder(){
        ArrayList<Integer> results = new ArrayList<Integer>();
        class Traverse{
            Traverse(Node currentNode){
                if(currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                if(currentNode.right != null){
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }
        new Traverse(root);
        return results;
    }

    // DFS - Depth First Search {In Order}
    public ArrayList<Integer> DFSInorder(){
        ArrayList<Integer> results = new ArrayList<Integer>();
        class Traverse{
            Traverse(Node currentNode){
                if(currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if(currentNode.right != null){
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }
}
