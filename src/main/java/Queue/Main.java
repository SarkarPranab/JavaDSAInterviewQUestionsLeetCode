package Queue;

public class Main {
    public static void main(String args[]){
        Queue newQueue = new Queue(7);
        newQueue.getFirst();
        newQueue.getLast();
        newQueue.getLength();
        System.out.println("[+] testing enqueue");
        newQueue.enqueueNode(7);
        newQueue.enqueueNode(8);
        newQueue.enqueueNode(9);
        newQueue.enqueueNode(10);
        newQueue.printQueue();
        System.out.println("[+] testing dequeue");
        newQueue.dequeueNode();
        newQueue.dequeueNode();
        newQueue.dequeueNode();
        newQueue.printQueue();
    }
}
