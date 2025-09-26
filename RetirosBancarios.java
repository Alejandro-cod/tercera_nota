public class RetirosBancarios {
    public static void main(String[] args) {
        double saldoInicial = 1000.0;
        double retiroSemanal = 200.0;
        int semanas = 4;

        double totalRetirado = retiroSemanal * semanas;
        double saldoFinal = saldoInicial - totalRetirado;

        // Mostrar resultados
        System.out.println("===== RETIROS BANCARIOS =====");
        System.out.printf("Saldo inicial: $%.2f\n", saldoInicial);
        System.out.printf("Total retirado en %d semanas: $%.2f\n", semanas, totalRetirado);
        System.out.printf("Saldo final: $%.2f\n", saldoFinal);
    }
}
