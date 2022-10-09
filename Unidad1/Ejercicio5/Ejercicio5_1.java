import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class Ejercicio5_1 {
    public static void main(String[] args) {
        Path personaFichero = Path.of("C:\\Users\\andra\\Desktop\\personas.dat");
        DateTimeFormatter foramto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //PERSON1
        LocalDate año1 = LocalDate.parse("15/08/1994", foramto);
        Persona person1 = new Persona("Pepe", "hola@gmail.com", año1);
        //PERSONA2
        LocalDate año2 = LocalDate.parse("15/08/1995", foramto);
        Persona person2 = new Persona("Paco", "adios@gmail.com", año2);
        //PERSONA3
        LocalDate año3 = LocalDate.parse("15/08/1996", foramto);
        Persona person3 = new Persona("Ramon", "jaja@gmail.com", año3);
        ArrayList<Persona> listaCadenas = new ArrayList<>();

        try (FileOutputStream fos = new FileOutputStream(personaFichero.toFile());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(person1);
            oos.writeObject(person2);
            oos.writeObject(person3);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
