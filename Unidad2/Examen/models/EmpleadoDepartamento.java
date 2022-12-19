package models;

public class EmpleadoDepartamento {
    private int id;
    private Empleado emp;
    private Departamento dep;

    public EmpleadoDepartamento(int id, Empleado emp, Departamento dep) {
        this.id = id;
        this.emp = emp;
        this.dep = dep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getEmp() {
        return emp;
    }

    public void setEmp(Empleado emp) {
        this.emp = emp;
    }

    public Departamento getDep() {
        return dep;
    }

    public void setDep(Departamento dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "EmpleadoDepartamento{" +
                "id=" + id +
                ", emp=" + emp +
                ", dep=" + dep +
                '}';
    }
}
