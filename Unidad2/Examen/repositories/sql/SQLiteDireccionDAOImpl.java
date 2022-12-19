package repositories.sql;

import models.Departamento;
import models.Direccion;
import models.Empleado;
import repositories.DepartamentoDAO;
import repositories.DireccionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDireccionDAOImpl implements DireccionDAO {
    final String FINDALL = "SELECT * FROM direcciones";
    final String FINDBYID = "SELECT * FROM direcciones WHERE id = ?";
    final String SAVE = "INSERT INTO direcciones (id, empleado_id, calle, ciudad, pais) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE direcciones SET nombre = ?, empleado_id = ?, calle = ?, ciudad = ?, pais = ?, WHERE id = ?";
    final String DELETE = "DELETE FROM direcciones WHERE id = ?";

    private Connection conexion = null;

    public SQLiteDireccionDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Direccion> findAll() {
        List<Direccion> listaDireccion = new ArrayList<>();
        try (PreparedStatement sentencia = conexion.prepareStatement(FINDALL);
             ResultSet rs = sentencia.executeQuery()){
            while (rs.next()) {
                listaDireccion.add(convertToDireccion(rs));
            }
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaDireccion;
    }

    @Override
    public Direccion findById(Integer id) {
        Direccion dir = null;
        try (PreparedStatement sentencia = conexion.prepareStatement(FINDBYID)) {
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                dir = convertToDireccion(rs);
            }
            rs.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return dir;
    }

    @Override
    public void save(Direccion dir) {
        try (PreparedStatement sentencia = conexion.prepareStatement(SAVE)) {
            sentencia.setInt(1, dir.getId());
            sentencia.setInt(2, dir.getEmpleadoID().getId());
            sentencia.setString(3, dir.getCalle());
            sentencia.setString(4, dir.getCiudad());
            sentencia.setString(5, dir.getPais());
            sentencia.executeUpdate();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Direccion dir) {
        try (PreparedStatement sentencia = conexion.prepareStatement(UPDATE)){
            sentencia.setInt(1, dir.getId());
            sentencia.setInt(2, dir.getEmpleadoID().getId());
            sentencia.setString(3, dir.getCalle());
            sentencia.setString(4, dir.getCiudad());
            sentencia.setString(5, dir.getPais());
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

    private Direccion convertToDireccion(ResultSet rs) throws SQLException {
        return new Direccion(rs.getInt("id"), (Empleado) rs.getObject("empleado_id"), rs.getString("apellido"), rs.getString("email"), rs.getString("sueldo"));
    }
}
