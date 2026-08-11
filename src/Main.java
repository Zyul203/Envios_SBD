import java.util.Scanner;

class main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        EmpresaMensajeria mensajeria = new EmpresaMensajeria();
        int opc, opcEnvio;
        double peso;
        String destinatario;
        boolean repetir = true;

        mensajeria.AñadirPaquete(new PaqueteEstandar("Luis Alejandro",15.5));
        mensajeria.AñadirPaquete(new PaqueteExpress("Gregorio",10.3));
        mensajeria.AñadirPaquete(new PaqueteInternacional("Anthony",6.9));
        mensajeria.AñadirPaquete(new PaqueteFragil("Diego Alessandro",8.2));

        do {
            System.out.println("------------------------FEDEX----------------------------");
            System.out.println("1- Ingresar envío");
            System.out.println("2- Imprimir reporte");
            System.out.println("3- Salir");
            System.out.println("--------------------------------------------------------");

            try {
                opc = sc.nextInt();

                switch (opc) {
                    case 1:
                        System.out.println("-------------------------------------------------");
                        System.out.println("¿Que tipo de envio seria?");
                        System.out.println("1- Envio Estandar");
                        System.out.println("2- Envio Express");
                        System.out.println("3- Envio Internacional");
                        System.out.println("4- Envio Fragil");
                        System.out.println("5- Salir");
                        System.out.println("-------------------------------------------------");

                        opcEnvio = sc.nextInt();
                        switch (opcEnvio) {
                            case 1:
                                System.out.println("Ingresar nombre de destinatario");
                                destinatario = sc.next();
                                System.out.println("Ingresar peso(kg) del paquete");
                                peso = sc.nextDouble();

                                mensajeria.AñadirPaquete(new PaqueteEstandar(destinatario, peso));
                                System.out.println("Se ingreso correctamente el paquete");
                                break;

                            case 2:
                                System.out.println("Ingresar nombre de destinatario");
                                destinatario = sc.next();
                                System.out.println("Ingresar peso(kg) del paquete");
                                peso = sc.nextDouble();

                                mensajeria.AñadirPaquete(new PaqueteExpress(destinatario, peso));
                                System.out.println("Se ingreso correctamente el paquete");
                                break;

                            case 3:
                                System.out.println("Ingresar nombre de destinatario");
                                destinatario = sc.next();
                                System.out.println("Ingresar peso(kg) del paquete");
                                peso = sc.nextDouble();

                                mensajeria.AñadirPaquete(new PaqueteInternacional(destinatario, peso));
                                System.out.println("Se ingreso correctamente el paquete");
                                break;

                            case 4:
                                System.out.println("Ingresar nombre de destinatario");
                                destinatario = sc.next();
                                System.out.println("Ingresar peso(kg) del paquete");
                                peso = sc.nextDouble();

                                mensajeria.AñadirPaquete(new PaqueteFragil(destinatario, peso));
                                System.out.println("Se ingreso correctamente el paquete");
                                break;

                            case 5:
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
                        mensajeria.Reporte();
                        break;

                    case 3:
                        System.out.println("Cerrando sistema!!!!!");
                        repetir = false;
                        break;

                    default:
                        System.out.println("Error: Opcion invalida, pruebe con otra opcion!!!!!");
                        break;

                }


            }catch (Exception e) {
                System.out.println("-----------------");
                System.out.println("Opcion invalida");
                System.out.println("-----------------");
                sc.nextLine();
            }

        }while(repetir);
    }
 }