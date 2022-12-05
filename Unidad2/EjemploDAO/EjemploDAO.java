import dao.sql.SQLiteDAOManagerImpl;
import models.Circuito;
import models.Escuderia;
import models.Piloto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EjemploDAO {
    public static void main(String[] args) {

            SQLiteDAOManagerImpl mundial = new SQLiteDAOManagerImpl();
            // Teams
            /*System.out.println("\nMostrar todas las escuderias");
            System.out.println("-------------------------------");
            mundial.getEscuderiaDAO().findAll().forEach(System.out::println);

            System.out.println("\nMostrar solo una escuderia");
            System.out.println("-------------------------------");
            System.out.println(mundial.getEscuderiaDAO().findById("Mercedes"));

            System.out.println("\nInsertar una escudería");
            System.out.println("-------------------------------");
            Escuderia seat = new Escuderia("Seat", "Seat-2019", "Seat 4 Latas");
            mundial.getEscuderiaDAO().save(seat);
            mundial.getEscuderiaDAO().findAll().forEach(System.out::println);

            System.out.println("\nActualizar una escudería");
            System.out.println("-------------------------------");
            seat.setChasis("Seat-2023");
            seat.setMotor("Seat TDI 2.0");
            mundial.getEscuderiaDAO().update(seat);
            mundial.getEscuderiaDAO().findAll().forEach(System.out::println);

            System.out.println("\nBorrar una escudería");
            System.out.println("-------------------------------");
            mundial.getEscuderiaDAO().deleteById("Seat");
            mundial.getEscuderiaDAO().findAll().forEach(System.out::println);*/

            // Drivers
            /*System.out.println("\nMostrar todos Pilotos");
            System.out.println("-------------------------------");
            mundial.getPilotoDAO().findAll().forEach(System.out::println);

            System.out.println("\nMostrar solo un Piloto");
            System.out.println("-------------------------------");
            System.out.println(mundial.getPilotoDAO().findById(3));

            System.out.println("\nInsertar un Piloto");
            System.out.println("-------------------------------");
            Piloto piloto = new Piloto("Carlos Exposito", 100, new Escuderia("Renault", "Clio-19", "Clio M10 064"), LocalDate.parse("1999-8-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            System.out.println(piloto);
            mundial.getPilotoDAO().save(piloto);
            mundial.getPilotoDAO().findAll().forEach(System.out::println);

            System.out.println("\nActualizar un Piloto");
            System.out.println("-------------------------------");
            pil.setNombre("Federico Garcia");
            pil.setEquipo(new Escuderia("Paco", "Paco-2930", "Paco 3423234"));
            pil.setFechaNacimiento(LocalDate.now());
            mundial.getPilotoDAO().update(pil);
            mundial.getPilotoDAO().findAll().forEach(System.out::println);

            System.out.println("\nBorrar un piloto");
            System.out.println("-------------------------------");
            mundial.getPilotoDAO().deleteById(21);
            mundial.getPilotoDAO().findAll().forEach(System.out::println);*/

            // Tracks
            System.out.println("\nMostrar todas los circuitos");
            System.out.println("-------------------------------");
            mundial.getCircuitoDAO().findAll().forEach(System.out::println);

            System.out.println("\nMostrar solo un circuito");
            System.out.println("-------------------------------");
            System.out.println(mundial.getCircuitoDAO().findById(7));

            System.out.println("\nInsertar un circuito");
            System.out.println("-------------------------------");
            Circuito circuito = new Circuito(22, "España", LocalDate.parse("2020-12-07 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            mundial.getCircuitoDAO().save(circuito);
            mundial.getCircuitoDAO().findAll().forEach(System.out::println);

            System.out.println("\nActualizar un circuito");
            System.out.println("-------------------------------");
            circuito.setPais("Alemania");
            circuito.setFecha(LocalDate.now());
            mundial.getCircuitoDAO().update(circuito);
            mundial.getCircuitoDAO().findAll().forEach(System.out::println);

            System.out.println("\nBorrar un circuito");
            System.out.println("-------------------------------");
            mundial.getCircuitoDAO().deleteById(22);
            mundial.getCircuitoDAO().findAll().forEach(System.out::println);
            mundial.close();
    }
}
