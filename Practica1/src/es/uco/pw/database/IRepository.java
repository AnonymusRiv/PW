package es.uco.pw.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface IRepository {
	public abstract boolean saveSystem() throws IOException; //Interfaz para guardar el estado del sistema
	public abstract boolean loadSystem()
		    throws FileNotFoundException, IOException, ParseException; //Interfaz para cargar el sistema
}
