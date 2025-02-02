package DoublyLinkedList;

public class Main {
   public static void main(String[] args){
       DoublyLinkedList myDLL = new DoublyLinkedList(7);
       myDLL.printList();
       myDLL.getHead();
       myDLL.getTail();
       myDLL.getLength();
       // append
       myDLL.append(4);
       myDLL.append(5);
       myDLL.append(6);
       myDLL.printList();
       // Remove Last
       myDLL.removeLast();
       System.out.println("[+]Output after removing last node[+]");
       myDLL.printList();
       // Prepend
       myDLL.prepend(9);
       myDLL.prepend(11);
       System.out.println("[+]Output after prepend node[+]");
       myDLL.printList();
//       System.out.println("[+]Output after prepend node[+]");
//       while( myDLL.getLength() > 1){
//           System.out.println("[+]After removing [+] : "+myDLL.removeFirst().value);
//           myDLL.printList();
//       }
       System.out.println("[+]Output after get[+]");
       System.out.println(myDLL.get(0).value);
       System.out.println(myDLL.get(4).value);
       System.out.println("[+]Output after set[+]");
       System.out.println(myDLL.set(4,6));
       myDLL.printList();
       System.out.println("[+]Output after Insert[+]");
       myDLL.Insert(3,5);
       myDLL.printList();
       System.out.println("[+]Output after Remove[+]");
       myDLL.remove(3);
       myDLL.printList();


   }
}
