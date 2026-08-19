import Modulos.SQL.Conexion;
import java.sql.*;

public class RegistroSQL
{

    private int ID;
    private String destinatario;
    private double peso;
    private String tipoEnvio;
    private String regargoExtra;
    private double costo;

    public RegistroSQL(int ID, String destinatario, double peso, String tipoEnvio, String regargoExtra, double costo) {
        this.ID = ID;
        this.destinatario = destinatario;
        this.peso = peso;
        this.tipoEnvio = tipoEnvio;
        this.regargoExtra = regargoExtra;
        this.costo = costo;
    }


    public RegistroSQL(String destinatario, double peso, String tipoEnvio, String regargoExtra, double costo) {
        this.destinatario = destinatario;
        this.peso = peso;
        this.tipoEnvio = tipoEnvio;
        this.regargoExtra = regargoExtra;
        this.costo = costo;
    }

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

            int filasAfectadas = stmt.executeUpdate();
            try(ResultSet rs = stmt.getGeneratedKeys())
            {
                if (rs.next())
                {
                    this.ID = rs.getInt(1);
                }
            }

            return filasAfectadas;
        }
    }


    public int DeleteID() throws Exception
    {
        String sql = "DELETE FROM Envios WHERE ID = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setInt(1,this.ID);

            return stmt.executeUpdate();
        }
    }


    public static RegistroSQL(int ID) throws Exception
    {
        String sql = "SELECT * FROM CuentasSQL WHERE ID = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setInt(1,ID);

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                return new RegistroSQL(
                        rs.getInt("ID"),
                        rs.getString("destinatario"),
                        rs.getInt("peso"),
                        rs.getString("tipoEnvio")
                );
            }
            return null;
        }
    }





    public int getID() {return ID; }
    public void setID(int ID) { this.ID = ID; }

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getTipoEnvio() { return tipoEnvio; }
    public void setTipoEnvio(String tipoEnvio) { this.tipoEnvio = tipoEnvio; }

    public String getRegargoExtra() { return regargoExtra; }
    public void setRegargoExtra(String regargoExtra) { this.regargoExtra = regargoExtra; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
}