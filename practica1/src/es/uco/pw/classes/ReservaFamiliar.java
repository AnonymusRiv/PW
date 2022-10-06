package es.uco.pw.classes;

public class ReservaFamiliar extends Reserva{
	
private int number;
	
	/**
	 * Constructor sin parámetros
	 * @param none
	 */
	
	public ReservaFamiliar() {
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
	 * @return ReservaFamiliar info de la reserva infantil
	 */
	
	@Override
	public String toString() {
		return "ReservaFamiliar [number=" + number + "]";
	}
	
	@Override
	public ReservaIndividual crearReservaIndividual() {
		ReservaIndividual reserva = new ReservaIndividual();
		return reserva;
	}
	
	@Override
	public ReservaBono crearReservaBono() {
		ReservaBono reserva = new ReservaBono();
		return reserva;
	}

}
