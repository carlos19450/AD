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
            e.printStackTrace();
        }
        return listaPilotos;
    }
    
    public static List<Circuito> leerCircuitos() {
        List<List<String>> listaCircuito = new ArrayList<>();
        Path ruta = Path.of("Unidad1/Examen/data/pilotos.xml");
        try (Stream<String> contenidoFichero = Files.lines(Paths.get(ruta))) {
            listacarrera = contenidoFichero.map(l -> Arrays.asList(l.split(","))).toList();
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return listacarrera;
    }

    public static List<Resultado> leerResultados(List<Circuito> circuitos, List<Piloto> pilotos) {

        return null;
    }

    public static void imprimirClasificacionFinal(List<Resultado> resultados) {

    }

    public static void imprimirMayoresde30(List<Piloto> pilotos) {

    }

    public static void main(String[] args) {
        List<Piloto> pilotos = leerPilotos();
		//System.out.println(pilotos);

        List<Circuito> circuitos = leerCircuitos();
		// System.out.println(circuitos);

        List<Resultado> resultados = leerResultados(circuitos, pilotos);

        imprimirClasificacionFinal(resultados);

        imprimirMayoresde30(pilotos);
    }
}
