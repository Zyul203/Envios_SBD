import java.util.Scanner;


public class MetodosSQL {
    private static Scanner sc = new Scanner(System.in);


    public static void CrearPaquete() {

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
                    RegistroSQL registroA = new RegistroSQL();
                    registroA.save(a);
                    break;

                case 2:
                    System.out.print("Ingresar nombre de destinatario: ");
                    destinatario = sc.nextLine();
                    System.out.print("Ingresar peso(kg) del paquete: ");
                    peso = Double.parseDouble(sc.nextLine());

                    Paquete b = new PaqueteC(destinatario, peso, new EnvioExpress());
                    RegistroSQL registroB = new RegistroSQL();
                    registroB.save(b);
                    break;

                case 3:
                    System.out.print("Ingresar nombre de destinatario: ");
                    destinatario = sc.nextLine();
                    System.out.print("Ingresar peso(kg) del paquete: ");
                    peso = Double.parseDouble(sc.nextLine());

                    Paquete c = new PaqueteC(destinatario, peso, new EnvioInternacional());
                    RegistroSQL registroC = new RegistroSQL();
                    registroC.save(c);
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}