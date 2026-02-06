import java.util.Scanner;
public class ActividadSwitchCalculadora {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;
        double a = 0;
        double b = 0;
        double  resultado = 0;

        System.out.println("=====Menu=====\n");
        System.out.println("1) Sumar\n" +
                           "2) Restar\n" +
                           "3) Multiplicar\n" +
                           "4) Dividir\n" +
                           "Elije una opción: ");

        opcion = leer.nextInt();

        switch (opcion){
            case 1:

                System.out.println("ingresa el primer numero");
                a = leer.nextDouble();

                System.out.println("ingresa el segundo numero");
                b = leer.nextDouble();

                resultado=a+b;

                System.out.printf("valor 1: "+a+"\n");
                System.out.printf("valor 2: "+b+"\n");
                System.out.printf(a+" + "+b + " = "+resultado+"\n");
                System.out.println("el resultado es: "+resultado+"\n");
                System.out.println("operación elejida SUMA");


            break;

            case 2:
                System.out.println("ingresa el primer numero");
                a = leer.nextDouble();

                System.out.println("ingresa el segundo numero");
                b = leer.nextDouble();

                resultado=a-b;

                System.out.printf("valor 1: "+a+"\n");
                System.out.printf("valor 2: "+b+"\n");
                System.out.printf(a+" - "+b + " = "+resultado+"\n");
                System.out.println("el resultado es: "+resultado+"\n");
                System.out.println("operación elejida RESTA");

            break;

            case 3:
                System.out.println("ingresa el primer numero");
                a = leer.nextDouble();

                System.out.println("ingresa el segundo numero");
                b = leer.nextDouble();

                resultado=a*b;

                System.out.printf("valor 1: "+a+"\n");
                System.out.printf("valor 2: "+b+"\n");
                System.out.printf(a+" * "+b + " = "+resultado+"\n");
                System.out.println("el resultado es: "+resultado+"\n");
                System.out.println("operación elejida MULTIPLICACIÓN");

            break;

            case 4:
                System.out.println("ingresa el primer numero");
                a = leer.nextDouble();

                System.out.println("ingresa el segundo numero");
                b = leer.nextDouble();
                if (b==0){
                    System.out.println( "No se puede dividir entre cero");
                }else{
                    resultado=a/b;

                    System.out.printf("valor 1: "+a+"\n");
                    System.out.printf("valor 2: "+b+"\n");
                    System.out.printf(a+" / "+b + " = "+resultado+"\n");
                    System.out.println("el resultado es: "+resultado+"\n");
                    System.out.println("operación elejida DIVISIÓN");
                }

            break;

            default:
                System.out.println( "Opción inválida");
        }
    }
}
