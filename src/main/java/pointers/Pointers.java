package pointers;

import java.util.HashMap;

public class Pointers {
    public static void staticVariableExample(){
        String a = "22";
        String b = "11";
        a=b;
        System.out.println("Value before data manipulation a : "+ a);
        System.out.println("Value before data manipulation b : "+ a);
        b="33";
        System.out.println("Value after data manipulation a : "+ a);
        System.out.println("Value after data manipulation b : "+ b);
    }

    public static void dynamicVariableExample(){
        HashMap<String,String> a = new HashMap<>();
        HashMap<String,String> b = new HashMap<>();
        a.put("Value","22");
        b.put("Value","11");
        a=b;
        System.out.println("Value before data manipulation a : "+ a);
        System.out.println("Value before data manipulation b : "+ a);
        b.put("Value","33");
        System.out.println("Value after data manipulation a : "+ a);
        System.out.println("Value after data manipulation b : "+ b);
    }
}
