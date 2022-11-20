import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Ejercicio9 {
    public static void main(String[] args) {
        List<TipoCarrera_9> listaCarreras  = new ArrayList<>();
        List<RaceResults_9> listaCarreraRaceResult  = new ArrayList<>();
        List<SprintQualifyingResults_9> listaCarreraSprint  = new ArrayList<>();
        List<Conductor_9> listaConductores   = new ArrayList<>();
        List<Drivers_9> listaDrivers   = new ArrayList<>();
        List<Teams_9> listaTeams   = new ArrayList<>();
        List<List<String>> listaRaceResults = readCSV("Unidad1\\Ejercicio8\\formula1_2021season_raceResults.csv");
        List<List<String>> listaSprint = readCSV("Unidad1\\Ejercicio8\\formula1_2021season_sprintQualifyingResults.csv");
        Path nombreFichero = Path.of("C:\\Users\\andra\\IdeaProjects\\AD\\Unidad1\\Ejercicio8\\formula1_2021season_calendar.xml");
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Calendar.class);
            Unmarshaller jaxbUnmarshaller  = context.createUnmarshaller();
            Calendar_9 cal = (Calendar_9) jaxbUnmarshaller.unmarshal(nombreFichero.toFile());
            ArrayList<Race_9> listaRace = cal.getRaces();
            crearListaCarreraRaceResult(listaRaceResults, listaCarreraRaceResult, listaRace, listaConductores, listaDrivers);
            crearListaCarreraSprint(listaSprint, listaCarreraSprint, listaRace);
            listaCarreras.addAll(listaCarreraRaceResult);
            listaCarreras.addAll(listaCarreraSprint);
            listaConductores = crearListaConductoresRaceResult(listaCarreras);
            listaDrivers = readJSONDrivers();
            listaTeams = readJSONTeams();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static void crearListaCarreraRaceResult(List<List<String>> listaRaceResults, List<RaceResults_9> listaCarreraRaceResult, ArrayList<Race_9> listaRace, List<Teams_9> listaTeams, List<Drivers_9> listaDrivers) {
        boolean correcto;
        Teams_9 equipo = new Teams_9();
        Drivers_9 driver = new Drivers_9();
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
            correcto = true;
            for (int j = 0; j < listaDrivers.size() && correcto; j++) {
                if (listaDrivers.get(j).getDriver().equalsIgnoreCase(line.get(3))) {
                    driver = listaDrivers.get(j);
                    correcto = false;
                }
            }
            correcto = true;
            for (int j = 0; j < listaTeams.size() && correcto; j++) {
                if (listaTeams.get(j).getTeam().equalsIgnoreCase(line.get(4))) {
                    equipo = listaTeams.get(j);
                    correcto = false;
                }
            }
            correcto = true;
            for (int j = 1; j < listaRace.size() && correcto; j++) {
                if (listaRace.get(j).getGpname().equalsIgnoreCase(line.get(0))) {
                    listaCarreraRaceResult.add(new RaceResults_9(listaRace.get(i), parseInt(line.get(1)), parseInt(line.get(2)), driver, equipo, parseInt(line.get(5)), parseInt(line.get(6)), line.get(7), parseDouble(line.get(8)), line.get(9), line.get(10)));
                    correcto = false;
                }
            }
        }
    }
    public static void crearListaCarreraSprint(List<List<String>> listaSprint, List<SprintQualifyingResults_9> listaCarreraSprint, ArrayList<Race_9> listaRace) {
        boolean correcto;
        List<String> line;
        for (int i = 1; i < listaSprint.size(); i++) {
            line = listaSprint.get(i);
            if (line.get(1).equals("NC")) {
                line.set(1, "-1");
            } else if (line.get(1).equals("DQ")) {
                line.set(1, "-2");
            }
            correcto = true;
            for (int j = 1; j < listaRace.size() && correcto; j++) {
                if (listaRace.get(j).getGpname().equalsIgnoreCase(line.get(0))) {
                    listaCarreraSprint.add(new SprintQualifyingResults_9(listaRace.get(i), parseInt(line.get(1)), parseInt(line.get(2)), line.get(3), line.get(4), parseInt(line.get(5)), parseInt(line.get(6)), line.get(7), parseDouble(line.get(8))));
                    correcto = false;
                }
            }
        }
    }

    public static List<Conductor_9> crearListaConductoresRaceResult(List<TipoCarrera_9> listaCarreras) {
        Map<List<String>, Double> mapConductor = listaCarreras.stream()
                .collect(Collectors.groupingBy(p -> Arrays.asList(p.getDriver()), Collectors.summingDouble(TipoCarrera_9::getPoints)
                ));
        List<Conductor_9> listaConductores = mapConductor.entrySet()
                .stream()
                .map(c -> new Conductor_9(c.getKey().get(0), c.getValue())).toList();
        return listaConductores;
    }

    private static List<List<String>> readCSV(String ruta) {
        List<List<String>> listacarrera = new ArrayList<>();
        try (Stream<String> contenidoFichero = Files.lines(Paths.get(ruta))) {
            listacarrera = contenidoFichero.map(l -> Arrays.asList(l.split(","))).toList();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return listacarrera;
    }

    public static List<Teams_9> readJSONTeams() {
        List<Teams_9> lista = new ArrayList<>();
        try {
            String data = new String(Files.readString(Paths.get("Unidad1/Ejercicio09TratamientoJSON/formula1_2021season_teams.json")));
            Gson gson = new Gson();
            lista = Arrays.stream(gson.fromJson(data, Teams_9[].class)).toList();
        } catch (IOException e) {
            System.err.println("No se ha podido encontrar el archivo JSON de Teams.");
        }
        return lista;
    }

    public static List<Drivers_9> readJSONDrivers() {
        List<Drivers_9> lista = new ArrayList<>();
        try {
            String data = new String(Files.readString(Paths.get("Unidad1/Ejercicio09TratamientoJSON/formula1_2021season_drivers.json")));
            Gson gson = new Gson();
            lista = Arrays.stream(gson.fromJson(data, Drivers_9[].class)).toList();
        } catch (IOException e) {
            System.err.println("No se ha podido encontrar el archivo JSON de Drivers.");
        }

        return lista;
    }
}
