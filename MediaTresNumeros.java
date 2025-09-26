import java.util.Scanner;

public class MediaTresNumeros {
    public static void main(String[] args) {
        // Crear el objeto Scanner para entrada de datos
        Scanner entrada = new Scanner(System.in);

        // Solicitar los tres números al usuario
        System.out.print("Ingrese el primer número: ");
        double numero1 = entrada.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double numero2 = entrada.nextDouble();

        System.out.print("Ingrese el tercer número: ");
        double numero3 = entrada.nextDouble();

        // Calcular la media
        double media = (numero1 + numero2 + numero3) / 3;

        // Mostrar el resultado
        System.out.printf("La media de los tres números es: %.2f\n", media);

        // Cerrar el Scanner
        entrada.close();
    }
}

