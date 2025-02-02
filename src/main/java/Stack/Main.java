package Stack;

public class Main {
    public static void main(String[] args){
        Stack myStack = new Stack(4);
        myStack.getTop();
        myStack.getHeight();
        myStack.printStack();
        myStack.pushDataToStack(6);
        myStack.pushDataToStack(7);
        myStack.pushDataToStack(8);
        myStack.pushDataToStack(9);
        System.out.println("[+] Testing push");
        myStack.printStack();
        System.out.println("[+] Testing pop");
        myStack.popDataFromStack();
        myStack.printStack();

    }
}
