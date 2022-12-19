import models.Departamento;
import models.Direccion;
import models.Empleado;
import models.Escuderia;
import repositories.sql.SQLiteManagerImpl;

public class ExamenTema2 {
    public static void main(String[] args) {
        SQLiteManagerImpl departamento = new SQLiteManagerImpl();
        /*//Departamentos
        System.out.println("\nMostrar todos los departamentos");
        System.out.println("-------------------------------");
        departamento.getDepartamentoDAO().findAll().forEach(System.out::println);

        System.out.println("\nMostrar solo un departamento");
        System.out.println("-------------------------------");
        System.out.println(departamento.getDepartamentoDAO().findById(4));

        System.out.println("\nInsertar un departamento");
        System.out.println("-------------------------------");
        Departamento dep = new Departamento(9, "Marketing2");
        departamento.getDepartamentoDAO().save(dep);
        departamento.getDepartamentoDAO().findAll().forEach(System.out::println);

        System.out.println("\nActualizar un departamento");
        System.out.println("-------------------------------");
        dep.setNombre("Administracion");
        departamento.getDepartamentoDAO().update(dep);
        departamento.getDepartamentoDAO().findAll().forEach(System.out::println);

        System.out.println("\nBorrar una departamento");
        System.out.println("-------------------------------");
        departamento.getDepartamentoDAO().deleteById(9);
        departamento.getDepartamentoDAO().findAll().forEach(System.out::println);
        departamento.close();*/

        //Empleados con direccion
        System.out.println("\nInsertar un empleado");
        System.out.println("-------------------------------");
        Empleado emp = new Empleado(31, "Carlos", "Exposito", "carlos@gmail.com", 6578.98);
        departamento.getEmpleadoDAO().save(emp);
        departamento.getEmpleadoDAO().findAll().forEach(System.out::println);

        System.out.println("\nInsertar una direccion");
        System.out.println("-------------------------------");
        Direccion dir = new Direccion(31, emp, "pepeito 32", "Castellon", "España");
        departamento.getDireccionDAO().save(dir);
        departamento.getDireccionDAO().findAll().forEach(System.out::println);

        System.out.println("\nActualizar un empleado");
        System.out.println("-------------------------------");
        emp.setNombre("Administracion");
        emp.setApellido("Pepe");
        emp.setEmail("Roberto");
        emp.setEmail("pepe@gmail.com");
        emp.setSueldo(1000.00);
        departamento.getEmpleadoDAO().update(emp);
        departamento.getEmpleadoDAO().findAll().forEach(System.out::println);

        System.out.println("\nBorrar una empleado");
        System.out.println("-------------------------------");
        departamento.getDepartamentoDAO().deleteById(9);
        departamento.getDepartamentoDAO().findAll().forEach(System.out::println);
        departamento.close();
    }
}
