import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {
    private static final long serialVersionUID = 100L;
    String nombre, mail;
    LocalDate añoNacimiento;

    public Persona(String nombre, String mail, LocalDate añoNacimiento) {
        this.nombre = nombre;
        this.mail = mail;
        this.añoNacimiento = añoNacimiento;
    }

    public void escribir() {
        System.out.println("Usuario -> nombre: " + this.nombre + ", mail: " + this.mail + ", Año de nacimineto: " + this.añoNacimiento);
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre +
                ", mail: " + mail +
                ", Año de nacimiento: " + añoNacimiento + "\n";
    }
}
