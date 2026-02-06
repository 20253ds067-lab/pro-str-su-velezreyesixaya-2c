import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        InputValueValidator inputValidator = new InputValueValidator();
        ShippingCalculator shippingCalculator = new ShippingCalculator();

        System.out.println("--- BIENVENIDO A COTIZADOR DE ENVIO ---");

        double pesoKg = inputValidator.leerDoubleEnRango("Ingresa el peso en KG (0.1 - 50.0):", sc, 0.1, 50.0);
        int distanciaKm = inputValidator.leerIntEnRango("Ingresa la distancia en KM (1 - 2000):", sc, 1, 2000);
        int tipoServicio = inputValidator.leerIntEnRango("Tipo de servicio: 1) Estandar  2) Express", sc, 1, 2);

        boolean esZonaRemota = inputValidator.leerBoolean("¿Es zona remota?", sc);

        double subtotal = shippingCalculator.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = shippingCalculator.calcularIVA(subtotal);
        double total = shippingCalculator.calcularTotal(subtotal, iva);

        imprimirTicket(pesoKg, distanciaKm, tipoServicio, esZonaRemota, subtotal, iva, total);

        sc.close();
    }

    public static void imprimirTicket(double peso, int dist, int tipo, boolean remota, double sub, double iva, double tot) {
        System.out.println("\n==================================");
        System.out.println("       TICKET DE ENVIO");
        System.out.println("==================================");

        String nombreServicio = "";
        if(tipo == 1) nombreServicio = "Estandar";
        else nombreServicio = "Express";

        System.out.println("Servicio: " + nombreServicio);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia: " + dist + " km");
        System.out.println("Zona Remota: " + remota);
        System.out.println("----------------------------------");
        System.out.println("Subtotal:  $" + sub);
        System.out.println("IVA (16%): $" + iva);
        System.out.println("==================================");
        System.out.println("TOTAL:     $" + tot);
        System.out.println("==================================");
    }
}