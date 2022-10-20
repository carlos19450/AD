import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Ejercicio7 {
    public static void main(String[] args) {
        Formula1 carrera;
        List<String> line;
        List<List<String>> listaRaceResults = new ArrayList<>();
        try (Stream<String> contenidoFichero1 = Files.lines(Paths.get("/home/carpui/IdeaProjects/AD/Unidad1/Ejercicio7/formula1_2021season_raceResults.csv"))) {
            listaRaceResults = contenidoFichero1.map(l -> Arrays.asList(l.split(","))).toList();
            for (int i = 1; i < listaRaceResults.size(); i++) {
                line = listaRaceResults.get(i);
                carrera = new Formula1(line.get(0), parseInt(line.get(1)), parseInt(line.get(2)), line.get(3), line.get(4), parseInt(line.get(5)), parseInt(line.get(6)), parseInt(line.get(8)));
                System.out.println(line.get(0));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
