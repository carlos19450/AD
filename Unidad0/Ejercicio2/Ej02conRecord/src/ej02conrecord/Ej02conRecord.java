package Ej02conRecord.src.ej02conrecord;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

record LibroRecord(String titulo, int numPaginas, String autor) {

}

/**
 *
 * @author carpui
 */
public class Ej02conRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<LibroRecord> libros = new ArrayList<>();
        Stream<LibroRecord> stream = libros.stream();

        libros.add(new LibroRecord("El Señor de los Anillos", 800, "J.R.R. Tolkien"));
        libros.add(new LibroRecord("El Hobbit", 350, "J.R.R. Tolkien"));
        libros.add(new LibroRecord("Cabo Trafalgar", 320, "Arturo Pérez Reverte"));
        libros.add(new LibroRecord("El corazón de la piedra", 560, "José María García López"));
        libros.add(new LibroRecord("Salmos de vísperas", 95, "Esteban Hernández Castelló"));
        libros.add(new LibroRecord("La música en las catedrales españolas del Siglo de Oro", 600, "Robert Stevenson"));
        libros.add(new LibroRecord("Luces de bohemia", 296, "Ramón del Valle-Inclán"));
        libros.add(new LibroRecord("Contando atardecere", 528, "La vecina rubia"));
        libros.add(new LibroRecord("Master - Roger Federer", 456, "Christopher Clarey"));
        libros.add(new LibroRecord("La teoría de los archipiélagos", 300, "Alice Kellen"));
        libros.add(new LibroRecord("Esperando al diluvio", 576, "Dolores Redondo"));
        libros.add(new LibroRecord("El italiano", 400, "Arturo Pérez Reverte"));
        libros.add(new LibroRecord("Línea de fuego", 688, "Arturo Pérez Reverte"));

        //Obtener la cantidad de libros con más de 500 páginas.
        //System.out.println("Ejercicio 1 \n");
        //System.out.println(libros.stream().filter(p -> p.numPaginas()> 500).count());
        
        //Obtener la cantidad de libros con menos de 300 páginas.
        //System.out.println("Ejercicio 2 \n");
        //System.out.println(libros.stream().filter(p -> p.numPaginas()< 300).count());
        
        //Listar el título de todos aquellos libros con más de 500 páginas.
        /*System.out.println("Ejercicio 3 \n");
        libros.stream()
                .filter(p -> p.numPaginas() > 500)
                .forEach(p -> System.out.println(p.titulo()));*/
        
        //Mostrar en consola el título de los 3 libros con mayor número de páginas.
        /*System.out.println("Ejercicio 4 \n");
        libros.stream()
                .sorted((p1, p2) -> Integer.compare(p2.numPaginas(), p1.numPaginas()))
                .limit(3)
                .forEach(p -> System.out.println(p.titulo()));*/
        
        //Mostrar en consola la suma total de las páginas de todos los libros.
        /*System.out.println("Ejercicio 5 \n");
        System.out.println(libros.stream()
                .map(p -> p.numPaginas())
                .reduce(0, (a,b) -> a + b));*/
        
        //FALTA
        //Mostrar en consola todos aquellos libros que superen el promedio en cuanto a número de páginas se refiere.
        System.out.println("Ejercicio 6 \n");
        OptionalDouble avgMedia = libros.stream()
                .mapToInt(p -> p.numPaginas()).average();

        libros.stream()
                .filter(p -> p.numPaginas() > avgMedia.getAsDouble())
                .forEach(p -> System.out.println(p.titulo()));


        //Mostrar en consola los autores de todos los libros, sin repetir nombres de autores.
        /*System.out.println("Ejercicio 7 \n");
        System.out.println(libros.stream()
            .map(p -> p.autor())    
            .distinct()
            .collect(Collectors.toList()));*/
        
        //FALTA
        //Mostrar en consola los autores que tengan más de 1 libro listado.
        /*System.out.println("Ejercicio 8 \n");
        libros.stream()
            .filter(p -> p.titulo() > 1).count()
            .map(p -> p.autor());*/
        
        // Obtener el libro con mayor número de páginas.
        /*System.out.println("Ejercicio 9 \n");
        libros.stream()
                .sorted((p1, p2) -> Integer.compare(p2.numPaginas(), p1.numPaginas()))
                .limit(1)
                .forEach(p -> System.out.println(p.toString()));*/
        
        //Crear una lista de Strings con todos los títulos de los vídeos.
        /*System.out.println("Ejercicio 10 \n");
        System.out.println(libros.stream()
            .map(p -> p.titulo())    
            .collect(Collectors.toList()));*/
        
    }
}