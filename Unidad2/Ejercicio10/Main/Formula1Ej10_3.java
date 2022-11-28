import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Formula1Ej10_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            System.out.print("Introduce el límite de edad mínima de los pilotos a mostrar: ");
            edad = sc.nextInt();
            Class.forName("org.sqlite.JDBC");
            Path rutaBaseDatos = Path.of("/home/carpui/IdeaProjects/AD/Unidad2/Ejercicio10/db/formula1.db");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());
            String sentenciaSQL =
                    "SELECT Name " +
                            "FROM Drivers " +
                            "WHERE strftime(\"%Y\", date('now')) - strftime(\"%Y\", DateOfBirth) > " + edad + " " +
                            "ORDER BY DateOfBirth DESC;";
            sentencia = conexion.prepareStatement(sentenciaSQL);
            ResultSet resultados = sentencia.executeQuery();
            System.out.println("Nombre");
            System.out.println("----------------------------------------------");
            while (resultados.next()) {
                System.out.println(resultados.getString("Name"));
            }
            resultados.close();
            conexion.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}