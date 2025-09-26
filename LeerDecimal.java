import java.util.Scanner;

public class LeerDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa un número decimal: ");
        double decimal = scanner.nextDouble();

        System.out.println("Número decimal leído: " + decimal);
    }
}