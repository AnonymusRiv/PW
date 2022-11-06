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
    
    private int bondId;
    private int nSession;
    
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
     * Constructor con parámetros
     * @param userid
     * @param date
     * @param duration
     * @param pistId
     * @param price
     * @param discount
     * @param typeRes
     * @param nChild
     * @param bondId
     * @param nSession
     */
    
    public ReservaInfantil(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int nChild, int bondId, int nSession) {
        super(userId, date, duration, pistId, price, discount, typeRes);
        this.nChild = nChild;
        this.bondId=bondId;
        this.nSession=nSession;
    }

    /**
     * Método público para obtener el id del bono
     * @param none
     * @return bonoId
     */
    
    public int getBondId() {
        return bondId;
    }

    /**
     * Método público para establecer el id del bono
     * @param bonoId
     * @return none
     */
    
    public void setBondId(int bondId) {
        this.bondId = bondId;
    }

    /**
     * Método público para obtener el número de sesiones
     * @param none
     * @return nSession
     */
    
    public int getnSession() {
        return nSession;
    }

    /**
     * Método público para establecer el número de sesiones 
     * @param nSession
     * @return none
     */
    
    public void setnSession(int nSession) {
        this.nSession = nSession;
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