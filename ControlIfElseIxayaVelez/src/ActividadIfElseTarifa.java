import java.util.Scanner;
public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int edad;
        int tarifa=0;
        boolean esEstudiante=false;

        System.out.println("Ingresa tu Edad:");
        edad = leer.nextInt();

        if (edad <= 0 || edad > 120){
            System.out.printf("Edad inválida");

        } else {
            if (edad < 12) {
                System.out.println("tarifa 50");
                tarifa=50;
            } else {

                System.out.println("Eres estudiante escribe \n" +
                        "true  = si \n" +
                        "false = no ");
                esEstudiante = leer.nextBoolean();


                if (esEstudiante == true) {
                    if (edad < 17) {
                        System.out.println("tarifa =60");
                        tarifa=60;
                    } else {
                        System.out.println("tarifa 90");
                        tarifa=90;
                    }

                } else {
                    if (edad < 17) {
                        System.out.println("tarifa =80");
                        tarifa=80;
                    } else {
                        System.out.println("tarifa 120");
                        tarifa=120;
                    }
                }
            }
        }
        System.out.println("Edad ingresada: " + edad);
        if (esEstudiante == true){
            System.out.println("Es estudiante: si");
        }else {
            System.out.println("Es estudiante: no");
        }
        System.out.println("Tarifa final: " + tarifa);
    }
}