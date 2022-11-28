import java.nio.file.Path;
import java.sql.*;

public class Formula1Ej10_Parte2 {
    public static void main(String[] args) {
        // BBDD MariaDB
        // Descargar org.mariadb.jdbc:mariadb-java-client:3.1.0
        // URL de la BBDD (con el puerto de escucha de MariaDB -> 3306)
        String host = "f12019.ci66saah1axn.us-east-1.rds.amazonaws.com:3306";
        String bbdd = "f1_2019";

        String dbUrl = "jdbc:mariadb://" + host + "/" + bbdd;
        String usuario = "admin";
        String passwd = "aadd1234";

        // Conexión a la base indicando la URL de la BBDD (en otros casos, URL del servidor, usuario y contraseña)
        try (Connection conexion = DriverManager.getConnection(dbUrl, usuario, passwd)) {
            String sentenciaSQL = """
                                    SELECT DriverID, Name, date_format(DateOfBirth, '%d/%c/%Y') AS dob, Team
                                    FROM Drivers
                                    ORDER BY Name""";

            PreparedStatement sentencia = conexion.prepareStatement(sentenciaSQL);
            ResultSet resultados = sentencia.executeQuery();

            System.out.format("%2s%20s%16s%20s\n", "Id", "Nombre", "Fecha Nac", "Equipo");
            System.out.println("----------------------------------------------------------");
            while (resultados.next()) {
                System.out.format("%2d%20s%16s%20s\n", resultados.getInt("driverid"), resultados.getString("name"),
                        resultados.getString("dob"), resultados.getString("team"));
            }

            sentencia.close();
            resultados.close();

        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
