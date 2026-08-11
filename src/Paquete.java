public abstract class Paquete
{
    private String nombreDestinatario;
    private double pesoKG;
    private EstrategiaEnvio estrategiaEnvio;

    public Paquete(String nombreDestinatario, double pesoKG, EstrategiaEnvio estrategiaEnvio)
    {
        if (pesoKG <= 0)
        {
            throw new IllegalArgumentException("El peso debe de ser mayor a 0...");
        }

        this.nombreDestinatario = nombreDestinatario;
        this.pesoKG = pesoKG;
        this.estrategiaEnvio = estrategiaEnvio;
    }

    public double obtenerCostoEnvio()
    {
       return estrategiaEnvio.calcularCosto(pesoKG);
    }


    public String getNombreDestinatario() { return nombreDestinatario; }
    public void setNombreDestinatario(String nombreDestinatario) { this.nombreDestinatario = nombreDestinatario; }

    public double getPesoKG() { return pesoKG; }
    public void setPesoKG(double pesoKG) { this.pesoKG = pesoKG; }

    public EstrategiaEnvio getEstrategiaEnvio() { return estrategiaEnvio; }
    public void setEstrategiaEnvio(EstrategiaEnvio estrategiaEnvio) { this.estrategiaEnvio = estrategiaEnvio; }
}
