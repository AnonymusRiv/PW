package es.uco.pw.business.factory;

import java.util.Date;

import es.uco.pw.business.factory.Reserva.type;;

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
	
	public ReservaInfantil createReservaInfantil(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int nChild) {
		ReservaInfantil reserva= new ReservaInfantil(userId, date, duration, pistId, price, discount, typeRes, nChild);
		return reserva;
	}
	
	/**
	 * Método público para crear una reserva familiar
	 * @param none
	 * @return reserva
	 */
	
	public ReservaFamiliar createReservaFamiliar(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int nAdults, int nChild) {
		ReservaFamiliar reserva=new ReservaFamiliar(userId, date, duration, pistId, price, discount, typeRes, nAdults, nChild);
		return reserva;	
	}
	
	/**
	 * Método público para crear una reserva adultos
	 * @param none
	 * @return reserva
	 */
	
	public ReservaAdultos createReservaAdultos(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int participants) {
		ReservaAdultos reserva=new ReservaAdultos(userId, date, duration, pistId, price, discount, typeRes, participants);
		return reserva;
	}

    @Override
    public ReservaInfantil createReservaInfantil() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReservaFamiliar createReservaFamiliar() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReservaAdultos createReservaAdultos() {
        // TODO Auto-generated method stub
        return null;
    }

}