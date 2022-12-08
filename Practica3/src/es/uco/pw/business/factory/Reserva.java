package es.uco.pw.business.factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase Reserva
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public abstract class Reserva {
	private int Id;
    private String userId;
	private Date date;
	private int duration;
	private String pistId;
	private float price;
	private float discount;
	private type typeRes;
	
	public enum type{
		infantil, familiar, adultos
	}
	
	/**
	 * Constructor sin parámetros
	 * @param none
	 */
	
	public Reserva() {
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
	 */
	
	public Reserva(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes) {
		super();
		this.userId = userId;
		this.date = date;
		this.duration = duration;
		this.pistId = pistId;
		this.price = price;
		this.discount = discount;
		this.typeRes = typeRes;
	}
	

    /**
     * Método público para obtener el id de la reserva
     * @param none
     * @return id
     */
    
    public int getId() {
        return Id;
    }
    
    /**
     * Método público para establecer el id de la reserva 
     * @param id
     * @return none
     */
    
    public void setId(int Id) {
        this.Id = Id;
    }


	/**
	 * Método público para obtener el id del usuario 
	 * @param none
	 * @return userid
	 */
	
	public String getUserId() {
		return userId;
	}
	
	/**
	 * Método público para establecer el id del usuario 
	 * @param userid
	 * @return none
	 */
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Método público para obtener la fecha de reserva 
	 * @param none
	 * @return date
	 */
	
	public Date getDate() {
		return date;
	}
	
	/**
	 * Método público para establecer la fecha de reserva 
	 * @param date
	 * @return none
	 */
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
     * Método público para establecer la fecha de reserva 
     * @param dat
     * @return none
     */
    
    public void setDate(String dat) throws ParseException {
        Date d=new SimpleDateFormat("dd/MM/yyyy").parse(dat);
        date=d;
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
	 * @return pistId
	 */
	
	public String getPistId() {
		return pistId;
	}
	
	/**
	 * Método público para establecer el id de la pista 
	 * @param pistId
	 * @return none
	 */
	
	public void setPistId(String pistId) {
		this.pistId = pistId;
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
	
	public float getDiscount() {
		return discount;
	}
	
	/**
	 * Método público para establecer el descuento 
	 * @param discount
	 * @return none
	 */
	
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	/**
	 * Método público para obtener el tipo de reserva 
	 * @param none
	 * @return typeRes
	 */
	
	public type getTypeRes() {
		return typeRes;
	}
	
	/**
	 * Método público para establecer el tipo de reserva 
	 * @param typeRes
	 * @return none
	 */
	
	public void setTypeRes(type typeRes) {
		this.typeRes = typeRes;
	}
	
	/**
	 * Método público para imprimir la información
	 * @param none
	 * @return Reserva info de la reserva
	 */
	
	@Override
	public String toString() {
		return "Reserva [userId=" + userId + ", date=" + date + ", duration=" + duration + ", pistId=" + pistId
				+ ", price=" + price + ", discount=" + discount + ", typeRes=" + typeRes + "]";
	}
}