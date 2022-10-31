import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int opc;
        Map<String, Double> map = new HashMap<>();
        List<Formula1> listaCarreras  = new ArrayList<>();
        List<List<String>> listaRaceResults;
        List<List<String>> listaSprint;
        try (Stream<String> contenidoFichero1 = Files.lines(Paths.get("/home/carpui/IdeaProjects/AD/Unidad1/Ejercicio7/formula1_2021season_raceResults.csv"))) {
            try (Stream<String> contenidoFichero2 = Files.lines(Paths.get("/home/carpui/IdeaProjects/AD/Unidad1/Ejercicio7/formula1_2021season_sprintQualifyingResults.csv"))) {
                listaRaceResults = contenidoFichero1.map(l -> Arrays.asList(l.split(","))).toList();
                listaSprint = contenidoFichero2.map(l -> Arrays.asList(l.split(","))).toList();
                crearOnjetosCarrera(listaRaceResults, listaCarreras);

                System.out.println("1. ¿Qué piloto consiguió más puntos en el campeonato y, por lo tanto, fue campeón del mundo?\n" +
                        "2. ¿Qué escudería se alzó con la victoria en el mundial de constructores?\n" +
                        "3. ¿Qué piloto consiguió más victorias? ¿Y qué equipo?\n" +
                        "4. ¿Qué piloto consiguió subirse más veces al pódium? ¿Y qué equipo?\n" +
                        "5. ¿Qué piloto consiguió hacer más poles? ¿Y qué equipo?\n" +
                        "6. ¿Qué piloto ha hecho más vueltas rápidas en carrera? ¿Y qué equipo?\n" +
                        "7. ¿Qué pilotos han sufrido más abandonos, ya sea en carrera o que no han podido participar?\n" +
                        "8. ¿Cómo ha sido el cara a cara en clasificación y en carrera de los pilotos de la misma escudería?\n");
                opc = sc.nextInt();
                //Opciones del menú
                switch (opc) {
                    case 1 -> {
                        calcularTodosLosPuntosDeUnJugador(map, listaRaceResults, listaSprint);
                        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
                    }
                    case 2 -> {
                        calcularTodosLosPuntosDeUnEquipo(map, listaRaceResults, listaSprint);
                        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
                    }
                    default -> System.out.println("Introduce un numero valido del menú.");
                }
                map.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void crearOnjetosCarrera(List<List<String>> listaRaceResults, List<Formula1> listaCarreras) {
        Formula1 carrera;
        List<String> line;
        for (int i = 1; i < listaRaceResults.size(); i++) {
            line = listaRaceResults.get(i);
            if (line.get(1).equals("NC")) {
                line.set(1, "-1");
            } else if (line.get(1).equals("DQ")) {
                line.set(1, "-2");
            }
            if (line.get(10).equals("N/S")) {
                line.set(10, "-3");
            }
            carrera = new Formula1(line.get(0), parseInt(line.get(1)), parseInt(line.get(2)), line.get(3), line.get(4), parseInt(line.get(5)), parseInt(line.get(6)), line.get(7), parseDouble(line.get(8)), line.get(9), line.get(10));
            listaCarreras.add(carrera);
        }
    }
    public static void calcularTodosLosPuntosDeUnJugador(Map<String, Double> map, List<List<String>> listaRaceResults, List<List<String>> listaSprint) {
        List<String> line;
        for (int i = 1; i < listaRaceResults.size(); i++) {
            line = listaRaceResults.get(i);
            if (map.containsKey(line.get(3))) {
                map.put(line.get(3), map.get(line.get(3)) + parseDouble(line.get(8)));
            }else {
                map.put(line.get(3), parseDouble(line.get(8)));
            }
        }
        for (int i = 1; i < listaSprint.size(); i++) {
            line = listaSprint.get(i);
            if (map.containsKey(line.get(3))) {
                map.put(line.get(3), map.get(line.get(3)) + parseDouble(line.get(8)));
            }else {
                map.put(line.get(3), parseDouble(line.get(8)));
            }
            map.get(line.get(3));
        }
    }
    public static void calcularTodosLosPuntosDeUnEquipo(Map<String, Double> map, List<List<String>> listaRaceResults, List<List<String>> listaSprint) {
        List<String> line;
        for (int i = 1; i < listaRaceResults.size(); i++) {
            line = listaRaceResults.get(i);
            if (map.containsKey(line.get(4))) {
                map.put(line.get(4), map.get(line.get(4)) + parseDouble(line.get(8)));
            }else {
                map.put(line.get(4), parseDouble(line.get(8)));
            }
        }
        for (int i = 1; i < listaSprint.size(); i++) {
            line = listaSprint.get(i);
            if (map.containsKey(line.get(4))) {
                map.put(line.get(4), map.get(line.get(4)) + parseDouble(line.get(8)));
            }else {
                map.put(line.get(4), parseDouble(line.get(8)));
            }
            map.get(line.get(4));
        }
    }
}
