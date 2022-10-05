package es.uco.pw.classes;

public class ReservaAdultos extends Reserva{
	
	private int number;
	
	/**
	 * Constructor sin parámetros
	 * @param none
	 */
	
	public ReservaAdultos() {
		super();
	}
	
	/**
	 * Método público para obtener el numero de usuarios
	 * @param none
	 * @return number
	 */
	
	public int getNumber() {
		return number;
	}

	/**
	 * Método público para establecer el número de usuarios 
	 * @param number
	 * @return none
	 */
	
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Método público para imprimir la información
	 * @param none
	 * @return ReservaAdultos info de la reserva infantil
	 */
	
	@Override
	public String toString() {
		return "ReservaAdultos [number=" + number + "]";
	}

}
