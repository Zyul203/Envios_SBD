public class EnvioFragil implements EstrategiaEnvio
{
    private EstrategiaEnvio estrategiaEnvio;

    public EnvioFragil(EstrategiaEnvio estrategiaEnvio)
    {
        this.estrategiaEnvio = estrategiaEnvio;
    }

    public double calcularCosto(double pesoKg) {
        return (estrategiaEnvio.calcularCosto(pesoKg) + 5.00) ;
    }
    public boolean esRecargoUnico() {
        return true;
    }
    public String nombreTipoEnvio() { return getEstrategiaEnvio().nombreTipoEnvio() + " y " + "Frágil"; }



    public EstrategiaEnvio getEstrategiaEnvio() { return estrategiaEnvio; }
    public void setEstrategiaEnvio(EstrategiaEnvio estrategiaEnvio) { this.estrategiaEnvio = estrategiaEnvio; }
}