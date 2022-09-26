import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio3 {
    public static void main(String[] args) {
        Product arrayProducto[]=new Product[77];
        Path productosFichero = Path.of("/home/carpui/IdeaProjects/AD/Unidad0/Ejercicio3/Ej03-LeerFichero.csv");

        System.out.println("\nLectura del fichero con Files.lines");
        try (Stream<String> lineas = Files.lines(productosFichero);) {
            lineas.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
