package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Circuito {
    private int numero;
    private String pais;
    private LocalDate fecha;

    public Circuito(int numero, String pais, LocalDate fecha) {
        this.numero = numero;
        this.pais = pais;
        this.fecha = fecha;
    }
    // Getters
    public int getNumero() {
        return numero;
    }
    public String getPais() {
        return pais;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public String getFechaString() {
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    // Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "Circuito{" +
                "numero=" + numero + '\'' +
                ", pais=" + pais + '\'' +
                ", fecha=" + fecha + '\'' +
                '}';
    }
}
