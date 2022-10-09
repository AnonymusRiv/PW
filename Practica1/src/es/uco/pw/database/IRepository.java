package es.uco.pw.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

/**
 * Interfaz para implementar los métodos encargados de leer y escribir
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @authos Silvia Roldán Flores
 * @version 1.0
 */

public interface IRepository {
	
	/**
	 * Función encargada de guardar el estado del sistema en almacenamiento
	 * @param none
	 * @return none
	 * @throws IOException
	 */
	
	public abstract boolean saveSystem() throws IOException;
	
	/**
	 * Implementación de la interfaz repository para trabajar con ficheros
	 * @author Moisés Moyano Cejudo
	 * @author Alba Palomino Jiménez
	 * @author Carlos Rivero Talavera
	 * @authos Silvia Roldán Flores
	 * @version 1.0
	 */
	
	public abstract boolean loadSystem()
		    throws FileNotFoundException, IOException, ParseException; //Interfaz para cargar el sistema
}