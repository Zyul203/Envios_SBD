import Modulos.SQL.Conexion;
import java.sql.*;

public class RegistroSQL
{

    public RegistroSQL() {}

    public int save(Paquete paquete) throws Exception
    {
        String sql = "INSERT INTO Envios (destinatario, peso, tipoEnvio, recargoExtra, costo) VALUES (?,?,?,?,?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            stmt.setString(1, paquete.getNombreDestinatario());
            stmt.setDouble(2, paquete.getPesoKG());
            stmt.setString(3, paquete.getEstrategiaEnvio().nombreTipoEnvio());
            stmt.setString(4, paquete.getEstrategiaEnvio().esRecargoUnico()?"SI":"NO");
            stmt.setDouble(5, paquete.obtenerCostoEnvio());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            return stmt.executeUpdate();
        }
    }


    public static int deletebyId(int id) throws Exception
    {
        try( Connection con= Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement("DELETE FROM Envios where id = ?");
        ) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }
    }


}

/*

1. Convertir de bolean a texto
    Opción 1: Convertir a texto "true" o "false" (La más directa)
        Usa String.valueOf() para transformar el booleano en texto directamente: String.valueOf(paquete.getEstrategiaEnvio().esRecargoUnico())
    Opción 2: Guardar un texto personalizado
        Si prefieres que quede registrado por ejemplo con un "SI" o "NO" se usa el operador ternario ?: : paquete.getEstrategiaEnvio().esRecargoUnico() ? "SI" : "NO"
        (Si esRecargoUnico() es verdadero guardará "SI", de lo contrario guardará "NO").
 */