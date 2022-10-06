public class Ejercicio4_4 {
    public static void main(String[] args) {
        Product producto = new Product(777, "Pepe", 34, 23, 10.3, 2);
        String ruta = "C:\\Users\\carlo\\Desktop\\Eaj\\productos.csv";
        if (producto.writeFile(ruta)) {
            System.out.println("Creacion existosa.");
        }else {
            System.out.println("Error.");
        }
    }
}