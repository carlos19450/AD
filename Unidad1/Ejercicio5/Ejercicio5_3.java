import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Ejercicio5_3 {
    public static void main(String[] args) {
        Persona person;
        Path personaFichero = Path.of("/home/carpui/Escritorio/personas.dat");
        DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Persona> listaPersonas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String opc, nombre, mail, fechaNacimiento;

        if (Files.exists(personaFichero)) {
            listaPersonas = cargarListaPersona(personaFichero);
        }
        for (Persona p : listaPersonas) {
            System.out.println(p);
        }

        do {
            //MENÚ
            System.out.println("1.Introducir personas en la agenda.\n" +
                    "2.Buscar personas en la agenda.\n" +
                    "0.Para salir.\n");
            System.out.print("Introducir: ");
            opc = sc.nextLine();
            switch (opc) {
                case "0" ->  {
                    introducirEnFichero(personaFichero, listaPersonas);
                    System.out.println("Adios");
                }
                case "1" -> {
                    //NOMBRE
                    System.out.print("Introduce el nombre: ");
                    nombre = sc.nextLine();
                    //MAIL
                    System.out.print("Introduce el mail: ");
                    mail = sc.nextLine();
                    //FECHA DE NACIMIENTO
                    System.out.print("Introduce la fecha de nacimiento con formato 'dd/MM/yyyy': ");
                    fechaNacimiento = sc.nextLine();
                    LocalDate anno = LocalDate.parse(fechaNacimiento, fecha);
                    person = crearPersona(nombre, mail, anno);
                    listaPersonas.add(person);
                    System.out.println();
                }
                case "2" -> {
                    if (listaPersonas.contains(null)) {
                        System.out.println("No hay ninguna persona en la agenda.");
                    } else {
                        System.out.print("Para buscar a una persona introduce su nombre: ");
                        nombre = sc.nextLine();
                        buscaPersona(listaPersonas, nombre);
                        System.out.println();
                    }
                }
                default -> System.out.println("Error. Introduce 1 o 2 \n");
            }
        } while (!opc.equals("0"));
    }

    public static List<Persona> cargarListaPersona(Path personaFichero) {
        List<Persona> listaPersonasCargadas = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(personaFichero.toFile());
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            listaPersonasCargadas = (List) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPersonasCargadas;
    }
    public static void introducirEnFichero(Path personaFichero ,List<Persona> listaPersonas) {
        try (FileOutputStream fos = new FileOutputStream(personaFichero.toFile(), true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaPersonas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buscaPersona(List<Persona> listaPersonas, String nombre) {
        for (Persona person: listaPersonas) {
            if (person.getNombre().equals(nombre)) {
                System.out.println(person);
            }
        }
    }

    public static Persona crearPersona(String nombre, String mail, LocalDate anno) {
        Persona personaCreada = new Persona(nombre,mail,anno);
        return personaCreada;
    }
}
