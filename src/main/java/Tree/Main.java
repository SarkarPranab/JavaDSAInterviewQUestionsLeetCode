package Tree;

public class Main {
    public static void main(String[] args){
        BinarySearchTree myBST = new BinarySearchTree();
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(86);
        myBST.insert(18);
        myBST.insert(52);
        myBST.insert(82);
        System.out.println("Root : "+ myBST.root.value);
        myBST.insert(27);
        System.out.println(myBST.root.left.right.value);
        System.out.println("testing contains method : ");
        System.out.println(myBST.contains(17));
        System.out.println(myBST.contains(27));
        System.out.println("rContains method testing with value 18 : "+ myBST.rContains(18));
        System.out.println("rContains method testing with value 27 : "+ myBST.rContains(27));
        System.out.println("rContains method testing with value 19 (false) : "+ myBST.rContains(19));
        System.out.println("Testing insert: ");
        myBST.rInsert(12);
        myBST.rInsert(31);
        System.out.println("Get minimum value:");
        System.out.println("Root : "+ myBST.root);
        System.out.println(myBST.minvalue(myBST.root));
        System.out.println(myBST.minvalue(myBST.root.right));
        System.out.println("Testing delete");
        myBST.deleteNode(18);
        System.out.println("rContains method testing with value 18 : "+ myBST.rContains(18));
        System.out.println("Testing out BFS : Breadth First Search ");
        System.out.println(myBST.BFS());
        System.out.println("Testing out BFS : Depth First Search Preorder ");
        System.out.println(myBST.DFSPreorder());
        System.out.println("Testing out BFS : Depth First Search Postorder ");
        System.out.println(myBST.DFSPostorder());
        System.out.println("Testing out BFS : Depth First Search Inorder ");
        System.out.println(myBST.DFSInorder());
    }
}
