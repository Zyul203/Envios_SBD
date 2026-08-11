import java.util.ArrayList;

public class EmpresaMensajeria
{
    private ArrayList<Paquete> listaPaquetes;

    public EmpresaMensajeria() { this.listaPaquetes = new ArrayList<>(); }


    public void RegistrarPaquete(Paquete paquete)
    {
        listaPaquetes.add(paquete);
        System.out.println("✔ Paquete registrado");
    }

    public void Reporte()
    {
        double montoTotal = 0;
        if (listaPaquetes.isEmpty())
        {
            System.out.println("No hay paquetes registrados en la empresa");
            return;
        }

        System.out.println("\n---------------------------------------------------------------------------------------------------------");
        System.out.printf("%-35s | %-10s | %-30s | %-20s | %-10s \n", "Destinatario", "Peso (kg)","Tipo de envío","¿Recargo Unico/Fijo?", "Costo");
        System.out.println("----------------------------------------------------------------------------------------------------------");

        for (Paquete p: listaPaquetes)
        {
            System.out.printf("%-35s | %-10s | %-30s | %-20s | $%-10.2f\n",
            p.getNombreDestinatario(),
            p.getPesoKG(),
            p.getEstrategiaEnvio().nombreTipoEnvio(),
            p.getEstrategiaEnvio().esRecargoUnico(),
            p.obtenerCostoEnvio());

            montoTotal += p.obtenerCostoEnvio();
        }

        System.out.println("\nEl dinero total recaudado es de $" + montoTotal);
    }


    public ArrayList<Paquete> getListaPaquetes() { return listaPaquetes; }
    public void setListaPaquetes(ArrayList<Paquete> listaPaquetes) { this.listaPaquetes = listaPaquetes; }
}
