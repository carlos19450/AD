import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class Ejercicio5_3 {
    public static void main(String[] args) {
        Path personaFichero = Path.of("C:\\Users\\andra\\Desktop\\personas.dat");
        Persona person = new Persona();
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter foramto = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String opc, opc2, nombre, mail, fechaNacimiento;
        //MENÚ
        System.out.println("1.Introducir personas en la agenda.\n" +
                "2.Buscar personas en la agenda.\n" +
                "0.Para salir.\n");
        do {
            opc = sc.nextLine();
            switch (opc) {
                case "1" :
                    do {
                        //NOMBRE
                        System.out.println("Introduce el nombre: ");
                        nombre = sc.nextLine();
                        //MAIL
                        System.out.println("Introduce el mail: ");
                        mail = sc.nextLine();
                        //FECHA DE NACIMIENTO
                        System.out.println("Introduce la fecha de nacimiento: ");
                        fechaNacimiento = sc.nextLine();
                        LocalDate año = LocalDate.parse(fechaNacimiento, foramto);

                        //LA PERSONA
                        person = new Persona();
                        person.setNombre(nombre);
                        person.setMail(mail);
                        person.setAñoNacimiento(año);
                        listaPersonas.add(person);
                        System.out.println("¿Quieres introducir otro contacto? S/N");
                        opc2 = sc.nextLine();
                    } while (!opc2.equalsIgnoreCase("N"));
                        person.introducir(nombre, personaFichero, listaPersonas);
                        break;
                case "2" :
                    if (listaPersonas.size() == 0) {
                        System.out.println("No hay ninguna persona en la agenda.");
                    }else {
                        System.out.println("Para buscar a una persona introduce su nombre:");
                        nombre = sc.nextLine();
                        person.buscaPersona(nombre, listaPersonas);
                    }
                    break;
                default : System.out.println("Error. Introduce 1 o 2");
                    break;
            }
            System.out.println("Introduce un numero del menu");
        } while(!opc.equals("0"));
        //PERSON1





    }
}
