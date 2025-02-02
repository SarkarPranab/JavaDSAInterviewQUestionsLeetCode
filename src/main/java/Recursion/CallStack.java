package Recursion;

public class CallStack {
    public static void method03(){
        System.out.println("Method 03");
    }
    public static void method02(){
        method03();
        System.out.println("Method 02");
    }
    public static void method01(){
        method02();
        System.out.println("Method 01");
    }
    public static void main(String[] args){
        method01();
    }
}
