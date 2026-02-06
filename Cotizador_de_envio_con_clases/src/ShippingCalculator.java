public class ShippingCalculator {

    private final double IVA = 0.16;
    private final double PRECIO_EXPRESS = 90;
    private final double PRECIO_ESTANDAR = 50;

    public ShippingCalculator() {}

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
        double total = 0;

        if (tipoServicio == 1) {
            total = PRECIO_ESTANDAR;
        } else {
            total = PRECIO_EXPRESS;
        }

        total = total + (pesoKg * 12);

        if (distanciaKm <= 50) {
            total = total + 20;
        } else if (distanciaKm > 50 && distanciaKm <= 200) {
            total = total + 60;
        } else {
            total = total + 120;
        }

        if (zonaRemota == true) {
            total = total * 1.10;
        }

        return total;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * IVA;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}