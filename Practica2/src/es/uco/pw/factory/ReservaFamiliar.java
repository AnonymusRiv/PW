package es.uco.pw.factory;

import java.util.Date;

/**
 * Clase ReservaFamiliar
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

import es.uco.pw.factory.Reserva.type;

public class ReservaFamiliar extends Reserva {
	private int nAdults;
	private int nChild;
	
	/**
	 * Constructor sin parámetros
	 * @param none
	 */
	
	public ReservaFamiliar() {
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
	 * @param nAdults
	 * @param nChild
	 */
	
	public ReservaFamiliar(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int nAdults, int nChild) {
		super(userId, date, duration, pistId, price, discount, typeRes);
		this.nAdults = nAdults;
		this.nChild = nChild;
	}

	/**
	 * Método público para obtener el numero de adultos
	 * @param none
	 * @return nAdults
	 */
	
	public int getnAdults() {
		return nAdults;
	}

	/**
	 * Método público para establecer el número de adultos 
	 * @param nAdults
	 * @return none
	 */
	
	public void setnAdults(int nAdults) {
		this.nAdults = nAdults;
	}

	/**
	 * Método público para obtener el numero de niños
	 * @param none
	 * @return nChild
	 */
	
	public int getnChild() {
		return nChild;
	}

	/**
	 * Método público para establecer el número de niños 
	 * @param nChild
	 * @return none
	 */
	
	public void setnChild(int nChild) {
		this.nChild = nChild;
	}

	/**
	 * Método público para imprimir la información
	 * @param none
	 * @return ReservaFamiliar info de la reserva infantil
	 */
	
	@Override
	public String toString() {
		return "ReservaFamiliar [nAdults=" + nAdults + ", nChild=" + nChild + "]";
	}
	
}
