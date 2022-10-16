import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.nio.file.StandardOpenOption.CREATE;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private int supplier;
    private int category;
    private double unitPrice;
    private int unitsInStock;

    public Product(int id, String name, int supplier, int category, double unitPrice, int unitsInStock) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.category = category;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", supplier=" + supplier +
                ", category=" + category +
                ", unitPrice=" + unitPrice +
                ", unitsInStock=" + unitsInStock +
                '}';
    }


    @Override
    public int compareTo(Product p) {
        if (this.getUnitsInStock() < p.getUnitsInStock())
            return -1;
        else if (this.getUnitsInStock() > p.getUnitsInStock())
            return 1;
        else
            return 0;
    }

    public boolean writeFile(String ruta) {
        Path rutaFichero = Path.of(ruta);
        boolean correcto = true;
        Product product = buscarProducto(ruta);
        String producto;
        long puntero;
        if (product == null) {
            producto = getId()+",";
            producto += getName()+",";
            producto += getSupplier()+",";
            producto += getCategory()+",";
            producto += ",";
            producto += getUnitPrice()+",";
            producto += getUnitsInStock()+",";
            producto += ",";
            producto += ",";
            producto += ",";

            try (RandomAccessFile raf = new RandomAccessFile(ruta, "rw")) {
                raf.seek(raf.length());
                raf.writeBytes("\n");
                raf.write(producto.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            producto = getId()+",";
            producto += getName()+",";
            producto += getSupplier()+",";
            producto += getCategory()+",";
            producto += ",";
            producto += getUnitPrice()+",";
            producto += getUnitsInStock()+",";
            producto += ",";
            producto += ",";
            producto += ",";

            try (RandomAccessFile raf = new RandomAccessFile(ruta, "rw")) {
                puntero = buscarPosicion(ruta);
                raf.seek(puntero);
                raf.write(producto.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return correcto;
    }

    public Product buscarProducto(String ruta) {
        String[] line;
        String linea;
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")) {
            do {
                linea = raf.readLine();
                if (linea != null) {
                    line = linea.split(",");
                    if (getName().equals(line[1])) {
                        return new Product(parseInt(line[0]), line[1], parseInt(line[2]), parseInt(line[3]), Double.parseDouble(line[5]), parseInt(line[6]));
                    }
                }
            }while (linea != null);
        }catch (Exception ex) {
            ex.getMessage();
        }
        return null;
    }

    public long buscarPosicion(String ruta) {
        String[] line;
        String linea;
        long pos = 0;
        try (RandomAccessFile raf = new RandomAccessFile(ruta, "r")) {
            do {
                pos = raf.getFilePointer();
                linea =  raf.readLine();
                if (linea != null) {
                    line = linea.split(",");
                    if (getName().equals(line[1])) {
                        return pos;
                    }
                }
            } while(linea != null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pos;
    }
}