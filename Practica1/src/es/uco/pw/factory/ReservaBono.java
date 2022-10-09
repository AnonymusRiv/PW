package es.uco.pw.factory;

/**
 * Clase ReservaBono
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public abstract class ReservaBono extends CrearReserva {
	
	public ReservaInfantil createReservaInfantil() {
		ReservaInfantil reserva= new ReservaInfantil();
		return reserva;
	}
	
	public ReservaFamiliar createReservaFamiliar() {
		ReservaFamiliar reserva=new ReservaFamiliar();
		return reserva;
		
	}
	
	public ReservaAdultos createReservaAdultos() {
		ReservaAdultos reserva=new ReservaAdultos();
		return reserva;
	}
}
