public class PaqueteInternacional extends Paquete{
    public PaqueteInternacional(String nombreDestinatario, double pesoKG)
    {
        super(nombreDestinatario, pesoKG, new EnvioInternacional());
    }
}
