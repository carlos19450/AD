import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Ejercicio4_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Path frasesFichero = Path.of("/home/carpui/Escritorio/frases.txt");
        ArrayList<String> listaCadenas = new ArrayList<>();
        String frase;

        do {
            System.out.println("Introduce frases.");
            frase = sc.nextLine();
            listaCadenas.add(frase);
        } while (frase != "");

        try (BufferedWriter bw = Files.newBufferedWriter(frasesFichero)){
            for (String frases : listaCadenas) {
                bw.write(frases);
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
