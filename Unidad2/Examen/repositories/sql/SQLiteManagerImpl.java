package repositories.sql;

import repositories.*;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteManagerImpl implements DaoManager {
    final String RUTABASE = Path.of("/home/carpui/IdeaProjects/AD/Unidad2/Examen/DataBase/examen.db").toString();

    private Connection conexion;

    private DepartamentoDAO dep = null;
    private DireccionDAO dir = null;
    private EmpleadoDAO emp = null;
    private EmpleadoDepartamentoDAO empDep = null;

    public SQLiteManagerImpl() {
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + RUTABASE);
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void close() {
        try {
            conexion.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        if (dep == null) {
            dep = new repositories.sql.SQLiteDepartamentoDAOImpl(conexion);
        }
        return dep;
    }

    @Override
    public DireccionDAO getDireccionDAO() {
        if (dir == null) {
            dir = new repositories.sql.SQLiteDireccionDAOImpl(conexion);
        }
        return dir;
    }

    @Override
    public EmpleadoDAO getEmpleadoDAO() {
        if (emp == null) {
            emp = new repositories.sql.SQLiteEmpleadoDAOImpl(conexion);
        }
        return emp;
    }

    @Override
    public EmpleadoDepartamentoDAO getEmpleadoDepartamentoDAO() {
        if (empDep == null) {
            //empDep = new repositories.sql.SQLiteEscuderiaDAOImpl(conexion);
        }
        return empDep;
    }
}
