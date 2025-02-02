package classes;

public class Main {
    public static void main(String[] args){
        Cookies cookieOne = new Cookies("green");
        Cookies cookieTwo = new Cookies("blue");

        System.out.println(cookieOne.getColor());
        System.out.println(cookieTwo.getColor());
        cookieOne.setColor("yellow");
        System.out.println(cookieOne.getColor());
    }
}
