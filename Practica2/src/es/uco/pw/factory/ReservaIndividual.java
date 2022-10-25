package es.uco.pw.factory;

/**
 * Clase ReservaIndividual
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public class ReservaIndividual extends CrearReserva {
	
	/**
	 * Método público para crear una reserva infantil
	 * @param none
	 * @return reserva
	 */
	
	public ReservaInfantil createReservaInfantil() {
		ReservaInfantil reserva= new ReservaInfantil();
		return reserva;
	}
	
	/**
	 * Método público para crear una reserva familiar
	 * @param none
	 * @return reserva
	 */
	
	public ReservaFamiliar createReservaFamiliar() {
		ReservaFamiliar reserva=new ReservaFamiliar();
		return reserva;
		
	}
	
	/**
	 * Método público para crear una reserva adultos
	 * @param none
	 * @return reserva
	 */
	
	public ReservaAdultos createReservaAdultos() {
		ReservaAdultos reserva=new ReservaAdultos();
		return reserva;
	}
}
