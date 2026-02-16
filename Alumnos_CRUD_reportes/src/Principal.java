import java.util.Scanner;

public class Principal {

    static Scanner leer = new Scanner(System.in);
    static Alumno[] alumnos = new Alumno[25];
    static String nombre="";
    static double promedio;

    public static void main(String[] args) {

        int opc;
        do {
            System.out.println("MENÚ:\n" +
                    "1) Alta alumno\n" +
                    "2) Buscar por ID (solo activos)\n" +
                    "3) Actualizar promedio por ID (solo activos)\n" +
                    "4) Baja lógica por ID\n" +
                    "5) Listar activos\n" +
                    "6) Reportes\n" +
                    "0) Salir");
            System.out.println("Eliga una opcion:");
            opc = leer.nextInt();

            switch (opc) {
                case 0: System.out.println("Salio del programa"); break;

                case 1: Alta(); break;

                case 2: BuscarporID(); break;

                case 3: ActualizarporID(); break;

                case 4: BajaporID(); break;

                case 5: Listaractivos(); break;

                case 6: Reportes(); break;

                default: System.out.println("Opcion invalida");
            }
        } while (opc != 0);
    }



    public static void Alta(){
        int id;
        int GuardarAlta = -1;



        double promedio = 0;

        boolean activo = true;
        boolean existe;

        //Buscar un espacio libre

        for (int i = 0; i< alumnos.length; i++){
            if (alumnos[i] == null){
                GuardarAlta=i;
                break;
            }
        }

        if (GuardarAlta == -1){
            System.out.println("no hay lugar para registro");
            return;
        }

        //Registro del id
        while (true){
            System.out.println("Ingresa un numero para el ID mayor a 0:");
            id = leer.nextInt();
            leer.nextLine();

            if (id <= 0) {
                System.out.println("El id debe ser mayor a 0");
                continue;
            }

            //validar el id no se repita

            existe = false;
            for(int i = 0; i < alumnos.length; i++){
                if (alumnos[i] != null && alumnos[i].id == id){
                    existe=true;
                    break;
                }
            }

            if (existe){
                System.out.println("ID repetido");
            }else {
                break;
            }
        }

        //Registro de nombre
        while (true){
            System.out.println("Ingresa tu nombre:");
            nombre = leer.nextLine();

            if (nombre.trim().isEmpty()) {
                System.out.println("El nombre no debe estar vacio");
            }else {
                break;
            }
        }

        while(true){
            System.out.println("Ingresa tu promedio entre 0 y 10 ");

            if (!leer.hasNextDouble()){
                leer.next();
                System.out.println("el valor debe ser numerico");
                continue;
            }

            promedio = leer.nextDouble();


            if (promedio < 0 ||  promedio > 10 ){
                System.out.println("El promedio debe estar entre 0 y 10");
            }else {
                break;
            }
        }

        alumnos[GuardarAlta] = new Alumno(id,nombre,promedio,activo);
        System.out.println("Persona Guardada con exito");

    }

    public static void BuscarporID(){
        int id;
        boolean buscar = false;

        System.out.println("Ingrese un id para buscar:");
        id = leer.nextInt();

        for (int i = 0; i < alumnos.length; i++ ){

            if (alumnos[i] !=null && alumnos[i].id == id && alumnos[i].activo){
                System.out.println("Encontrado: "+alumnos[i].nombre);
                buscar = true;
                break;
            }

            if (!buscar){
                System.out.println("Persona no encontrada o inactiva");
            }
        }

    }

    public static void ActualizarporID(){
        int id;
        int Guardar=0;

        boolean activo=true;
        boolean actualizar=false;
        promedio=0;

        while (true){
            System.out.println("Ingresa un id para actualizar promedio: ");
            id = leer.nextInt();

            for (int i=0; i< alumnos.length;i++){
                if (alumnos[i] != null && alumnos[i].id == id && alumnos[i].activo == true){

                    while(true){
                        System.out.println("Ingresa la nueva calificacion entre 0 y 10: ");
                        if (!leer.hasNextDouble()){
                            leer.next();
                            System.out.println("el valor debe ser numerico");
                            continue;
                        }

                        promedio = leer.nextDouble();


                        if (promedio < 0 ||  promedio > 10 ){
                            System.out.println("El promedio debe estar entre 0 y 10");
                        }else {
                            break;
                        }
                    }

                    promedio = leer.nextDouble();

                    actualizar = true;
                    break;
                }
            }

            if (!actualizar){
                System.out.println("No se encontro id ");
            }else {
                break;
            }
        }
        alumnos[Guardar] = new Alumno(id,nombre,promedio,activo);
        System.out.println("Calificacion actualizada");

    }

    public static void BajaporID(){
        int id;
        boolean bajaID = false;

        System.out.println("Ingresa id para baja");
        id = leer.nextInt();

        for (int i = 0; i < alumnos.length;i++ ){
            if (alumnos[i] != null && alumnos[i].id == id){
                alumnos[i].activo = false;
                System.out.println("Baja realizada: "+ alumnos[i].id);
                bajaID = true;
                break;
            }
        }

        if (!bajaID){
            System.out.println("ID no encontrado");
        }

    }

    public static void Listaractivos(){
       boolean haypersonas=false;

        System.out.println("LISTA DE ALUMNOS");

        for (int i=0; i< alumnos.length; i++ ){
            if (alumnos[i] != null &&  alumnos[i].activo){
                System.out.println("ID: "+alumnos[i].id + " Nombre: "+alumnos[i].nombre+" Promedio: "+alumnos[i].promedio);
                haypersonas = true;
            }
        }

        if (!haypersonas){
            System.out.println("no hay personas");
        }
    }

    public static void Reportes(){

        double promedio_general=0;
        int cant_promocho=0;
        int cantidaddealumnos   =0;

        Alumno promedio_mayor = null;
        Alumno promedio_menor = null;

        for (int i = 0;i< alumnos.length; i++){
            if (alumnos[i] != null && alumnos[i].activo){

                promedio_general += alumnos[i].promedio;
                cantidaddealumnos ++;

                if (alumnos[i].promedio >= 8.0) {
                    cant_promocho++;
                }

                if (promedio_mayor == null || alumnos[i].promedio > promedio_mayor.promedio) {
                    promedio_mayor = alumnos[i];
                }

                if (promedio_menor == null || alumnos[i].promedio < promedio_menor.promedio) {
                    promedio_menor = alumnos[i];
                }
            }


        }
        if (cantidaddealumnos == 0) {
            System.out.println("No hay alumnos activos para generar reportes.");
        } else {
            System.out.println("REPORTES DE ALUMNOS ACTIVOS");
            System.out.printf("Promedio General: %.2f\n", (promedio_general / cantidaddealumnos));
            System.out.println("Cantidad de alumnos con promedio de 8.0: " + cant_promocho);

            if (promedio_mayor != null) {
                System.out.println("Alumno con MAYOR promedio: ID" + promedio_mayor.id +" Nombre: "+ promedio_mayor.nombre + " Promedio: " + promedio_mayor.promedio);
            }

            if (promedio_menor != null) {
                System.out.println("Alumno con MENOR promedio: ID" + promedio_menor.id +" Nombre: "+ promedio_menor.nombre + " Promedio: " + promedio_menor.promedio);
            }
        }

    }
}
