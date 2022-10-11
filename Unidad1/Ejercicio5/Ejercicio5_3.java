import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Ejercicio5_3 {
    public static void main(String[] args) {
        Path personaFichero = Path.of("C:\\Users\\carlo\\Desktop\\personas.dat");
        Persona person = new Persona();
        List<Persona> listaPersonas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String opc, opc2;

        if (Files.exists(personaFichero)) {
            System.out.println("El fichero existe");
            try (FileInputStream fis = new FileInputStream(personaFichero.toFile());
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                while (fis.available() > 0) {
                    try {
                        Persona aux = (Persona) ois.readObject();
                        listaPersonas.add(aux);
                        System.out.println(aux.getNombre());
                    } catch (StreamCorruptedException e) {
                        System.out.println("Stream corrupted");
                        break;
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {

            }
        }
        for (Persona p: listaPersonas) {
            System.out.println(p);
        }
        //se supone que listaPersonas tiene un montón de personas
        do {
            //MENÚ
            System.out.println("1.Introducir personas en la agenda.\n" +
                    "2.Buscar personas en la agenda.\n" +
                    "0.Para salir.\n");
            System.out.print("Introducir: ");
            opc = sc.nextLine();
            switch (opc) {
                case "0" -> System.out.println("Adios");
                case "1" -> {
                    do {
                        person.crearPersona(listaPersonas, personaFichero);
                        System.out.println("¿Quieres introducir otro contacto? S/N");
                        System.out.print("Introducir: ");
                        opc2 = sc.nextLine();
                    }while (!opc2.equalsIgnoreCase("N"));
                    System.out.println();
                }
                case "2" -> {
                    do {
                        person.buscaPersona(listaPersonas);
                        System.out.println("¿Quieres buscar a otro contacto? S/N");
                        System.out.print("Introducir: ");
                        opc2 = sc.nextLine();
                    }while (!opc2.equalsIgnoreCase("N"));
                    System.out.println();
                }
                default -> System.out.println("Error. Introduce 1 o 2 \n");
            }
        } while(!opc.equals("0"));
    }
}
