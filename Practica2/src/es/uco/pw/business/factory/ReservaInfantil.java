package es.uco.pw.business.factory;

import java.util.Date;

/**
 * Clase ReservaInfantil
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class ReservaInfantil extends Reserva{
private int nChild;
	
	/**
	 * Constructor sin parámetros
	 * @param none
	 */
	
	public ReservaInfantil() {
		super();
	}

	/**
	 * Constructor con parámetros
	 * @param userid
	 * @param date
	 * @param duration
	 * @param pistId
	 * @param price
	 * @param discount
	 * @param typeRes
	 * @param nChild
	 */
	
	public ReservaInfantil(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int nChild) {
		super(userId, date, duration, pistId, price, discount, typeRes);
		this.nChild = nChild;
	}

	/**
	 * Método público para obtener el número de niños
	 * @param none
	 * @return nChild
	 */
	
	public int getnChild() {
		return nChild;
	}

	/**
	 * Método público para establecer el número de nChild 
	 * @param nChild
	 * @return none
	 */
	
	public void setnChild(int nChild) {
		this.nChild = nChild;
	}

	/**
	 * Método público para imprimir la información
	 * @param none
	 * @return ReservaInfanil info de la reserva infantil
	 */
	
	@Override
	public String toString() {
		return "ReservaInfantil [nChild=" + nChild + "]";
	}
}
