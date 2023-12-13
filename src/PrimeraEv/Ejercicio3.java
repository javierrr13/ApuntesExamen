package PrimeraEv;

import java.io.File;
import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String route = System.getProperty("user.home") + "/Desktop";
		String rutaDirectorio = route + "/DirectorioPrueba";
		String directoryName = "DirectorioPrueba";
		String filename = "file.txt";

		File directory = new File(route, directoryName);
		File file = new File(rutaDirectorio, filename);

		boolean c = directory.mkdir();
		boolean x = file.createNewFile();

		try {
			if (c) {
				System.out.println("Directorio creado con exito en la ruta especificada");
				if (x) {
					System.out.println("Archivo creado con exito en el directorio");
				} else {
					System.out.println("Archivo no creado");
				}

			} else {
				System.out.println("Error al crear directorio probaremos a eliminarlo, probaremos eliminandolo...");
				Thread.sleep(5000);

				boolean borrado = borrarDirectorio(directory);
				if (borrado) {
					System.out.println("Directorio borrado exitosamente");
				} else {
					System.out.println("No se ha logrado borrar el directorio");
				}

			}
		} catch (SecurityException e) {
			System.out.println("No se tienen permisos para crear el directorio: " + e.getMessage());
		}

	}

	private static boolean borrarDirectorio(File directory) {
		if (directory.isDirectory()) {
			File[] archivos = directory.listFiles();
			if (archivos != null) {
				for (File archivo : archivos) {
					borrarDirectorio(archivo);
				}
			}
		}
		return directory.delete();
	}

}
