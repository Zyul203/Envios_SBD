public class EnvioInternacional implements EstrategiaEnvio
{
    public double calcularCosto(double pesoKg) { return ((6 * pesoKg) + 10.00); }
    public boolean esRecargoUnico() {
        return true;
    }
    public String nombreTipoEnvio() { return "Envío Internacional"; }
}