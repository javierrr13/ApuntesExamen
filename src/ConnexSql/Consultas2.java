package ConnexSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas2 {

	public static void main(String[] args) {
		
		/*Creaccion de conexion, creaccion de estado, a partir de ahi 
		 * comienza todo, en este caso creamos un boolean para saber 
		 * la ejecuccion de la consulta, en el momento en el que el Boolean
		 * adquiere un valor diferente a true, la consulta finaliza
		 * una vez entramos en el if contamos los registros moviendonos
		 * por los resultados creados por un rs
		 * */		
		// TODO Auto-generated method stub
		try {
			String query = "";
			Connection conexion = DriverManager.getConnection("");
			Statement s = conexion.createStatement();
			Boolean valor = s.execute(query);
			if(valor) {
				ResultSet rs = s.getResultSet();
				rs.last();
				System.out.println("El numero de registros es de " + rs.getRow());
				rs.beforeFirst();
				while(rs.next()) {
					System.out.printf("%d = %s %s %s ", rs.getRow(), rs.getString(0),rs.getString(1),rs.getString("dept_no"));
					
				}rs.close();
			}else {
				int cambiadas = s.getUpdateCount();
				System.out.printf("%d", cambiadas , " filas cambiadas");
			}
			
		}catch(SQLException e ) {
			e.printStackTrace();
			System.out.println("Error en el procedimiento");
		}
	}

}
