package es.uco.pw.classes;

/**
 * Clase Kart
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public class Kart {
	private int id;
	private boolean type; //false=niño  true=adulto
	private status stat;
	public enum status{
		disponible, reservado, mantenimiento
	};
	
	/**
	 * Constructor sin parámetros
	 * @param none
	 */
	
	public Kart() {
		super();
	}

	/**
	 * Constructor con parámetros
	 * @param id
	 * @param type
	 * @param status
	 */
	
	public Kart(int id, boolean type, es.uco.pw.classes.Kart.status status) {
		super();
		this.id = id;
		this.type = type;
		this.stat = status;
	}

	/**
	 * Método público para obtener el id 
	 * @param none
	 * @return id
	 */
	
	public int getId() {
		return id;
	}

	/**
	 * Método público para establecer el id 
	 * @param id
	 * @return none
	 */
	
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Método público para obtener el tipo 
	 * @param none
	 * @return type
	 */
	
	public boolean isType() {
		return type;
	}
	/**
	 * Método público para establecer el tipo 
	 * @param type
	 * @return none
	 */
	
	public void setType(boolean type) {
		this.type = type;
	}

	/**
	 * Método público para obtener el estado 
	 * @param none
	 * @return stat
	 */
	
	public status getStatus() {
		return stat;
	}

	/**
	 * Método público para establecer el estado 
	 * @param status
	 * @return none
	 */
	
	public void setStatus(status status) {
		this.stat = status;
	}

	/**
	 * Método público para imprimir la información
	 * @param none
	 * @return kart info del kart
	 */
	
	@Override
	public String toString() {
		return "Kart [id=" + id + ", type=" + type + ", status=" + stat + "]";
	}
	
}
