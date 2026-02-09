import java.util.Scanner;

public class Validador {

    public String leerTextoNoVacio(Scanner sc, String msg) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.println(msg);
            texto = sc.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println("El texto no puede estar vacío");
            }
        }
        return texto;
    }

    public double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double numero;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                numero = sc.nextDouble();
                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("El número debe estar entre " + min + " y " + max);
                }
            } else {
                System.out.println("Ingresa un valor numérico válido");
                sc.next();
            }
        }
    }

    public int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int numero;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("El número debe estar entre " + min + " y " + max);
                }
            } else {
                System.out.println("Ingresa un numero entero valido");
                sc.next();
            }
        }
    }

    public boolean leerBooleanos(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("Escribe true o false");
                sc.next();
            }
        }
    }
}