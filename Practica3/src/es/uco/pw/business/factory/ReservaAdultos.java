package es.uco.pw.business.factory;

import java.util.Date;

/**
 * Clase ReservaAdultos
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public class ReservaAdultos extends Reserva {
    private int participants;
    
    private int bondId;
    private int nSession;

    /**
     * Constructor sin parámetros
     * @param none
     */
    
    public ReservaAdultos() {
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
     * @param participants
     */
    
    public ReservaAdultos(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int participants) {
        super(userId, date, duration, pistId, price, discount, typeRes);
        this.participants = participants;
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
     * @param participants
     * @param bondId
     * @param nSession
     */
    
    public ReservaAdultos(String userId, Date date, int duration, String pistId, float price, float discount, type typeRes, int participants, int bondId, int nSession) {
        super(userId, date, duration, pistId, price, discount, typeRes);
        this.participants = participants;
        this.bondId=bondId;
        this.nSession=nSession;
    }

    /**
     * Método público para obtener el numero de participantes
     * @param none
     * @return participants
     */
    
    public int getParticipants() {
        return participants;
    }

    /**
     * Método público para establecer el número de participantes 
     * @param participants
     * @return none
     */
    
    public void setParticipants(int participants) {
        this.participants = participants;
    }

    /**
     * Método público para imprimir la información
     * @param none
     * @return ReservaAdultos info de la reserva infantil
     */
    
    @Override
    public String toString() {
        return "ReservaAdultos [participants=" + participants + "]";
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
    
}