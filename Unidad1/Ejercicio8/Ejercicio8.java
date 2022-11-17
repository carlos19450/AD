import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio8 {
    public static void main(String[] args) {
        List<Formula1> listaCarrera  = new ArrayList<>();
        List<Formula1> listaSprints  = new ArrayList<>();
        Path nombreFichero = Path.of("/home/carpui/IdeaProjects/AD/Unidad1/Ejercicio8/formula1_2021season_calendar.xml");
        JAXBContext context;

        try {
            context = JAXBContext.newInstance(Calendar.class);
            Unmarshaller jaxbUnmarshaller  = context.createUnmarshaller();

            Calendar cal = (Calendar) jaxbUnmarshaller.unmarshal(nombreFichero.toFile());

            for(Race l: cal.getRaces()){
                System.out.println(l.getRacedate());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
