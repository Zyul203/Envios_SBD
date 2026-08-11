public class EnvioExpress implements EstrategiaEnvio
{
    public double calcularCosto(double pesoKg) { return ((4.50 * pesoKg) + 3.00); }
    public boolean esRecargoUnico() { return true; }
    public String nombreTipoEnvio() { return "Envío Express"; }

}
