package ConnexSql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;


public class Script {

	public static void main(String[] args) throws SQLException {
		String scriptPath = "resources/scriptmysql.sql";
		String scriptContent = LeerString(scriptPath);
		/*String scriptPath = "";
		String scriptContent = LeerString(scriptPath);
		Connection conexion = DriverManager.getConnection("");
		Statement s = conexion.createStatement();
		s.execute(scriptContent);
		System.out.println("Script Ejecutado a la perfeccion");
		*/System.out.println("[-]El contenido del script es el siguiente[-]");
		System.out.println(scriptContent);
	}

	public static String LeerString(String ruta) {
		StringBuilder script = new StringBuilder();
		try (BufferedReader in = new BufferedReader(new FileReader(ruta))) {
			String line;
			while ((line = in.readLine()) != null) {
				script.append(line).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return script.toString();
	}
}
