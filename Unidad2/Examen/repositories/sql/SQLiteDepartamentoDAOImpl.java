package repositories.sql;

import dao.CircuitoDAO;
import models.Circuito;
import models.Departamento;
import repositories.DepartamentoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SQLiteDepartamentoDAOImpl implements DepartamentoDAO {
    final String FINDALL = "SELECT * FROM departamentos";
    final String FINDBYID = "SELECT * FROM departamentos WHERE id = ?";
    final String SAVE = "INSERT INTO departamentos (id, nombre) VALUES (?, ?)";
    final String UPDATE = "UPDATE departamentos SET nombre = ?, WHERE id = ?";
    final String DELETE = "DELETE FROM departamentos WHERE id = ?";

    private Connection conexion = null;

    public SQLiteDepartamentoDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Departamento> findAll() {
        List<Departamento> listaDepartamento = new ArrayList<>();
        try (PreparedStatement sentencia = conexion.prepareStatement(FINDALL);
             ResultSet rs = sentencia.executeQuery()){
            while (rs.next()) {
                listaDepartamento.add(convertToDepartamento(rs));
            }
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return listaDepartamento;
    }

    @Override
    public Departamento findById(Integer id) {
        Departamento dep = null;
        try (PreparedStatement sentencia = conexion.prepareStatement(FINDBYID)) {
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                dep = convertToDepartamento(rs);
            }
            rs.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return dep;
    }

    @Override
    public void save(Departamento dep) {
        try (PreparedStatement sentencia = conexion.prepareStatement(SAVE)) {
            sentencia.setInt(1, dep.getId());
            sentencia.setString(2, dep.getNombre());
            sentencia.executeUpdate();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Departamento dep) {
        try (PreparedStatement sentencia = conexion.prepareStatement(UPDATE)){
            sentencia.setInt(1, dep.getId());
            sentencia.setString(2, dep.getNombre());
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

    private Departamento convertToDepartamento(ResultSet rs) throws SQLException {
        return new Departamento(rs.getInt("id"), rs.getString("nombre"));
    }
}
