import java.util.Scanner;

public class Principal {
    static Scanner leer = new Scanner(System.in);
    static Persona[] personas = new Persona[20];

    public static void main(String[] args) {
        int opc;

        do {
            System.out.println("\n--- GESTIÓN DE PERSONAS ---");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID");
            System.out.println("0) Salir");
            System.out.print("Elige una opción: ");

            opc = leer.nextInt();
            leer.nextLine();

            switch (opc) {
                case 1: alta(); break;
                case 2: buscar(); break;
                case 3: bajaLogica(); break;
                case 4: listar(); break;
                case 5: actualizar(); break;
                case 0: System.out.println("Saliendo"); break;
                default: System.out.println(">> Opción inválida");
            }
        } while (opc != 0);
    }


    public static void alta() {
        int id, indiceDispo;
        String nombre;
        boolean existe;

        indiceDispo = -1;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                indiceDispo = i;
                break;
            }
        }

        if (indiceDispo == -1) {
            System.out.println("El arreglo está lleno");
            return;
        }

        while (true) {
            System.out.print("Ingrese ID (mayor a 0): ");
            id = leer.nextInt();
            leer.nextLine();

            if (id <= 0) {
                System.out.println("El ID debe ser positivo");
                continue;
            }

            existe = false;
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] != null && personas[i].id == id) {
                    existe = true;
                    break;
                }
            }

            if (existe) {
                System.out.println("Ese ID ya existe");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Ingrese Nombre: ");
            nombre = leer.nextLine();

            if (nombre.trim().isEmpty()) {
                System.out.println("El nombre no puede estar vacío");
            } else {
                break;
            }
        }

        personas[indiceDispo] = new Persona(id, nombre);
        System.out.println("Persona guardada");
    }

    public static void buscar() {
        int id;
        boolean encontrado;

        System.out.print("Ingrese ID a buscar: ");
        id = leer.nextInt();
        encontrado = false;

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].id == id && personas[i].activa) {
                System.out.println("Encontrado: " + personas[i].nombre);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Persona no encontrada o inactiva");
        }
    }

    public static void bajaLogica() {
        int id;
        boolean encontrado;

        System.out.print("Ingrese ID para dar de baja: ");
        id = leer.nextInt();
        encontrado = false;

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].id == id) {
                personas[i].activa = false;
                System.out.println("Baja realizada para: " + personas[i].nombre);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("ID no encontrado.");
        }
    }

    public static void listar() {
        boolean hayGente;

        System.out.println("--- Lista de Personas Activas ---");
        hayGente = false;

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].activa) {
                System.out.println("ID: " + personas[i].id + " Nombre: " + personas[i].nombre);
                hayGente = true;
            }
        }

        if (!hayGente) {
            System.out.println("(No hay personas activas)");
        }
    }

    public static void actualizar() {
        int id;
        String nuevoNombre;
        boolean encontrado;

        System.out.print("Ingrese ID a actualizar: ");
        id = leer.nextInt();
        leer.nextLine();
        encontrado = false;

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].id == id && personas[i].activa) {
                System.out.println("Nombre actual: " + personas[i].nombre);

                while (true) {
                    System.out.print("Ingrese nuevo nombre: ");
                    nuevoNombre = leer.nextLine();
                    if (!nuevoNombre.trim().isEmpty()) break;
                    System.out.println("El nombre no puede estar vacío");
                }

                personas[i].nombre = nuevoNombre;
                System.out.println("Actualización exitosa");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("ID no encontrado o persona inactiva");
        }
    }
}