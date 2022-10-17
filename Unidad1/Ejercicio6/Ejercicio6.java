public class Ejercicio6 {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\carlo\\Desktop\\Eaj\\productos.csv";
        Product producto = new Product(2, "Pared", 34, 23, 10.3, 2);
        producto.writeFile(ruta);
        producto = new Product(1, "Suelo", 22, 21, 1.3, 6);
        producto.writeFile(ruta);
        producto = new Product(0, "Ramon", 23, 3, 1.2, 1);
        producto.writeFile(ruta);

    }
}
