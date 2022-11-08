package es.uco.pw.business.DTO;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * DTO para el concepto reserva infantil
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class ReservaInfantilDTO {
    private String userId;
    private Date date;
    private int duration;
    private String pistId;
    private float price;
    private float discount;
    private int nChildren;
    
    /**
     * Constructor sin parámetros
     * @param none
     */
    
    public ReservaInfantilDTO() {
       
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

    public ReservaInfantilDTO(String userId, Date date, int duration, String pistId, float price, float discount,
            int nChildren) {
        this.userId = userId;
        this.date = date;
        this.duration = duration;
        this.pistId = pistId;
        this.price = price;
        this.discount = discount;
        this.nChildren = nChildren;
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
     * Método público para obtener el número de niños
     * @param none
     * @return discount
     */

    public int getnChildren() {
        return nChildren;
    }
    
    /**
     * Método público para establecer el número de niños
     * @param discount
     * @return none
     */

    public void setnChildren(int nChildren) {
        this.nChildren = nChildren;
    }
    
    /**
     * Método público para imprimir la información
     * @param none
     * @return Reserva info de la reserva
     */

    @Override
    public String toString() {
        return "ReservaInfantilDTO [userId=" + userId + ", date=" + date + ", duration=" + duration + ", pistId="
                + pistId + ", price=" + price + ", discount=" + discount + ", nChildren=" + nChildren + "]";
    }
   
}