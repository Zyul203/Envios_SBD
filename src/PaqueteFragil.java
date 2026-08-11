public class PaqueteFragil extends Paquete{
    public PaqueteFragil(String nombreDestinatario, double pesoKG)
    {
        super(nombreDestinatario, pesoKG, new EnvioFragil());
    }
}
