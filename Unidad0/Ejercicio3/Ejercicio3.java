import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

public class Ejercicio3 {
    public static void main(String[] args) {
        List<Product> listaProductos  = new ArrayList<Product>();

        try {
            añadirProductos(listaProductos);

            //Menú
            System.out.println("1. Imprimir la lista de productos\n" +
                    "2. Imprimir los nombres de los productos\n" +
                    "3. Imprimir los nombres de los productos cuyas unidades en stock sean menor que 10\n" +
                    "4. Imprimir el nombre de los productos con unidades en stock mayor de 10 ordenados por unidad de\n" +
                    "stock de forma descendente\n" +
                    "5. Imprimir el número de productos agrupados por proveedor\n" +
                    "6. Imprimir el producto con el precio unitario más alto\n" +
                    "7. Imprimir el promedio de existencias en almacén\n");
            mostrarMenu(listaProductos);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void añadirProductos(List listaProductos) throws IOException {
        Path productosFichero = Path.of("/home/carpui/IdeaProjects/AD/Unidad0/Ejercicio3/Ej03-LeerFichero.csv");
        List<String> listaLineas = Files.readAllLines(productosFichero);
        String[] line;
        Product productos;

        //Bucle para introducir los productos en la lista.
        for (int i = 1; i < listaLineas.size(); i++) {
            line = listaLineas.get(i).split(",");
            productos = new Product(parseInt(line[0]), line[1], parseInt(line[2]), parseInt(line[3]), Double.parseDouble(line[5]), parseInt(line[6]));
            listaProductos.add(productos);
        }
    }

    public static void mostrarMenu(List<Product> listaProductos) throws IOException{
        Scanner sc=new Scanner(System.in);
        int opc;

        opc = sc.nextInt();
        //Opciones del menú
        switch (opc) {
            case 1 -> listaProductos.forEach(System.out::println);
            case 2 -> listaProductos.stream().map(Product::getName).forEach(System.out::println);
            case 3 -> listaProductos.stream().filter(p -> p.getUnitsInStock() > 10).map(Product::getName).forEach(System.out::println);
            case 4 -> listaProductos.stream().filter(p -> p.getUnitsInStock() > 10).sorted(Comparator.reverseOrder()).map(Product::getName).forEach(System.out::println);
            case 5 -> listaProductos.stream().collect(Collectors.groupingBy(Product::getSupplier, Collectors.counting())).entrySet().stream().map(Map.Entry::getKey).forEach(System.out::println);
            case 6 -> listaProductos.stream().sorted((p1, p2) -> Double.compare(p2.getUnitPrice(), p1.getUnitPrice())).limit(1).forEach(System.out::println);
            case 7 -> {
                double media = listaProductos.stream().mapToDouble(Product::getUnitsInStock).average().getAsDouble();
                listaProductos.stream().filter(p -> p.getUnitsInStock() > media).forEach(p -> System.out.println(p.getUnitsInStock()));
            }
            default -> System.out.println("Introduce un numero valido del menú.");
        }
    }
}
