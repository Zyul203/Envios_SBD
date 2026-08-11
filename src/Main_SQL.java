import java.util.Scanner;

void main()
{
    Scanner sc = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("\n=== MENÚ DE  ===");
        System.out.println("1. Registrar ");
        System.out.println("2. Eliminar registro ");
        System.out.println("3. Mostrar registros");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opción: ");

        opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1 -> MetodosSQL.CrearPaquete();
            //case 2 -> MetodosSQL.Eliminar_Paquete();
            //case 3 -> MetodosSQL.Mostrar_Paquetes();
            case 4 -> System.out.println("Saliendo del programa...");
            default -> System.out.println("Opción no válida.");
        }
    } while (opcion != 4);




}