import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Formula1Ej10_Anyadir_Tabla {
    public static void main(String[] args) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            Class.forName("org.sqlite.JDBC");
            Path rutaBaseDatos = Path.of("/home/carpui/IdeaProjects/AD/Unidad2/Ejercicio10/db/formula1.db");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());
            String sentenciaSQL =
                    "CREATE TABLE Teams(" +
                            "Constructor text primary key," +
                            "Chassis text," +
                            "PowerUnit text" +
                            ");";
            sentencia = conexion.prepareStatement(sentenciaSQL);
            ResultSet resultados = sentencia.executeQuery();
            resultados.close();
            conexion.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}

