import java.util.Scanner;

class main{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        EmpresaMensajeria EM = new EmpresaMensajeria();

        int opc, opcEnvio;
        double peso;
        String destinatario, fragil = "";
        boolean repetir = true;

        //Crear los 4 paquetes por defecto
        EM.RegistrarPaquete(new PaqueteC("Luis Alejandro",5, new EnvioEstandar()));
        EM.RegistrarPaquete(new PaqueteC("Gregorio",1, new EnvioExpress()));
        EM.RegistrarPaquete(new PaqueteC("Anthony",6.9, new EnvioInternacional()));
        EM.RegistrarPaquete(new PaqueteC("Luis Manuel",5, new EnvioFragil(new EnvioEstandar())));

        do {
            System.out.println("\n------------------------FEDEX----------------------------");
            System.out.println("1- Ingresar envío");
            System.out.println("2- Imprimir reporte");
            System.out.println("3- Salir");
            System.out.println("--------------------------------------------------------");

            try {
                opc = Integer.parseInt(sc.nextLine());

                switch (opc) {
                    case 1:
                        System.out.println("-------------------------------------------------");
                        System.out.println("¿Que tipo de envío seria?");
                        System.out.println("1- Envío Estándar");
                        System.out.println("2- Envío Express");
                        System.out.println("3- Envío Internacional");
                        System.out.println("4- Salir");
                        System.out.println("-------------------------------------------------");

                        opcEnvio = Integer.parseInt(sc.nextLine());
                        switch (opcEnvio)
                        {
                            case 1:
                                System.out.print("Ingresar nombre de destinatario: ");
                                destinatario = sc.nextLine();
                                System.out.print("Ingresar peso(kg) del paquete: ");
                                peso = Double.parseDouble(sc.nextLine());
                                System.out.print("¿Es un envío frágil? (Y/N): ");
                                fragil = sc.nextLine();

                                if(fragil.equalsIgnoreCase("N"))
                                    EM.RegistrarPaquete(new PaqueteC(destinatario, peso, new EnvioEstandar()));
                                else if (fragil.equalsIgnoreCase("Y"))
                                    EM.RegistrarPaquete(new PaqueteC(destinatario,peso, new EnvioFragil(new EnvioEstandar())));

                                break;

                            case 2:
                                System.out.print("Ingresar nombre de destinatario: ");
                                destinatario = sc.nextLine();
                                System.out.print("Ingresar peso(kg) del paquete: ");
                                peso = Double.parseDouble(sc.nextLine());
                                System.out.print("¿Es un envío frágil? (Y/N): ");
                                fragil = sc.nextLine();

                                if(fragil.equalsIgnoreCase("N"))
                                    EM.RegistrarPaquete(new PaqueteC(destinatario, peso, new EnvioExpress()));
                                else if (fragil.equalsIgnoreCase("Y"))
                                    EM.RegistrarPaquete(new PaqueteC(destinatario,peso, new EnvioFragil(new EnvioExpress())));

                                break;

                            case 3:
                                System.out.print("Ingresar nombre de destinatario: ");
                                destinatario = sc.nextLine();
                                System.out.print("Ingresar peso(kg) del paquete: ");
                                peso = Double.parseDouble(sc.nextLine());
                                System.out.print("¿Es un envío frágil? (Y/N): ");
                                fragil = sc.nextLine();

                                if(fragil.equalsIgnoreCase("N"))
                                    EM.RegistrarPaquete(new PaqueteC(destinatario, peso, new EnvioInternacional()));
                                else if (fragil.equalsIgnoreCase("Y"))
                                    EM.RegistrarPaquete(new PaqueteC(destinatario,peso, new EnvioFragil(new EnvioInternacional())));

                                break;

                            case 4:
                                System.out.println("----------------------------");
                                System.out.println("Regresando al menu principal");
                                System.out.println("----------------------------");
                                break;

                            default:
                                System.out.println("Error: Opcion invalida, pruebe con otra opcion!!!!!");
                                break;
                        }
                        break;

                    case 2:
                        EM.Reporte();
                        break;

                    case 3:
                        System.out.println("Cerrando sistema!!!!!");
                        repetir = false;
                        break;

                    default:
                        System.err.println("Error: Opción invalida, pruebe con otra opción!!!!!\n");
                        break;

                }


            }catch (Exception e) {
                System.err.println("Opción invalida\n");
            }

        }while(repetir);
    }
 }