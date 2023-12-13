package ConnexSql;

import java.sql.*;
import java.text.DecimalFormat;

public class Visualizacion {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Por favor, proporciona un valor para el departamento.");
            return;
        }

        int deptoId = Integer.parseInt(args[0]);

        String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
        String usuario = "tu_usuario";
        String contraseña = "tu_contraseña";

        DecimalFormat formatoSalario = new DecimalFormat("##,###.00");

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String query = "SELECT e.APELLIDO, e.SALARIO, e.OFICIO, d.NOMBRE " +
                           "FROM empleados e " +
                           "JOIN departamentos d ON e.DEPT_NO = d.DEPT_NO " +
                           "WHERE e.DEPT_NO = ?";
            
            String querySalarioMedio = "SELECT COUNT(*) as numEmpleados, AVG(SALARIO) as salarioMedio " +
                                       "FROM empleados " +
                                       "WHERE DEPT_NO = ?";
            
            try (PreparedStatement statement = conexion.prepareStatement(query);
                 PreparedStatement statementSalarioMedio = conexion.prepareStatement(querySalarioMedio)) {

                statement.setInt(1, deptoId);
                ResultSet rs = statement.executeQuery();

                if (!rs.isBeforeFirst()) {
                    System.out.println("El departamento no existe en la tabla departamentos.");
                    return;
                }

                System.out.println("Información de empleados del departamento " + deptoId + ":");
                while (rs.next()) {
                    System.out.println("Apellido: " + rs.getString("APELLIDO") +
                            ", Salario: " + formatoSalario.format(rs.getFloat("SALARIO")) +
                            ", Oficio: " + rs.getString("OFICIO") +
                            ", Departamento: " + rs.getString("NOMBRE"));
                }

                statementSalarioMedio.setInt(1, deptoId);
                ResultSet rsSalarioMedio = statementSalarioMedio.executeQuery();

                if (rsSalarioMedio.next()) {
                    int numEmpleados = rsSalarioMedio.getInt("numEmpleados");
                    double salarioMedio = rsSalarioMedio.getDouble("salarioMedio");

                    System.out.println("\nSalario medio del departamento: " + formatoSalario.format(salarioMedio));
                    System.out.println("Número de empleados en el departamento: " + numEmpleados);
                }
                rs.close();
                rsSalarioMedio.close();
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

