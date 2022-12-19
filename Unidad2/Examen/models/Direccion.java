package models;

public class Direccion {
    private int id;
    private Empleado empleadoID;
    private String calle;
    private String ciudad;
    private String pais;

    public Direccion(int id, Empleado empleadoID, String calle, String ciudad, String pais) {
        this.id = id;
        this.empleadoID = empleadoID;
        this.calle = calle;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(Empleado empleadoID) {
        this.empleadoID = empleadoID;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", empleadoID=" + empleadoID +
                ", calle='" + calle + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
