package repositories;

public interface DaoManager {
    repositories.DepartamentoDAO getDepartamentoDAO();
    repositories.DireccionDAO getDireccionDAO();
    repositories.EmpleadoDAO getEmpleadoDAO();
    repositories.EmpleadoDepartamentoDAO getEmpleadoDepartamentoDAO();
}
