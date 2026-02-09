import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();
        Validador validador = new Validador();

        String nombre = validador.leerTextoNoVacio(sc, "Ingresa el nombre del alumno:");

        double p1 = validador.leerDoubleEnRango(sc, "Calificación Parcial 1 (0-100):", 0, 100);
        double p2 = validador.leerDoubleEnRango(sc, "Calificación Parcial 2 (0-100):", 0, 100);
        double p3 = validador.leerDoubleEnRango(sc, "Calificación Parcial 3 (0-100):", 0, 100);

        int asistencia = validador.leerIntEnRango(sc, "Porcentaje de Asistencia (0-100):", 0, 100);

        boolean proyecto = validador.leerBooleanos(sc, "¿Entregó el proyecto final? (true/false):");

        double promedio = service.calcularPromedio(p1, p2, p3);
        double notaFinal = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(notaFinal, asistencia, proyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, proyecto, notaFinal, estado);
    }

    public static void imprimirReporte(String nombre, double p1, double p2, double p3, double prom, int asis, boolean entProy, double finalScore, String estado) {
        System.out.println("\n===============================");
        System.out.println("         REPORTE FINAL         ");
        System.out.println("===============================");
        System.out.println("Nombre: " + nombre);
        System.out.println("Parciales: " + p1 + " | " + p2 + " | " + p3);
        System.out.println("Promedio Parciales: " + prom);
        System.out.println("Asistencia: " + asis + "%");
        System.out.println("Entrego Proyecto: " + entProy);
        System.out.println("-------------------------------");
        System.out.println("CALIFICACION FINAL: " + finalScore);
        System.out.println("ESTADO: " + estado);
        System.out.println("===============================");
    }
}