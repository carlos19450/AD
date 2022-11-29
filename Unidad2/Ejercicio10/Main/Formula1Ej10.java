import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Formula1Ej10 {
    public static void main(String[] args) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            Class.forName("org.sqlite.JDBC");
            Path rutaBaseDatos = Path.of("C:\\Users\\carlo\\IdeaProjects\\AD\\Unidad2\\Ejercicio10\\db\\formula1.db");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());
            //Parte 1
            // Ejercicio 1
            System.out.println("Ejercicio 1");
            String sentenciaClasificacionPilotos =
                    "SELECT SUM(Results.Points) AS Puntos, Drivers.Name " +
                            "FROM Drivers " +
                            "INNER JOIN Results " +
                            "ON Drivers.DriverID = Results.DriverID " +
                            "GROUP BY Drivers.Name " +
                            "ORDER BY Results.Points DESC;";
            sentencia = conexion.prepareStatement(sentenciaClasificacionPilotos);
            ResultSet resultadosClasificacionPilotos = sentencia.executeQuery();
            System.out.println("Puntos\t\t\tNombre");
            System.out.println("--------------------");
            while (resultadosClasificacionPilotos.next()) {
                System.out.println(resultadosClasificacionPilotos.getInt("Puntos") + "\t" + resultadosClasificacionPilotos.getString("Name"));
            }
            resultadosClasificacionPilotos.close();
            System.out.println();
            // Ejercicio 2
            System.out.println("Ejercicio 2");
            String sentenciaClasificacionPilotosAnos =
                    "SELECT Name " +
                            "FROM Drivers " +
                            "WHERE strftime(\"%Y\", date('now')) - strftime(\"%Y\", DateOfBirth) > 30 " +
                            "ORDER BY DateOfBirth DESC;";
            sentencia = conexion.prepareStatement(sentenciaClasificacionPilotosAnos);
            ResultSet resultadosClasificacionPilotosAnos  = sentencia.executeQuery();
            System.out.println("Nombre");
            System.out.println("---------------");
            while (resultadosClasificacionPilotosAnos.next()) {
                System.out.println(resultadosClasificacionPilotosAnos.getString("Name"));
            }
            resultadosClasificacionPilotosAnos.close();
            System.out.println();
            // Ejercicio 3
            System.out.println("Ejercicio 3");
            Scanner sc = new Scanner(System.in);
            int edad;
            System.out.print("Introduce el límite de edad mínima de los pilotos a mostrar: ");
            edad = sc.nextInt();
            String sentenciaClasificacionPilotosAnosIntroducidos =
                    "SELECT Name " +
                            "FROM Drivers " +
                            "WHERE strftime(\"%Y\", date('now')) - strftime(\"%Y\", DateOfBirth) > " + edad + " " +
                            "ORDER BY DateOfBirth DESC;";
            sentencia = conexion.prepareStatement(sentenciaClasificacionPilotosAnosIntroducidos);
            ResultSet resultadosClasificacionPilotosAnosIntroducidos = sentencia.executeQuery();
            System.out.println("Nombre");
            System.out.println("------------------------------");
            while (resultadosClasificacionPilotosAnosIntroducidos.next()) {
                System.out.println(resultadosClasificacionPilotosAnosIntroducidos.getString("Name"));
            }
            resultadosClasificacionPilotosAnosIntroducidos.close();
            System.out.println();
            //Crear tabla
            conexion.close();
            System.out.println();
            //Parte 2
            String host = "f12019.ci66saah1axn.us-east-1.rds.amazonaws.com:3306";
            String bbdd = "f1_2019";

            String dbUrl = "jdbc:mariadb://" + host + "/" + bbdd;
            String usuario = "admin";
            String passwd = "aadd1234";

            try (Connection conexionMDB = DriverManager.getConnection(dbUrl, usuario, passwd)) {
                String sentenciaMDB1 =
                        "SELECT SUM(Results.Points) AS Puntos, Drivers.Name " +
                                "FROM Drivers " +
                                "INNER JOIN Results " +
                                "ON Drivers.DriverID = Results.DriverID " +
                                "GROUP BY Drivers.Name " +
                                "ORDER BY Results.Points DESC;";

                PreparedStatement sentenciaMDB = conexionMDB.prepareStatement(sentenciaMDB1);
                ResultSet resultadosMDB1 = sentenciaMDB.executeQuery();

                System.out.format("%2s%20s%16s%20s\n", "Id", "Nombre", "Fecha Nac", "Equipo");
                System.out.println("----------------------------------------------------------");
                while (resultadosMDB1.next()) {
                    System.out.format("%2d%20s%16s%20s\n", resultadosMDB1.getInt("driverid"), resultadosMDB1.getString("name"),
                            resultadosMDB1.getString("dob"), resultadosMDB1.getString("team"));
                }

                sentenciaMDB.close();
                resultadosMDB1.close();

            } catch ( Exception e ) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
