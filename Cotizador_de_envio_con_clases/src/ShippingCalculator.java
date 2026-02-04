public class ShippingCalculator {

    public ShippingCalculator(){

    }


    double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota);

    double calcularIVA(double subtotal);

    double calcularTotal(double subtotal, double iva);
}
