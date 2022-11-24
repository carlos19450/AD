//import com.google.gson.Gson;
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

public class Mundial {

    public static List<Piloto> leerPilotos() {
        ArrayList<Piloto> listaPilotos = new ArrayList<>();
        Path ruta = Path.of("Unidad1/Examen/data/pilotos.xml");
        JAXBContext context;
        try {
            context = JAXBContext.newInstance(Drivers.class);
            Unmarshaller jaxbUnmarshaller  = context.createUnmarshaller();
            Drivers piloto = (Drivers) jaxbUnmarshaller.unmarshal(ruta.toFile());
            listaPilotos = piloto.getDrivers();
        } catch (JAXBException e) {
            System.out.println("Error. Archivo XML no encontrado.");
            e.printStackTrace();
        }
        return listaPilotos;
    }
    
    public static List<Circuito> leerCircuitos() {
        List<String> line;
        Circuito carrera;
        List<List<String>> listaCircuitoResult = new ArrayList<>();
        List<Circuito> listaCircuito = new ArrayList<>();
        Path ruta = Path.of("Unidad1/Examen/data/circuitos.csv");
        try (Stream<String> contenidoFichero = Files.lines(ruta)) {
            listaCircuitoResult = contenidoFichero.map(l -> Arrays.asList(l.split(","))).toList();
        } catch (IOException e) {
            System.out.println("Error. Archivo CSV no encontrado.");
            e.printStackTrace();
        }
        for (int i = 1; i < listaCircuitoResult.size(); i++) {
            line = listaCircuitoResult.get(i);
            carrera = new Circuito(parseInt(line.get(0)), line.get(1), line.get(2));
            listaCircuito.add(carrera);
        }
        return listaCircuito;
    }

    public static List<Resultado> leerResultados(List<Circuito> circuitos, List<Piloto> pilotos) {
        List<Resultado> listaRsultado = new ArrayList<>();
        try {
            String data = new String(Files.readString(Paths.get("Unidad1/Examen/data/resultados.json")));
            //Gson gson = new Gson();
            //listaRsultado = Arrays.stream(gson.fromJson(data, Resultado[].class)).toList();
        } catch (IOException e) {
            System.err.println("Error. Archivo JSON no encontrado.");
            e.printStackTrace();
        }
        return listaRsultado;
    }

    public static void imprimirClasificacionFinal(List<Resultado> resultados) {

    }

    public static void imprimirMayoresde30(List<Piloto> pilotos) {

    }

    public static void main(String[] args) {
        List<Piloto> pilotos = leerPilotos();
		//System.out.println(pilotos);

        List<Circuito> circuitos = leerCircuitos();
		//System.out.println(circuitos);

        List<Resultado> resultados = leerResultados(circuitos, pilotos);

        imprimirClasificacionFinal(resultados);

        imprimirMayoresde30(pilotos);
    }
}
