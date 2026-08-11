public interface EstrategiaEnvio
{
    double calcularCosto(double pesoKg);
    boolean esRecargoUnico(); //#1
    String nombreTipoEnvio();
}

/* NOTAS

1. El recargo único no lleva parámetro, ya que es una propiedad fija.
    Mientras que el pesoKg varía dependiendo del que le asigne el usuario

 */