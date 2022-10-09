package es.uco.pw.factory;

/**
 * Clase CrearReserva
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public abstract class CrearReserva {
	public abstract ReservaInfantil createReservaInfantil();
	public abstract ReservaFamiliar createReservaFamiliar();
	public abstract ReservaAdultos createReservaAdultos();
}
