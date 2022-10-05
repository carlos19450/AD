import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.CREATE;

public class Ejercicio4_3 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Path frasesFichero = Path.of("C:\\Users\\carlo\\Desktop\\Eaj\\anotaciones.txt");
        BasicFileAttributes attr = Files.readAttributes(frasesFichero, BasicFileAttributes.class);
        ArrayList<String> listaCadenas = new ArrayList<>();
        String frase;

        do {
            System.out.println("Introduce frases.");
            frase = sc.nextLine();
            if (frase != "") {
                listaCadenas.add(String.valueOf(attr.creationTime()));
                listaCadenas.add(frase);
            }
        } while (frase != "");

        try (BufferedWriter bw = Files.newBufferedWriter(frasesFichero, StandardOpenOption.APPEND, CREATE)){
            for (String cadena : listaCadenas) {
                bw.write(cadena);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        imprimirFichero(frasesFichero);
    }
    public static void imprimirFichero(Path rutaFrasesFichero) {
        try (Stream<String> lineas = Files.lines(rutaFrasesFichero)) {
            lineas.forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
