import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numeroLimite;
        int sumaTotal;

        numeroLimite = pedirEntero(scanner);

        sumaTotal = sumarHastaN(numeroLimite);

        System.out.println("El resultado de la suma desde 1 hasta " + numeroLimite + " es: " + sumaTotal);

        scanner.close();
    }

    // Método para manejar la entrada y validación
    public static int pedirEntero(Scanner scanner) {
        int numero = 0;
        boolean esValido = false;

        while (!esValido) {
            System.out.print("Por favor, ingrese un número entero positivo: ");

            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();

                if (numero > 0) {
                    esValido = true;
                } else {
                    System.out.println("Error: El número debe ser mayor a 0.");
                }
            } else {
                System.out.println("Error: Lo que ingresaste no es un número válido.");
                scanner.next();
            }
        }
        return numero;
    }
    // Método que contiene la lógica matemática
    public static int sumarHastaN(int limite) {
        int acumulador = 0;

        for (int i = 1; i <= limite; i++) {
            acumulador += i;
        }

        return acumulador;
    }
}