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
            String sentenciaClasificacionPilotos = """
                    SELECT SUM(Results.Points) AS Puntos, Drivers.Name
                            FROM Drivers
                            INNER JOIN Results
                            ON Drivers.DriverID = Results.DriverID
                            GROUP BY Drivers.Name
                            ORDER BY Results.Points DESC""";
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
            String sentenciaClasificacionPilotosAnos = """
                    SELECT Name, strftime("%Y", date('now')) - strftime("%Y", DateOfBirth) AS year
                            FROM Drivers
                            WHERE year > 30
                            ORDER BY year DESC""";
            sentencia = conexion.prepareStatement(sentenciaClasificacionPilotosAnos);
            ResultSet resultadosClasificacionPilotosAnos  = sentencia.executeQuery();
            System.out.println("Nombre\t\t\tAños");
            System.out.println("---------------------");
            while (resultadosClasificacionPilotosAnos.next()) {
                System.out.println(resultadosClasificacionPilotosAnos.getString("Name") + "\t\t" + resultadosClasificacionPilotosAnos.getInt("year"));
            }
            resultadosClasificacionPilotosAnos.close();
            System.out.println();

            // Ejercicio 3
            System.out.println("Ejercicio 3");
            Scanner sc = new Scanner(System.in);
            int edad;
            System.out.print("Introduce el límite de edad mínima de los pilotos a mostrar: ");
            edad = sc.nextInt();
            String sentenciaClasificacionPilotosAnosIntroducidos = """
                    SELECT Name, strftime("%Y", date('now')) - strftime("%Y", DateOfBirth) AS year
                            FROM Drivers
                            WHERE year > + edad +
                            ORDER BY year DESC""";
            sentencia = conexion.prepareStatement(sentenciaClasificacionPilotosAnosIntroducidos);
            ResultSet resultadosClasificacionPilotosAnosIntroducidos = sentencia.executeQuery();
            System.out.println("Nombre\t\t\tAños");
            System.out.println("---------------------");
            while (resultadosClasificacionPilotosAnosIntroducidos.next()) {
                System.out.println(resultadosClasificacionPilotosAnosIntroducidos.getString("Name") + "\t\t" + resultadosClasificacionPilotosAnosIntroducidos.getInt("year"));
            }
            resultadosClasificacionPilotosAnosIntroducidos.close();
            System.out.println();

            //Crear tabla
            String crearTablaTeams = """
                    CREATE TABLE IF NOT EXISTS Teams (
                    Constructor TEXT NOT NULL,
                    Chassis TEXT NOT NULL,
                    PowerUnit TEXT NOT NULL,
                    PRIMARY KEY ( Constructor ))""";
            String borrarDatosTabla = """
                    DELETE FROM Teams""";
            String introducirDatosTeams = """
                    INSERT INTO Teams VALUES
                    ('Alfa Romeo Racing-Ferrari', 'C38', 'Ferrari 064'),
                    ('Ferrari', 'SF90', 'Ferrari 064'),
                    ('Haas-Ferrari', 'VF-19', 'Ferrari 064'),
                    ('McLaren-Renault', 'MCL34', 'Renault E-Tech 19'),
                    ('Mercedes', 'F1 W10 EQ Power+', 'Mercedes M10 EQ Power+'),
                    ('Racing Point-BWT Mercedes', 'RP19', 'BWT Mercedes'),
                    ('Red Bull Racing-Honda', 'RB15', 'Honda RA619H'),
                    ('Renault', 'R.S.19', 'Renault E-Tech 19'),
                    ('Scuderia Toro Rosso-Honda', 'STR14', 'Honda RA619H'),
                    ('Williams-Mercedes', 'FW42', 'Mercedes M10 EQ Power+')""";
            sentencia = conexion.prepareStatement(crearTablaTeams);
            sentencia.executeUpdate();
            sentencia = conexion.prepareStatement(borrarDatosTabla);
            sentencia.executeUpdate();
            sentencia = conexion.prepareStatement(introducirDatosTeams);
            sentencia.executeUpdate();
            conexion.close();
            System.out.println();
            //Parte 2
            String host = "f12019.ci66saah1axn.us-east-1.rds.amazonaws.com:3306";
            String bbdd = "f1_2019";

            String dbUrl = "jdbc:mariadb://" + host + "/" + bbdd;
            String usuario = "admin";
            String passwd = "aadd1234";

            try (Connection conexionMDB = DriverManager.getConnection(dbUrl, usuario, passwd)) {
                String sentenciaMDB1 = """
                        SELECT SUM(Results.Points) AS Puntos, Drivers.Name
                                FROM Drivers
                                INNER JOIN Results
                                ON Drivers.DriverID = Results.DriverID
                                GROUP BY Drivers.Name
                                ORDER BY Results.Points DESC""";

                PreparedStatement sentenciaMDB = conexionMDB.prepareStatement(sentenciaMDB1);
                ResultSet resultadosMDB1 = sentenciaMDB.executeQuery();

                System.out.println("Puntos\t\t\tNombre");
                System.out.println("--------------------");
                while (resultadosMDB1.next()) {
                    System.out.println(resultadosMDB1.getInt("Puntos") + "\t" + resultadosMDB1.getString("Name"));
                }
                resultadosMDB1.close();
                String sentenciaMDB2 = """
                        SELECT Name, strftime("%Y", date('now')) - strftime("%Y", DateOfBirth) AS year
                                FROM Drivers
                                WHERE year > 30
                                ORDER BY year DESC""";
                sentenciaMDB = conexionMDB.prepareStatement(sentenciaMDB2);
                ResultSet resultadosMDB2 = sentenciaMDB.executeQuery();

                System.out.println("Nombre\t\t\tAños");
                System.out.println("---------------------");
                while (resultadosMDB2.next()) {
                    System.out.println(resultadosMDB2.getString("Name") + "\t\t" + resultadosMDB2.getInt("year"));
                }
                resultadosMDB2.close();
                sentenciaMDB.close();
            }
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
