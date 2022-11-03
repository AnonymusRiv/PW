package es.uco.pw.business.factory;

import java.util.Date;

import es.uco.pw.business.factory.Reserva.type;

/**
 * Clase CrearReserva
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public abstract class CrearReserva {
	public abstract ReservaInfantil createReservaInfantil(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int nChild);
	public abstract ReservaFamiliar createReservaFamiliar(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int nAdults, int nChild);
	public abstract ReservaAdultos createReservaAdultos(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int participants);
}

