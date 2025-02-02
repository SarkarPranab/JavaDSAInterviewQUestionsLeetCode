package LinkedList;

public class Main{
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<Integer>(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.PrintList();
//        System.out.println("-------");
//        System.out.println("Removed : "+linkedList.removeLast().value);
//        System.out.println("-------");
//        linkedList.PrintList();
//        System.out.println("-------");
//        System.out.println("Removed : "+linkedList.removeLast().value);
//        System.out.println("-------");
//        linkedList.PrintList();
//        System.out.println("-------");
//        System.out.println("Removed : "+linkedList.removeLast().value);
//        System.out.println("-------");
//        linkedList.PrintList();
//        System.out.println("-------");
//        System.out.println("Removed : "+linkedList.removeLast().value);
//        System.out.println("-------");
//        linkedList.PrintList();
//        /* Linkedlist : Prepend */
        linkedList.prepend(9);
        linkedList.prepend(11);
        linkedList.prepend(13);
        System.out.println("---PREPEND---");
        linkedList.PrintList();
        /*System.out.println("----REMOVE FIRST---");
        System.out.println(linkedList.removeFirst().value);
        System.out.println("----");
        linkedList.PrintList();
        System.out.println("----REMOVE FIRST---");
        System.out.println(linkedList.removeFirst().value);
        System.out.println("----");
        linkedList.PrintList();
        System.out.println("----REMOVE FIRST---");
        System.out.println(linkedList.removeFirst().value);
        System.out.println("----");
        linkedList.PrintList();*/
        System.out.println("---GET---");
        System.out.println(linkedList.Get(2).value);
        System.out.println("---------");
        System.out.println(linkedList.Get(4).value);
        System.out.println("---SET---");
        linkedList.PrintList();
        System.out.println("---------");
        System.out.println(linkedList.Set(1,0).value);
        System.out.println("---------");
        linkedList.PrintList();
        System.out.println("----INSERT----");
        linkedList.Insert(3,6);
        linkedList.Insert(4,8);
        linkedList.PrintList();
        System.out.println("----REMOVE----");
        linkedList.Remove(3);
        linkedList.Remove(4);
        linkedList.PrintList();
        System.out.println("----Reverse----");
        linkedList.Reverse();
        linkedList.PrintList();
    }
}