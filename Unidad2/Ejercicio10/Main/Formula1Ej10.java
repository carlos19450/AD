import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Formula1Ej10 {
    public static void main(String[] args) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            Class.forName("org.sqlite.JDBC");
            Path rutaBaseDatos = Path.of("/home/carpui/IdeaProjects/AD/Unidad2/Ejercicio10/db/formula1.db");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());
            String sentenciaSQL =
                    "SELECT Results.Points, Drivers.Name " +
                    "FROM Drivers " +
                            "INNER JOIN Results " +
                            "ON Drivers.DriverID = Results.DriverID ";
            sentencia = conexion.prepareStatement(sentenciaSQL);
            ResultSet resultados = sentencia.executeQuery();
            System.out.println("Puntos\t\t\tNombre");
            System.out.println("----------------------------------------------");
            while (resultados.next()) {
                System.out.println(resultados.getInt("Points") + "\t" + resultados.getString("Name"));
            }
            resultados.close();
            conexion.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}