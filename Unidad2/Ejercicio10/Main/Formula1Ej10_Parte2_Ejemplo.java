import java.nio.file.Path;
import java.sql.*;

public class Formula1Ej10_Parte2_Ejemplo {
    public static void main(String[] args) {

        // URL de la BBDD
        Path rutaBaseDatos = Path.of("/home/carpui/IdeaProjects/AD/Unidad2/Ejercicio10/db/formula1.db");

        // Conexión a la base indicando la URL de la BBDD (en otros casos, URL del servidor, usuario y contraseña)
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString())) {

            // Preparamos una sentencia que lanzaremos a través del PreparedStatement
            String sentenciaSQL = "SELECT DriverID, Name, strftime('%d/%m/%Y', DateOfBirth) AS dob, Team FROM Drivers ORDER BY Name";
            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL);

            // La orden SQL se ejecuta pasándola por el método executeQuery. Si la consulta devuelve datos,
            // estos estarán accesibles a través de un "conjunto de resultados" (ResultSet)
            ResultSet resultados = sentencia.executeQuery();

            // Consumimos los resultados de la consulta
            System.out.format("%2s%20s%16s%20s\n", "Id", "Nombre", "Fecha Nac", "Equipo");
            System.out.println("----------------------------------------------------------");
            // El conjunto de resultados se recorre de forma secuencial: rs.next() será verdadero si hay más datos en el set.
            while (resultados.next()) {
                // Si cada fila del resultado está formada por varios campos, podemos obtener el valor de cada uno de ellos con rs.getString(x),
                // donde x puede ser la posición de la columna (empezando con 1) o el nombre del campo (indiferente de mayúsculas o minúsculas
                // System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
                System.out.format("%2d%20s%16s%20s\n", resultados.getInt("driverid"), resultados.getString("name"),
                        resultados.getString("dob"), resultados.getString("team"));
            }

            // Finalmente, se debe cerrar el ResultSet y la sentencia
            sentencia.close();
            resultados.close();

        } catch ( Exception e ) {
            // Gestionar errores mediante excepciones
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
