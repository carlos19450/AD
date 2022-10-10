import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Ejercicio5_3 {
    public static void main(String[] args) {
        Path personaFichero = Path.of("/home/carpui/Escritorio/personas.dat");
        Persona person = new Persona();
        List<Persona> listaPersonas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String opc, opc2;

        try (FileOutputStream fos = new FileOutputStream(personaFichero.toFile());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(person);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(personaFichero.toFile());
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() > 0) {
                try {
                        Persona emp = (Persona) ois.readObject();
                        listaPersonas.add(emp);
                } catch (StreamCorruptedException e) {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Persona var : listaPersonas)
        {
            var.escribir();
        }
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
                }
                case "2" -> {
                    do {
                        person.buscaPersona(listaPersonas);
                        System.out.println("¿Quieres buscar a otro contacto? S/N");
                        System.out.print("Introducir: ");
                        opc2 = sc.nextLine();
                    }while (!opc2.equalsIgnoreCase("N"));
                }
                default -> System.out.println("Error. Introduce 1 o 2");
            }
        } while(!opc.equals("0"));
    }
}
