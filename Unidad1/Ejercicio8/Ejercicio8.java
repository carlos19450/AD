import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Ejercicio8 {
    public static void main(String[] args) {
        List<TipoCarrera> listaCarreras  = new ArrayList<>();
        List<RaceResults> listaCarreraRaceResult  = new ArrayList<>();
        List<SprintQualifyingResults> listaCarreraSprint  = new ArrayList<>();
        List<List<String>> listaRaceResults = leerCSV("Unidad1\\Ejercicio8\\formula1_2021season_raceResults.csv");
        List<List<String>> listaSprint = leerCSV("Unidad1\\Ejercicio8\\formula1_2021season_sprintQualifyingResults.csv");
        Path nombreFichero = Path.of("C:\\Users\\andra\\IdeaProjects\\AD\\Unidad1\\Ejercicio8\\formula1_2021season_calendar.xml");
        JAXBContext context;

        try {
            context = JAXBContext.newInstance(Calendar.class);
            Unmarshaller jaxbUnmarshaller  = context.createUnmarshaller();
            Calendar cal = (Calendar) jaxbUnmarshaller.unmarshal(nombreFichero.toFile());
            ArrayList<Race> listaRace = cal.getRaces();
            crearListaCarreraRaceResult(listaRaceResults, listaCarreraRaceResult, listaRace);
            crearListaCarreraSprint(listaSprint, listaCarreraSprint, listaRace);
            listaCarreras.addAll(listaCarreraRaceResult);
            listaCarreras.addAll(listaCarreraSprint);
            for (TipoCarrera a : listaCarreras) {
                System.out.println(a);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
    public static void crearListaCarreraRaceResult(List<List<String>> listaRaceResults, List<RaceResults> listaCarreraRaceResult, ArrayList<Race> listaRace) {
        boolean correcto = true;
        List<String> line;
        for (int i = 1; i < listaRaceResults.size(); i++) {
            line = listaRaceResults.get(i);
            if (line.get(1).equals("NC")) {
                line.set(1, "-1");
            } else if (line.get(1).equals("DQ")) {
                line.set(1, "-2");
            }
            if (line.get(10).equals("N/A")) {
                line.set(10, "-3");
            }
            if (line.get(7).equals("DNF")) {
                line.set(7, "-4");
            }
            for (int j = 1; j < listaRace.size() && correcto; j++) {
                if (listaRace.get(j).getGpname().equalsIgnoreCase(line.get(0))) {
                    listaCarreraRaceResult.add(new RaceResults(listaRace.get(i), parseInt(line.get(1)), parseInt(line.get(2)), line.get(3), line.get(4), parseInt(line.get(5)), parseInt(line.get(6)), line.get(7), parseDouble(line.get(8)), line.get(9), line.get(10)));
                    correcto = false;
                }
            }
        }
    }
    public static void crearListaCarreraSprint(List<List<String>> listaSprint, List<SprintQualifyingResults> listaCarreraSprint, ArrayList<Race> listaRace) {
        boolean correcto = true;
        List<String> line;
        for (int i = 1; i < listaSprint.size(); i++) {
            line = listaSprint.get(i);
            if (line.get(1).equals("NC")) {
                line.set(1, "-1");
            } else if (line.get(1).equals("DQ")) {
                line.set(1, "-2");
            }
            for (int j = 1; j < listaRace.size() && correcto; j++) {
                if (listaRace.get(j).getGpname().equalsIgnoreCase(line.get(0))) {
                    listaCarreraSprint.add(new SprintQualifyingResults(listaRace.get(i), parseInt(line.get(1)), parseInt(line.get(2)), line.get(3), line.get(4), parseInt(line.get(5)), parseInt(line.get(6)), line.get(7), parseDouble(line.get(8))));
                    correcto = false;
                }
            }
        }
    }
    private static List<List<String>> leerCSV(String ruta) {
        List<List<String>> listacarrera = new ArrayList<>();
        try (Stream<String> contenidoFichero = Files.lines(Paths.get(ruta))) {
                listacarrera = contenidoFichero.map(l -> Arrays.asList(l.split(","))).toList();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return listacarrera;
    }
}
