import Modulos.SQL.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaqueteSQL
{
    private int ID;
    private String destinatario;
    private double peso;
    private String tipoEnvio;
    private String recargoExtra;
    private double costo;

    public PaqueteSQL(int ID, String destinatario, double peso, String tipoEnvio, String recargoExtra, double costo) {
        this.ID = ID;
        this.destinatario = destinatario;
        this.peso = peso;
        this.tipoEnvio = tipoEnvio;
        this.recargoExtra = recargoExtra;
        this.costo = costo;
    }


    public PaqueteSQL(String destinatario, double peso, String tipoEnvio, String recargoExtra, double costo) {
        this.destinatario = destinatario;
        this.peso = peso;
        this.tipoEnvio = tipoEnvio;
        this.recargoExtra = recargoExtra;
        this.costo = costo;
    }

    public PaqueteSQL() {}

    public int save(Paquete paquete) throws Exception
    {
        String sql = "INSERT INTO PaqueteSQL (destinatario, peso, tipoEnvio, recargoExtra, costo) VALUES (?,?,?,?,?)";

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
        String sql = "DELETE FROM PaqueteSQL WHERE ID = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setInt(1,this.ID);

            return stmt.executeUpdate();
        }
    }


    public static PaqueteSQL FindID(int ID) throws Exception
    {
        String sql = "SELECT * FROM PaqueteSQL WHERE ID = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setInt(1,ID);

            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                return new PaqueteSQL(
                        rs.getInt("ID"),
                        rs.getString("destinatario"),
                        rs.getInt("peso"),
                        rs.getString("tipoEnvio"),
                        rs.getString("recargoExtra"),
                        rs.getDouble("costo"));
            }
            return null;
        }
    }

    public int UpdateID() throws Exception
    {
        String sql = "UPDATE PaqueteSQL SET destinatario = ?, peso = ? WHERE ID = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setString(1,this.destinatario);
            stmt.setDouble(2,this.peso);
            stmt.setInt(3,this.ID);

            return stmt.executeUpdate();
        }
    }

    public static List<PaqueteSQL> GetAll() throws Exception
    {
        List<PaqueteSQL> lista = new ArrayList<>();
        String sql = "SELECT * FROM PaqueteSQL";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql))
        {

            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                lista.add(new PaqueteSQL(
                        rs.getInt("ID"),
                        rs.getString("destinatario"),
                        rs.getDouble("peso"),
                        rs.getString("tipoEnvio"),
                        rs.getString("recargoExtra"),
                        rs.getDouble("costo"))
                );
            }
        }
        return lista;
    }

    public int getID() {return ID; }
    public void setID(int ID) { this.ID = ID; }

    public String getDestinatario() { return destinatario; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getTipoEnvio() { return tipoEnvio; }
    public void setTipoEnvio(String tipoEnvio) { this.tipoEnvio = tipoEnvio; }

    public String getRecargoExtra() { return recargoExtra; }
    public void setRecargoExtra(String recargoExtra) { this.recargoExtra = recargoExtra; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
}