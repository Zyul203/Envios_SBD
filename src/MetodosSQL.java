import java.util.List;
import java.util.Scanner;


public class MetodosSQL {
    private static Scanner sc = new Scanner(System.in);


    public static void Save_Paquete()
    {

        EmpresaMensajeria EM = new EmpresaMensajeria();
        int opcEnvio = 0;
        String destinatario, fragil;
        double peso;

        System.out.println("\n--- REGISTRAR ESTACIONAMIENTO ---");

        System.out.println("-------------------------------------------------");
        System.out.println("¿Que tipo de envío seria?");
        System.out.println("1- Envío Estándar");
        System.out.println("2- Envío Express");
        System.out.println("3- Envío Internacional");
        System.out.println("-------------------------------------------------");

        try {
            opcEnvio = Integer.parseInt(sc.nextLine());
            switch (opcEnvio) {
                case 1:
                    System.out.print("Ingresar nombre de destinatario: ");
                    destinatario = sc.nextLine();
                    System.out.print("Ingresar peso(kg) del paquete: ");
                    peso = Double.parseDouble(sc.nextLine());

                    Paquete a = new PaqueteC(destinatario, peso, new EnvioEstandar());
                    PaqueteSQL registroA = new PaqueteSQL();
                    registroA.save(a);
                    break;

                case 2:
                    System.out.print("Ingresar nombre de destinatario: ");
                    destinatario = sc.nextLine();
                    System.out.print("Ingresar peso(kg) del paquete: ");
                    peso = Double.parseDouble(sc.nextLine());

                    Paquete b = new PaqueteC(destinatario, peso, new EnvioExpress());
                    PaqueteSQL registroB = new PaqueteSQL();
                    registroB.save(b);
                    break;

                case 3:
                    System.out.print("Ingresar nombre de destinatario: ");
                    destinatario = sc.nextLine();
                    System.out.print("Ingresar peso(kg) del paquete: ");
                    peso = Double.parseDouble(sc.nextLine());

                    Paquete c = new PaqueteC(destinatario, peso, new EnvioInternacional());
                    PaqueteSQL registroC = new PaqueteSQL();
                    registroC.save(c);
                    break;

                default:
                    System.out.println("Opción invalida");
                    break;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static void DeleteID_Paquete() throws Exception
    {
        System.out.println("\n--- ELIMINAR PAQUETE ---");
        System.out.print("ID: ");
        int ID = Integer.parseInt(sc.nextLine());

        PaqueteSQL p = PaqueteSQL.FindID(ID);
        if (p.DeleteID() == 1)
        {
            System.out.println("Paquete eliminado!");
        }

    }

    public static void UpdateID_Paquete() throws Exception
    {
        System.out.println("\n--- MODIFICAR PAQUETE (ID)---");

        try {
            System.out.print("ID: ");
            int ID = Integer.parseInt(sc.nextLine());
            PaqueteSQL p = PaqueteSQL.FindID(ID);

            System.out.print("DESTINATARIO: ");
            String nombre = sc.nextLine();
            p.setDestinatario(nombre);

            System.out.print("PESO: ");
            Double peso = Double.parseDouble(sc.nextLine());
            p.setPeso(peso);

            p.UpdateID();

        } catch (RuntimeException e) {}

    }


    public static void FindID_Paquete() throws Exception
    {
        System.out.println("\n--- BUSCAR PAQUETE (ID)---");
        System.out.print("ID: ");
        int ID = Integer.parseInt(sc.nextLine());

        PaqueteSQL p = PaqueteSQL.FindID(ID);

        if(p != null)
        {
            System.out.println("Destinatario: " + p.getDestinatario());
            System.out.println("Peso: " + p.getPeso());
            System.out.println("Tipo de envio: " + p.getTipoEnvio());
            System.out.println("Recargo extra: " + p.getRecargoExtra());
            System.out.println("Costo: " + p.getCosto());
        }
    }


    public static void GetAll_Paquete() throws Exception
    {
        System.out.println("\n--- MOSTRAR TODOS LOS PAQUETES---");
        List<PaqueteSQL> lista = PaqueteSQL.GetAll();

        for (PaqueteSQL p : lista)
        {
            System.out.println("Destinatario: " + p.getDestinatario());
            System.out.println("Peso: " + p.getPeso());
            System.out.println("Tipo de envio: " + p.getTipoEnvio());
            System.out.println("Recargo extra: " + p.getRecargoExtra());
            System.out.println("Costo: " + p.getCosto());
            System.out.println("------------------------");
        }
    }









}