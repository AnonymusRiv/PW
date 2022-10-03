
/**
 * Clase Kart
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public class Kart {
	private int id;				//identificador del kart
	private boolean type;		//tipo de kart, true para adulto o false para niños
	private status status;		//estado del kart
	public enum status			//posibles valores para el estado del kart
	{
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
	
	public Kart(int id, boolean type, status status) {
		this.id=id;
		this.type=type;
		this.status=status;
	}
	
	/**
	 * Método público para obtener el id 
	 * @param none
	 */
	
	public int getid() {
		return id;
	}
	
	/**
	 * Método público para establecer el id 
	 * @param id
	 */
	
	public void setid(int id) {
		this.id=id;
	}
	
	/**
	 * Método público para obtener el tipo 
	 * @param none
	 */
	
	public boolean gettype() {
		return type;
	}
	
	/**
	 * Método público para establecer el tipo 
	 * @param type
	 */
	
	public void settype(boolean type) {
		this.type=type;
	}
	
	/**
	 * Método público para obtener el estado 
	 * @param none
	 */
	
	public status getstatus() {
		return status;
	}
	
	/**
	 * Método público para establecer el estado 
	 * @param status
	 */
	
	public void setstatus(status status) {
		this.status=status;
	}

	/**
	 * Método público para  imprimir la información
	 * @param none
	 */
	
	@Override
	public String toString() {
		return "Kart [id=" + id + ", type=" + type + ", status=" + status + "]";
	}
	
}
