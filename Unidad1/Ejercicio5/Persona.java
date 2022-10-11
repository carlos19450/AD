import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Persona implements Serializable {
    private static final long serialVersionUID = 100L;
    String nombre, mail;
    LocalDate annoNacimiento;
    Persona person;

    public Persona() {
    }

    public Persona(String nombre, String mail, LocalDate annoNacimiento) {
        this.nombre = nombre;
        this.mail = mail;
        this.annoNacimiento = annoNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAnnoNacimiento(LocalDate annoNacimiento) {
        this.annoNacimiento = annoNacimiento;
    }

    public void introducirEnFichero(Path personaFichero, Persona ultimo) {
        try (FileOutputStream fos = new FileOutputStream(personaFichero.toFile(), true);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                     oos.writeObject(ultimo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buscaPersona(List<Persona> listaPersonas) {
        Scanner sc = new Scanner(System.in);
        Iterator<Persona> iterator = listaPersonas.iterator();
        if (listaPersonas.size() == 0) {
            System.out.println("No hay ninguna persona en la agenda.");
        }else {
            System.out.println("Para buscar a una persona introduce su nombre:");
            nombre = sc.nextLine();

            while (iterator.hasNext()) {
                person = iterator.next();
                if (person.getNombre().equals(nombre)) {
                    System.out.println(person);
                }
            }
        }
    }

    public void crearPersona(List<Persona> listaPersonas, Path personaFichero) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter foramto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String nombre, mail, fechaNacimiento;

        //NOMBRE
        System.out.println("Introduce el nombre: ");
        System.out.print("Introducir: ");
        nombre = sc.nextLine();
        //MAIL
        System.out.println("Introduce el mail: ");
        System.out.print("Introducir: ");
        mail = sc.nextLine();
        //FECHA DE NACIMIENTO
        System.out.println("Introduce la fecha de nacimiento con formato 'dd/MM/yyyy': ");
        System.out.print("Introducir: ");
        fechaNacimiento = sc.nextLine();
        LocalDate anno = LocalDate.parse(fechaNacimiento, foramto);

        //LA PERSONA
        Persona aux = new Persona(nombre,mail,anno);
        listaPersonas.add(aux);

        introducirEnFichero(personaFichero, aux);
    }

    public void escribir() {
        System.out.println("Usuario -> nombre: " + this.nombre + ", mail: " + this.mail + ", Año de nacimineto: " + this.annoNacimiento);
    }

    @Override
    public String toString() {
        return "Usuario: " + this.nombre +
                ", mail: " + this.mail +
                ", Año de nacimiento: " + this.annoNacimiento + "\n";
    }
}
