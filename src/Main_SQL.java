import java.util.Scanner;

void main()
{
    MetodosSQL M = new MetodosSQL();
    Scanner sc = new Scanner(System.in);
    int opcion;
    boolean whileActivo = true;


    do
    {

        System.out.println("\n---------- MENU DE OPCIONES PARA PAQUETES ----------");
        System.out.println("1. Registrar Paquete");
        System.out.println("2. Eliminar Paquete (Por ID)");
        System.out.println("3. Buscar Paquete (Por ID)");
        System.out.println("4. Actualizar Paquete (Por ID)");
        System.out.println("5. Mostrar todos los paquetes");
        System.out.println("6. SALIR");
        System.out.print("\nEscribe tu opción: ");

        try
        {
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion)
            {
                case 1 -> M.Save_Paquete();
                case 2 -> M.DeleteID_Paquete();
                case 3 -> M.FindID_Paquete();
                case 4 -> M.UpdateID_Paquete();
                case 5 -> M.GetAll_Paquete();
                case 6 ->
                {
                    System.out.println("Saliendo del programa...");
                    whileActivo = false;
                }
                default -> System.out.println("Opción inválida...");
            }
        } catch (NumberFormatException e) {
            System.err.println("ERROR - Ingrese un número entero...");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    } while (whileActivo);


}