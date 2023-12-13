package ConnexSql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Inserccion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 		if (args.length != 7) {
			System.out.println("Error: Deben ser proporcionados 7 argumentos.");
			return;
		}

		int employeeNumber, director, departmentNumber;
		double salary, commission;

		try {
			employeeNumber = Integer.parseInt(args[0]);
			director = Integer.parseInt(args[3]);
			salary = Double.parseDouble(args[4]);
			commission = Double.parseDouble(args[5]);
			departmentNumber = Integer.parseInt(args[6]);
		} catch (NumberFormatException e) {
			System.out.println("Error: Alguno de los argumentos numéricos no es válido.");
			return;
		}

		if (salary <= 0) {
			System.out.println("Error: El salario debe ser mayor que 0.");
			return;
		}

		String lastName = args[1];
		String job = args[2];

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_de_datos",
				"usuario", "contraseña")) {
			if (!existeDepartamento(connection, departmentNumber)) {
				System.out.println("Error: El departamento no existe en la tabla departamentos.");
				return;
			}

			if (existeEmpleado(connection, employeeNumber)) {
				System.out.println("Error: El número de empleado ya existe en la tabla empleados.");
				return;
			}

			if (!existeEmpleado(connection, director)) {
				System.out.println("Error: El director no existe en la tabla empleados.");
				return;
			}

			LocalDate hireDate = LocalDate.now();
			String query = "INSERT INTO empleados (emp_no, apellido, oficio, dir, salario, comision, fecha_alta, dept_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, employeeNumber);
				statement.setString(2, lastName);
				statement.setString(3, job);
				statement.setInt(4, director);
				statement.setDouble(5, salary);
				statement.setDouble(6, commission);
				statement.setDate(7, Date.valueOf(hireDate));
				statement.setInt(8, departmentNumber);

				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("Empleado insertado correctamente.");
				} else {
					System.out.println("Error al insertar el empleado.");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error SQL: " + e.getMessage());
		}
	}

	private static boolean existeDepartamento(Connection conn, int deptNo) throws SQLException {
		String query = "SELECT * FROM departamentos WHERE dept_no = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, deptNo);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

	private static boolean existeEmpleado(Connection conn, int empNo) throws SQLException {
		String query = "SELECT * FROM empleados WHERE emp_no = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, empNo);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}*/
		/*if(args.length<7) {
			System.out.println("No son los parametros esperados, esos son 7");
			return;
		}
		
		int EmpNu ,director,DepNu;
		Double Salario,comision;
		String Apellido,trabajo;
		
		try {
			
			EmpNu = Integer.parseInt(args[0]);
			director = Integer.parseInt(args[3]);
			DepNu= Integer.parseInt(args[4]);
			Salario=Double.parseDouble(args[5]);
			comision= Double.parseDouble(args[6]);
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Alguno de los datos introducidos no esta en su formato");
			
		}
		
		if(Salario<=0) {
			System.out.println("");
			return;
		}
		Apellido = args[1];
		trabajo = args[2];
		
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_de_datos",
				"usuario", "contraseña");
			if (!existeDepartamento(conexion, DepNu)) {
				System.out.println("Error: El departamento no existe en la tabla departamentos.");
				return;
			}

			if (existeEmpleado(conexion, EmpNu)) {
				System.out.println("Error: El número de empleado ya existe en la tabla empleados.");
				return;
			}

			if (!existeEmpleado(conexion, director)) {
				System.out.println("Error: El director no existe en la tabla empleados.");
				return;
			}

			LocalDate hireDate = LocalDate.now();
			String query = "INSERT INTO empleados (emp_no, apellido, oficio, dir, salario, comision, fecha_alta, dept_no) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement statement = conexion.prepareStatement(query)) {
				statement.setInt(1, EmpNu);
				statement.setString(2, Apellido);
				statement.setString(3, trabajo);
				statement.setInt(4, director);
				statement.setDouble(5, Salario);
				statement.setDouble(6, comision);
				statement.setDate(7, Date.valueOf(hireDate));
				statement.setInt(8, DepNu);

				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("Empleado insertado correctamente.");
				} else {
					System.out.println("Error al insertar el empleado.");
				}
			}
		} catch (SQLException e) {
			System.out.println("Error SQL: " + e.getMessage());
		}
	}

	private static boolean existeDepartamento(Connection conn, int deptNo) throws SQLException {
		String query = "SELECT * FROM departamentos WHERE dept_no = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, deptNo);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
	}

	private static boolean existeEmpleado(Connection conn, int empNo) throws SQLException {
		String query = "SELECT * FROM empleados WHERE emp_no = ?";
		try (PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setInt(1, empNo);
			try (ResultSet rs = stmt.executeQuery()) {
				return rs.next();
			}
		}
		*/
	}

}
