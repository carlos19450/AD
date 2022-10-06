import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio4_1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Path frasesFichero = Path.of("C:\\Users\\carlo\\Desktop\\Eaj\\frases.txt");
        Files.deleteIfExists(frasesFichero);
        ArrayList<String> listaCadenas = new ArrayList<>();
        String frase;

        do {
            System.out.println("Introduce frases.");
            frase = sc.nextLine();
            listaCadenas.add(frase);
        } while (!frase.isEmpty());

        try (BufferedWriter bw = Files.newBufferedWriter(frasesFichero)){
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
