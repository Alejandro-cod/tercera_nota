public class Logicos {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        int c = 20;

        System.out.println("a > b && b < c: " + (a > b && b < c)); // true
        System.out.println("a < b || b > c: " + (a < b || b > c)); // false
        System.out.println("!(a > b): " + !(a > b)); // false
    }
}