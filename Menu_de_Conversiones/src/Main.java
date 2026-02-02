import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int opc;
        double grados_c;
        double grados_f;
        double km;
        double millas;

        int total_conversiones;
        int cont_c=0;
        int cont_f=0;
        int cont_km=0;
        int cont_milla=0;

        do {
            System.out.println("Menú de Conversiones\n" +
                    "1) °C a °F\n" +
                    "2) °F a °C\n" +
                    "3) Km a Millas\n" +
                    "4) Millas a Km\n" +
                    "5) Salir");

                System.out.println("Elija su opción:");
                opc = validarint(leer);


            switch (opc){
                case 1:
                    System.out.println("Ingresa los °C que quieres convertir a °F:");
                    grados_c = validar(leer);
                    grados_f = (grados_c*1.8)+32;
                    System.out.println("°F:"+grados_f);
                    cont_c++;
                break;

                case 2:
                    System.out.println("Ingresa los °F que quieres convertir a °C:");
                    grados_f = validar(leer);
                    grados_c = (grados_f-32)/1.8;
                    System.out.println("°C:"+grados_c);
                    cont_f++;
                break;

                case 3:
                        System.out.printf("Ingresa Km que quieres convertir a Millas:");
                        km = validar(leer);
                        millas = km / 1.60934;
                        System.out.println("Millas:"+millas);
                        cont_km++;

                break;

                case 4:
                    System.out.printf("Ingresa las Millas que quieres convertir a Km:");
                    millas = validar(leer);
                    km = millas*1.06934;
                    System.out.println("Kilometros:"+km);
                    cont_milla++;

                break;

                case 5:
                    System.out.printf("Has salido del programa");

                break;

                default:
                    System.out.println("Seleccion no Valida");
                    break;
            }
        }while (opc != 5);

        total_conversiones=cont_f+cont_c+cont_km+cont_milla;
        System.out.println("se hicieron : "+total_conversiones+" converisones\n");
        System.out.printf("se hicieron: "+cont_c+" de celcius a farenheit\n");
        System.out.printf("se hicieron: "+cont_f+" de farenheit a celcius\n");
        System.out.println("se hicieron: " + cont_km+" de kilometro a milla");
        System.out.printf("se hicieron: "+cont_milla+" de millla a kilometro\n");
    }


    public static double validar(Scanner leer) {
        while (!leer.hasNextDouble()) {
            System.out.println("Ingresa un dato numérico válido");
            leer.next();
        }
        return leer.nextDouble();
    }

    public static int validarint(Scanner leer) {
        while (!leer.hasNextInt()) {
            System.out.println("!!!Ingresa un dato numérico válido!!!\n");
            System.out.println("Menú de Conversiones\n" +
                    "1) °C a °F\n" +
                    "2) °F a °C\n" +
                    "3) Km a Millas\n" +
                    "4) Millas a Km\n" +
                    "5) Salir");

            System.out.println("Elija su opción:");
            leer.next();
        }
        return leer.nextInt();
    }

}