package dao.sql;

import dao.CircuitoDAO;
import dao.DAOManager;
import dao.EscuderiaDAO;
import dao.PilotoDAO;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDAOManagerImpl implements DAOManager {
    final String RUTABASE = Path.of("/home/carpui/IdeaProjects/AD/Unidad2/EjemploDAO/db/formula1.db").toString();

    private Connection conexion;

    private EscuderiaDAO escuderias = null;
    private PilotoDAO pilotos = null;
    private CircuitoDAO circuitos = null;

    public SQLiteDAOManagerImpl() {
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
    public EscuderiaDAO getEscuderiaDAO() {
        if (escuderias == null) {
            escuderias = new dao.sql.SQLiteEscuderiaDAOImpl(conexion);
        }
        return escuderias;
    }
    @Override
    public PilotoDAO getPilotoDAO() {
        if (pilotos == null) {
            pilotos = new dao.sql.SQLitePilotoDAOImpl(conexion, escuderias.findAll());
        }
        return pilotos;
    }
    @Override
    public CircuitoDAO getCircuitoDAO() {
        if (circuitos == null) {
            circuitos = new dao.sql.SQLiteCircuitoDAOImpl(conexion);
        }
        return circuitos;
    }
}
