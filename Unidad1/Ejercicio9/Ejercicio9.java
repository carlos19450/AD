//import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Ejercicio9 {
    public static void main(String[] args) {
        List<TipoCarrera_9> listaCarreras  = new ArrayList<>();
        List<RaceResults_9> listaCarreraRaceResult  = new ArrayList<>();
        List<SprintQualifyingResults_9> listaCarreraSprint  = new ArrayList<>();
        List<Drivers_9> listaDrivers;
        List<Teams_9> listaTeams;
        List<List<String>> listaRaceResults = readCSV("Unidad1\\Ejercicio9\\formula1_2021season_raceResults.csv");
        List<List<String>> listaSprint = readCSV("Unidad1\\Ejercicio9\\formula1_2021season_sprintQualifyingResults.csv");
        Path archivo = Path.of("Unidad1\\Ejercicio9\\formula1_2021season_calendar.xml");
        JAXBContext context;
        Teams_9 equipo = new Teams_9();
        Drivers_9 driver = new Drivers_9();
        try {
            context = JAXBContext.newInstance(Calendar_9.class);
            Unmarshaller jaxbUnmarshaller  = context.createUnmarshaller();
            Calendar_9 cal = (Calendar_9) jaxbUnmarshaller.unmarshal(archivo.toFile());
            ArrayList<Race_9> listaRace = cal.getRaces();
            listaDrivers = readJSONDrivers();
            listaTeams = readJSONTeams();
            crearListaCarreraRaceResult(listaRaceResults, listaCarreraRaceResult, listaRace, listaTeams, listaDrivers, equipo, driver);
            crearListaCarreraSprint(listaSprint, listaCarreraSprint, listaRace, listaTeams, listaDrivers, equipo, driver);
            listaCarreras.addAll(listaCarreraRaceResult);
            listaCarreras.addAll(listaCarreraSprint);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static void crearListaCarreraRaceResult(List<List<String>> listaRaceResults, List<RaceResults_9> listaCarreraRaceResult, ArrayList<Race_9> listaRace, List<Teams_9> listaTeams, List<Drivers_9> listaDrivers, Teams_9 equipo, Drivers_9 driver) {
        boolean correcto;
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
                    listaCarreraRaceResult.add(new RaceResults_9(listaRace.get(j), parseInt(line.get(1)), parseInt(line.get(2)), driver, equipo, parseInt(line.get(5)), parseInt(line.get(6)), line.get(7), parseDouble(line.get(8)), line.get(9), line.get(10)));
                    correcto = false;
                }
            }
        }
    }
    public static void crearListaCarreraSprint(List<List<String>> listaSprint, List<SprintQualifyingResults_9> listaCarreraSprint, ArrayList<Race_9> listaRace, List<Teams_9> listaTeams, List<Drivers_9> listaDrivers, Teams_9 equipo, Drivers_9 driver) {
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
                    listaCarreraSprint.add(new SprintQualifyingResults_9(listaRace.get(j), parseInt(line.get(1)), parseInt(line.get(2)), driver, equipo, parseInt(line.get(5)), parseInt(line.get(6)), line.get(7), parseDouble(line.get(8))));
                    correcto = false;
                }
            }
        }
    }

    private static List<List<String>> readCSV(String ruta) {
        List<List<String>> listacarrera = new ArrayList<>();
        try (Stream<String> contenidoFichero = Files.lines(Paths.get(ruta))) {
            listacarrera = contenidoFichero.map(l -> Arrays.asList(l.split(","))).toList();
        } catch (IOException e) {
            System.out.println("Error. Archivo CSV no encontrado.");
            e.printStackTrace();
        }
        return listacarrera;
    }

    public static List<Teams_9> readJSONTeams() {
        List<Teams_9> lista = new ArrayList<>();
        try {
            String data = new String(Files.readString(Paths.get("Unidad1/Ejercicio9/formula1_2021season_teams.json")));
            //Gson gson = new Gson();
            //lista = Arrays.stream(gson.fromJson(data, Teams_9[].class)).toList();
        } catch (IOException e) {
            System.err.println("Error. Archivo JSON no encontrado.");
        }
        return lista;
    }

    public static List<Drivers_9> readJSONDrivers() {
        List<Drivers_9> lista = new ArrayList<>();
        try {
            String data = new String(Files.readString(Paths.get("Unidad1/Ejercicio9/formula1_2021season_drivers.json")));
            //Gson gson = new Gson();
            //lista = Arrays.stream(gson.fromJson(data, Drivers_9[].class)).toList();
        } catch (IOException e) {
            System.err.println("Error. Archivo JSON no encontrado.");
        }
        return lista;
    }
}
