import java.util.Scanner;

public class Main {
    // Constantes para IMC
    public static double BAJO = 18.5;
    public static double MEDIO = 25;
    public static double ALTO = 30;

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un círculo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    double pesoKG = obtenerDouble(leer, "Ingresa el peso en (KG)");
                    double alturaM = obtenerDouble(leer, "Ingresa la Altura en (M)");
                    double imc = calcularIMC(pesoKG, alturaM);
                    System.out.printf("El IMC es: %.2f%n", imc);
                    System.out.println("Clasificación: " + clasificarIMC(imc));
                    break;

                case 2:
                    double base = obtenerDouble(leer, "Ingresa la base del rectángulo:");
                    double altura = obtenerDouble(leer, "Ingresa la altura del rectángulo:");
                    double areaRect = calcularAreaRectangulo(base, altura);
                    System.out.println("El área del rectángulo es: " + areaRect);
                    break;

                case 3:
                    double celsius = obtenerDouble(leer, "Ingresa los grados Celsius:");
                    double fahrenheit = convertirCelciusAFahrenheit(celsius);
                    System.out.println(celsius + "°C equivalen a " + fahrenheit + "°F");
                    break;

                case 4:
                    double radio = obtenerDouble(leer, "Ingresa el radio del círculo:");
                    double areaCirc = calcularAreaCirculo(radio);
                    System.out.printf("El área del círculo es: %.2f%n", areaCirc);
                    break;

                case 5:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 5);

        leer.close();
    }

    // -------------MÉTODOS

    /**
     * Método para obtener un numero
     * @param leer Variable que va a leer
     * @param mensaje Mensaje que se imprimira
     * @return El número double ingresado por el usuario
     */
    public static double obtenerDouble(Scanner leer, String mensaje) {
        System.out.println(mensaje);
        return leer.nextDouble();
    }

    /**
     * Método para calcular y devolver el IMC
     * @param pesoKg Peso expresado en KG
     * @param alturaM Altura expresada en Metros
     * @return El valor de IMC
     */
    public static double calcularIMC(double pesoKg, double alturaM) {
        return pesoKg / (alturaM * alturaM);
    }

    /**
     * Método que devuelve el valor IMC
     * @param imc El valor del IMC
     * @return el mensaje de como estas
     *
     */
    public static String clasificarIMC(double imc) {
        if (imc < BAJO) return "Peso Bajo";
        else if (imc < MEDIO) return "Peso Normal (Medio)";
        else if (imc < ALTO) return "Sobrepeso";
        else return "Obesidad";
    }

    /**
     * Calcula el área de un rectángulo
     * @param base La base del rectángulo
     * @param altura La altura del rectángulo
     * @return El área total
     */
    public static double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Convierte una temperatura de grados Celsius a Fahrenheit
     * @param celsius La temperatura
     * @return La temperatura en Fahrenheit
     */
    public static double convertirCelciusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Calcula el área de un círculo dado su radio
     * @param radio El radio del círculo
     * @return El área
     */
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}