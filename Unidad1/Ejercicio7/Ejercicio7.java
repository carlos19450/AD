import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Ejercicio7 {
    public static void main(String[] args) {
        Map<Integer, Double> map = new TreeMap<Integer, Double>();
        Formula1 carrera;
        List<String> line, line2;
        List<Formula1> listaCarreras  = new ArrayList<Formula1>();
        List<List<String>> listaRaceResults;
        List<List<String>> listaRaceResults2;
        try (Stream<String> contenidoFichero1 = Files.lines(Paths.get("C:\\Users\\carlo\\IdeaProjects\\AD\\Unidad1\\Ejercicio7\\formula1_2021season_raceResults.csv"))) {
            try (Stream<String> contenidoFichero2 = Files.lines(Paths.get("C:\\Users\\carlo\\IdeaProjects\\AD\\Unidad1\\Ejercicio7\\formula1_2021season_sprintQualifyingResults.csv"))) {
                listaRaceResults = contenidoFichero1.map(l -> Arrays.asList(l.split(","))).toList();
                listaRaceResults2 = contenidoFichero2.map(l -> Arrays.asList(l.split(","))).toList();
                for (int i = 1; i < listaRaceResults.size(); i++) {
                    line = listaRaceResults.get(i);
                    map.put(parseInt(line.get(2)), parseDouble(line.get(8)));
                }
                for (int i = 1; i < listaRaceResults.size(); i++) {
                    double acumPuntos = 0;
                    line = listaRaceResults.get(i);
                    if (line.get(1).equals("NC")) {
                        line.set(1, "-1");
                    } else if (line.get(1).equals("DQ")) {
                        line.set(1, "-2");
                    }
                    if (line.get(10).equals("N/S")) {
                        line.set(10, "-3");
                    }

                    Iterator<Integer> it = map.keySet().iterator();
                    while(it.hasNext()){
                        Integer key = it.next();
                        if (parseInt(line.get(2)) == key) {
                            System.out.println(key);
                        }
                    }

                    /*for (int j = 1; j < listaRaceResults2.size(); j++) {
                          line2 = listaRaceResults2.get(j);
                          if (line.get(2).equals(line2.get(2))) {
                              float puntosAcum = Float.parseFloat(line.get(8));
                              puntosAcum += Float.parseFloat(line2.get(8));
                              line.set(10, String.valueOf(puntosAcum));
                          }
                    }*/
                    carrera = new Formula1(line.get(0), parseInt(line.get(1)), parseInt(line.get(2)), line.get(3), line.get(4), parseInt(line.get(5)), parseInt(line.get(6)), line.get(7), parseDouble(line.get(8)), line.get(9), line.get(10));
                    //System.out.println(carrera);
                /*listaCarreras.add(carrera);
                for (Formula1 car: listaCarreras) {
                    System.out.println(car);
                } */
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
