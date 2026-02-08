import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        String nombre_usuario;

        double cal1 ;
        double cal2;
        double cal3;
        double promedio_par=0;
        double calificacion_final=0;

        int asistencia;

        boolean entrega_proyecto;

        System.out.println("Ingresa el nombre del alumno");
        nombre_usuario = leer.nextLine();

        System.out.println("Ingresa tu calificacion I");
        cal1 = leer.nextDouble();

        System.out.println("Ingresa tu calificacion II");
        cal2 = leer.nextDouble();

        System.out.println("Ingresa tu calificacion III");
        cal3 = leer.nextDouble();

        System.out.println("Ingresa tu asistencia del 0 al 100:");
        asistencia = leer.nextInt();

        System.out.println("Entrego Proyecto(true false):");
        entrega_proyecto = leer.nextBoolean();

        reporte_final(nombre_usuario,cal1,cal2,cal3,promedio_par,asistencia,entrega_proyecto,calificacion_final);

    }
    public static void reporte_final(String nombre,double par1,double par2,double par3,double prom_par,int asis,boolean entrega_p,double cal_final){
        System.out.println("==============================");
        System.out.println("         REPORTE FINAL        ");
        System.out.println("===============================");

        System.out.println("Nombre:"+nombre);
        System.out.println("Parcial I:"+par1);
        System.out.println("Parcial II:"+par2);
        System.out.println("Parcial III:"+par3);
        System.out.println("Promedio:"+prom_par);
        System.out.println("Asistencia:"+asis);
        System.out.println("Entrego Proyecto Final:"+entrega_p);
        System.out.println("Promedio Final:"+cal_final);
        System.out.println("Estado:");
    }
}