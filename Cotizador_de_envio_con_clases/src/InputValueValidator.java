import java.util.Scanner;

public class InputValueValidator {

    public double leerDoubleEnRango(String msg, Scanner sc, double min, double max) {
        double valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= min && valor <= max) {
                    sc.nextLine();
                    return valor;
                } else {
                    System.out.println("Error: El valor debe estar entre " + min + " y " + max);
                }
            } else {
                System.out.println("Error: Debes ingresar un numero valido.");
                sc.next();
            }
        }
    }

    public int leerIntEnRango(String msg, Scanner sc, int min, int max) {
        int valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    sc.nextLine();
                    return valor;
                } else {
                    System.out.println("Error: Opcion fuera de rango (" + min + " - " + max + ")");
                }
            } else {
                System.out.println("Error: Ingresa un numero entero.");
                sc.next();
            }
        }
    }

    public boolean leerBoolean(String msg, Scanner sc) {
        boolean valor;
        while (true) {
            System.out.println(msg + " (true/false)");
            if (sc.hasNextBoolean()) {
                valor = sc.nextBoolean();
                sc.nextLine();
                return valor;
            } else {
                System.out.println("Escribe 'true' o 'false' ");
                sc.next();
            }
        }
    }
}