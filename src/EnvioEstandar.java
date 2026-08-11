public class EnvioEstandar implements EstrategiaEnvio
{
    public double calcularCosto(double pesoKg) {
        return (pesoKg * 2.00);
    }
    public boolean esRecargoUnico() { return false; }
    public String nombreTipoEnvio() { return "Envío Estándar";} //#1

}

/* NOTAS
    1. Hay 2 maneras de hacer que la clase EnvioEstandar te devuelva el nombre.
        1) Hacer un metodo para que regrese el tipo en forma de texto en el EnvioEstandar, donde también debes declararla en la interfaz.
        2) Poniendo un ToString en la clase EnvioEstándar
 */