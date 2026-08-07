package Modulos;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion
{
    private static String server = "localhost\\SQLEXPRESS";
    private static String database = "Envios_SBD";
    private static String user = "LuisM_poo";
    private static String password = "12345";


    public static String getCadenaConexion()
    {

        return String.format(
                "jdbc:sqlserver://%s;" +
                        "databaseName=%s;" +
                        "user=%s;" +
                        "password=%s;" +
                        "encrypt=true;" +
                        "trustServerCertificate=true;",
                server, database, user, password
        );

    }
    public  static Connection getConexion() throws Exception {
        return DriverManager.getConnection(getCadenaConexion());
    }
}