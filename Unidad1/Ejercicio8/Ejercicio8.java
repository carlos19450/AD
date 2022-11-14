import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.nio.file.Path;
import java.util.ArrayList;

public class Ejercicio8 {
    public static void main(String[] args) {
        Path nombreFichero = Path.of("/home/carpui/IdeaProjects/AD/Unidad1/Ejercicio8/formula1_2021season_calendar.xml");
        JAXBContext context = null;

        try {
            context = JAXBContext.newInstance(Calendar.class);
            Unmarshaller jaxbUnmarshaller  = context.createUnmarshaller();
            Calendar cal = (Calendar) jaxbUnmarshaller.unmarshal(nombreFichero.toFile());

            ArrayList<Race> races = cal.getRaces();

            for(Race l: races){
                System.out.println(l.getCountry());
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
