package es.uco.pw.classes;
import java.util.Date;

/**
 * Clase Reserva
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public abstract class Reserva {

	private String userid;
	private Date reserve;
	private int duration;
	private String pistaid;
	private float price;
	private int discount;
	private type typeRes;
	
	public enum type{
		infantil, familiar, adultos;
	};
	
	/**
	 * Constructor sin parámetros
	 * @param none
	 */
	
	public Reserva() {
		super();
	}

	/**
	 * Método público para obtener el id del usuario 
	 * @param none
	 * @return userid
	 */
	
	public String getUserid() {
		return userid;
	}

	/**
	 * Método público para establecer el id del usuario 
	 * @param userid
	 * @return none
	 */
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * Método público para obtener la fecha de reserva 
	 * @param none
	 * @return reserve
	 */
	
	public Date getReserve() {
		return reserve;
	}

	/**
	 * Método público para establecer la fecha de reserva 
	 * @param reserve
	 * @return none
	 */
	
	public void setReserve(Date reserve) {
		this.reserve = reserve;
	}

	/**
	 * Método público para obtener la duracion 
	 * @param none
	 * @return duration
	 */
	
	public int getDuration() {
		return duration;
	}

	/**
	 * Método público para establecer la duracion 
	 * @param duration
	 * @return none
	 */
	
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Método público para obtener el id de la pista 
	 * @param none
	 * @return pistaid
	 */
	
	public String getPistaid() {
		return pistaid;
	}

	/**
	 * Método público para establecer el id de la pista 
	 * @param pistaid
	 * @return none
	 */
	
	public void setPistaid(String pistaid) {
		this.pistaid = pistaid;
	}

	/**
	 * Método público para obtener el precio 
	 * @param none
	 * @return price
	 */
	
	public float getPrice() {
		return price;
	}

	/**
	 * Método público para establecer el precio 
	 * @param price
	 * @return none
	 */
	
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Método público para obtener el descuento 
	 * @param none
	 * @return discount
	 */
	
	public int getDiscount() {
		return discount;
	}

	/**
	 * Método público para establecer el descuento 
	 * @param discount
	 * @return none
	 */
	
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	/**
	 * Método público para obtener el tipo de reserva 
	 * @param none
	 * @return typeRes
	 */
	
	public type getType() {
		return typeRes;
	}

	/**
	 * Método público para establecer el tipo de reserva 
	 * @param typeRes
	 * @return none
	 */
	
	public void setType(type typeRes) {
		this.typeRes = typeRes;
	}

	
	/**
	 * Método público para imprimir la información
	 * @param none
	 * @return Reserva info de la reserva
	 */
	
	@Override
	public String toString() {
		return "Reserva [userid=" + userid + ", reserve=" + reserve + ", duration=" + duration + ", pistaid=" + pistaid
				+ ", price=" + price + ", discount=" + discount + "]";
	}
	
	public abstract ReservaIndividual crearReservaIndividual();
	
	public abstract ReservaBono crearReservaBono();
}
