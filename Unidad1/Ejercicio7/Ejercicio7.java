import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Ejercicio7 {
    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        Formula1 carrera = new Formula1();
        List<String> line;
        List<Formula1> listaCarreras  = new ArrayList<>();
        List<List<String>> listaRaceResults;
        List<List<String>> listaRaceResults2;
        try (Stream<String> contenidoFichero1 = Files.lines(Paths.get("/home/carpui/IdeaProjects/AD/Unidad1/Ejercicio7/formula1_2021season_raceResults.csv"))) {
            try (Stream<String> contenidoFichero2 = Files.lines(Paths.get("/home/carpui/IdeaProjects/AD/Unidad1/Ejercicio7/formula1_2021season_sprintQualifyingResults.csv"))) {
                listaRaceResults = contenidoFichero1.map(l -> Arrays.asList(l.split(","))).toList();
                listaRaceResults2 = contenidoFichero2.map(l -> Arrays.asList(l.split(","))).toList();
                for (int i = 1; i < listaRaceResults.size(); i++) {
                    line = listaRaceResults.get(i);
                    if (map.containsKey(line.get(3))) {
                        map.put(line.get(3), map.get(line.get(3)) + parseDouble(line.get(8)));
                    }else {
                        map.put(line.get(3), parseDouble(line.get(8)));
                    }
                }
                for (int i = 1; i < listaRaceResults2.size(); i++) {
                    line = listaRaceResults2.get(i);
                    if (map.containsKey(line.get(3))) {
                        map.put(line.get(3), map.get(line.get(3)) + parseDouble(line.get(8)));
                    }else {
                        map.put(line.get(3), parseDouble(line.get(8)));
                    }
                    map.get(line.get(3));
                }
                for (Map.Entry<String, Double> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + "--" + entry.getValue());
                }
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
                //listaCarreras.forEach(System.out::println);

                //listaCarreras.stream().max(listaCarreras).stream().mapToDouble();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
