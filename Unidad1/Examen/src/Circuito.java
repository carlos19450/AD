import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Circuito extends Resultado{
    private int ronda;
    private String pais;
    private String fechaCarrera;

    public Circuito(int ronda, String pais, String fechaCarrera) {
        this.ronda = ronda;
        this.pais = pais;
        this.fechaCarrera = fechaCarrera;
    }

    // Getters
    public int getRonda() { return ronda; }
    public String getPais() { return pais; }
    public String getFechaCarrera() { return fechaCarrera; }

    // Setters
    public void setRonda(int ronda) { this.ronda = ronda; }
    public void setPais(String pais) { this.pais = pais; }
    public void setFechaCarrera(String fechaCarrera) {
        this.fechaCarrera = fechaCarrera;
    }

    @Override
    public String toString() {
        return "Circuito{" +
                "ronda=" + ronda +
                ", pais='" + pais + '\'' +
                ", fechaCarrera=" + fechaCarrera +
                '}';
    }
}
