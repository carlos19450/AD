package repositories.sql;

import models.Departamento;
import models.Empleado;
import repositories.DepartamentoDAO;
import repositories.EmpleadoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLiteEmpleadoDAOImpl implements EmpleadoDAO {
    final String FINDALL = "SELECT * FROM empleados";
    final String FINDBYID = "SELECT * FROM empleados WHERE id = ?";
    final String SAVE = "INSERT INTO empleados (id, nombre, apellido, email, sueldo) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE empleados SET nombre = ?, apellido = ?, email = ?, sueldo = ?, WHERE id = ?";
    final String DELETE = "DELETE FROM empleados WHERE id = ?";

    private Connection conexion = null;

    public SQLiteEmpleadoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> listaEmpleado = new ArrayList<>();
        try (PreparedStatement sentencia = conexion.prepareStatement(FINDALL);
             ResultSet rs = sentencia.executeQuery()){
            while (rs.next()) {
                listaEmpleado.add(convertToEmpleado(rs));
            }
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaEmpleado;
    }

    @Override
    public Empleado findById(Integer id) {
        Empleado emp = null;
        try (PreparedStatement sentencia = conexion.prepareStatement(FINDBYID)) {
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                emp = convertToEmpleado(rs);
            }
            rs.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return emp;
    }

    @Override
    public void save(Empleado emp) {
        try (PreparedStatement sentencia = conexion.prepareStatement(SAVE)) {
            sentencia.setInt(1, emp.getId());
            sentencia.setString(2, emp.getNombre());
            sentencia.setString(3, emp.getApellido());
            sentencia.setString(4, emp.getEmail());
            sentencia.setDouble(5, emp.getSueldo());
            sentencia.executeUpdate();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Empleado emp) {
        try (PreparedStatement sentencia = conexion.prepareStatement(UPDATE)){
            sentencia.setInt(1, emp.getId());
            sentencia.setString(2, emp.getNombre());
            sentencia.setString(3, emp.getApellido());
            sentencia.setString(4, emp.getEmail());
            sentencia.setDouble(5, emp.getSueldo());
            sentencia.executeUpdate();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement sentencia = conexion.prepareStatement(DELETE)) {
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private Empleado convertToEmpleado(ResultSet rs) throws SQLException {
        return new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("email"), rs.getDouble("sueldo"));
    }
}
