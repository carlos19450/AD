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

public class Ejercicio8 {
    public static void main(String[] args) {
        List<RaceResults> listaCarrera  = new ArrayList<>();
        List<SprintQualifyingResults> listaSprints  = new ArrayList<>();
        List<List<String>> listaRaceResults = leerCSV("C:\\Users\\carlo\\IdeaProjects\\AD\\Unidad1\\Ejercicio7\\formula1_2021season_raceResults.csv");
        List<List<String>> listaSprint = leerCSV("C:\\Users\\carlo\\IdeaProjects\\AD\\Unidad1\\Ejercicio7\\formula1_2021season_sprintQualifyingResults.csv");
        Path nombreFichero = Path.of("/home/carpui/IdeaProjects/AD/Unidad1/Ejercicio8/formula1_2021season_calendar.xml");
        JAXBContext context;

        try {
            context = JAXBContext.newInstance(Calendar.class);
            Unmarshaller jaxbUnmarshaller  = context.createUnmarshaller();

            Calendar cal = (Calendar) jaxbUnmarshaller.unmarshal(nombreFichero.toFile());

            ArrayList<Race> listaRace = cal.getRaces();

            for(Race l: cal.getRaces()){
                System.out.println(l.getRacedate());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static List<List<String>> leerCSV(String ruta) {
        List<List<String>> listacarrera = new ArrayList<>();
        try (Stream<String> contenidoFichero = Files.lines(Paths.get(ruta))) {
                listacarrera = contenidoFichero.map(l -> Arrays.asList(l.split(","))).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listacarrera;
    }
}
