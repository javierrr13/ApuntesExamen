package ConnexSql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LeerScript {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/nombre_base_de_datos";
		String usuario = "tu_usuario";
		String contraseña = "tu_contraseña";
		String scriptFile = "scripts/script.sql"; // Ruta del archivo SQL

		String scriptContent = leerScriptSQL(scriptFile);
		System.out.println("Contenido del script SQL:");
		System.out.println("-------------------------");
		System.out.println(scriptContent);
		System.out.println("-------------------------");

		/*try (Connection connection = DriverManager.getConnection(jdbcURL, usuario, contraseña);
				Statement statement = connection.createStatement()) {

			statement.execute(scriptContent);
			System.out.println("Script SQL ejecutado correctamente.");

		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	private static String leerScriptSQL(String filePath) {
		StringBuilder script = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				script.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return script.toString();
	}
}



