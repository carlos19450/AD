import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class Persona implements Serializable {
    private static final long serialVersionUID = 100L;
    String nombre, mail;
    LocalDate añoNacimiento;

    public Persona() {
    }

    public Persona(String nombre, String mail, LocalDate añoNacimiento) {
        this.nombre = nombre;
        this.mail = mail;
        this.añoNacimiento = añoNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(LocalDate añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public void introducir(String nombre, Path personaFichero, ArrayList<Persona> listaPersonas) {
        try (FileOutputStream fos = new FileOutputStream(personaFichero.toFile());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            Iterator<Persona> iterator = listaPersonas.iterator();
            while (iterator.hasNext()) {
                Persona person = iterator.next();
                if (person.getNombre().equals(nombre)) {
                    oos.writeObject(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buscaPersona(String nombre, ArrayList<Persona> listaPersonas) {
        Iterator<Persona> iterator = listaPersonas.iterator();
        while (iterator.hasNext()) {
            Persona person = iterator.next();
            if (person.getNombre().equals(nombre)) {
                System.out.println(person);
            }
        }
    }

    public void escribir() {
        System.out.println("Usuario -> nombre: " + this.nombre + ", mail: " + this.mail + ", Año de nacimineto: " + this.añoNacimiento);
    }

    @Override
    public String toString() {
        return "Usuario: " + this.nombre +
                ", mail: " + this.mail +
                ", Año de nacimiento: " + this.añoNacimiento + "\n";
    }
}
