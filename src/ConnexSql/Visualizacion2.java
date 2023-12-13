package ConnexSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class Visualizacion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("Los valores introducidos no son los validos");
		}
		String url = "";
		String usuario = "";
		String contraseña = "";
		
		int deptID = Integer.parseInt(args[0]);

		DecimalFormat formatosalario = new DecimalFormat("##,##,00");

		try {

			Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
			String query = "SELECT e.APELLIDO, e.SALARIO, e.OFICIO, d.NOMBRE " + "FROM empleados e "
					+ "JOIN departamentos d ON e.DEPT_NO = d.DEPT_NO " + "WHERE e.DEPT_NO = ?";

			String querySalarioMedio = "SELECT COUNT(*) as numEmpleados, AVG(SALARIO) as salarioMedio "
					+ "FROM empleados " + "WHERE DEPT_NO = ?";
			try {
				PreparedStatement statement = conexion.prepareStatement(query);
				PreparedStatement statementSalario = conexion.prepareStatement(querySalarioMedio);
				
				statement.setInt(1, deptID);
				ResultSet rs = statement.executeQuery();
				
				if(!rs.isBeforeFirst()) {
					System.out.println("Datos introducidos no validos");
					return;
				}
				System.out.println("[-]Informacion extraida -> ");
				while(rs.next()) {
					System.out.println("Apellido: " + rs.getString("APELLIDO") +
                            ", Salario: " + formatosalario.format(rs.getFloat("SALARIO")) +
                            ", Oficio: " + rs.getString("OFICIO") +
                            ", Departamento: " + rs.getString("NOMBRE"));
				}
				statementSalario.setInt(1, deptID);
				ResultSet rsSalario = statement.executeQuery();
				  if (rsSalario.next()) {
	                    int numEmpleados = rsSalario.getInt("numEmpleados");
	                    double salarioMedio = rsSalario.getDouble("salarioMedio");

	                    System.out.println("\nSalario medio del departamento: " + formatosalario.format(salarioMedio));
	                    System.out.println("Número de empleados en el departamento: " + numEmpleados);
	                }
				  rs.close();
				  rsSalario.close();
			}catch(SQLException e ) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
