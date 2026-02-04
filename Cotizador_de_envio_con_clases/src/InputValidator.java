import  java.util.Scanner;

public class InputValidator {

    public int getValidInt(String message, Scanner sc) {

        double pesoKg=0;
        int distanciaKm;//en rango 1 a 2000
        int tipoServicio; //1) Estándar  2) Express
        boolean esZonaRemota;//true/false

        while(true){
            System.out.println(message);

            //Validar peso
            if(sc.hasNextDouble()){
                pesoKg = sc.nextDouble();
                if(pesoKg>0.1 || pesoKg<50){

                    return pesoKg;
                }
                System.out.println("Peso leido correctamente");
            }else{
                System.out.println("El valor no es numerico");
                sc.nextLine();
            }

            //validar distanciakm
            if(sc.hasNextInt()){
                distanciaKm = sc.nextInt();
                if(distanciaKm>1 || distanciaKm<2000){

                    return distanciaKm;
                }
                System.out.println("Distancia leida correctamente");
            }else{
                System.out.println("El valor no es valido");
                sc.nextLine();
            }

            //validar tipo de servicio
            if(sc.hasNextInt()){
                tipoServicio = sc.nextInt();
                if(tipoServicio==1 ){
                    tipoServicio=50;
                    return tipoServicio;
                }else {
                    if (tipoServicio==2){
                    tipoServicio = 90;
                    }
                }
                System.out.println("Distancia leida correctamente");
            }else{
                System.out.println("El valor no es valido");
                sc.nextLine();
            }

        }

        int estandar = 50;
        int express = 90;
    }
}
