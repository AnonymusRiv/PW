package es.uco.pw.business.DTO;

/**
 * DTO para el concepto bono
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class BonoDTO {
	private int id;
    private String userID;
    private String caducity;
    private int session;
    private type typeRes;
    public enum type{
        infantil, familiar, adultos
    };
    
    /**
     * Constructor sin parámetros
     * @param none
     */
    
    public BonoDTO() {
		super();
	}
    
    /**
     * Constructor con parámetros
     * @param id
     * @param userId
     * @param caducity
     * @param session
     * @param typeRes
     */
    
    public BonoDTO(int id, String userID, String caducity, int session, type typeRes) {
		super();
		this.id = id;
		this.userID = userID;
		this.caducity = caducity;
		this.session = session;
		this.typeRes = typeRes;
	}
    
    
    /**
     * Método público para obtener el id 
     * @param none
     * @return id
     */
    
    public int getId() {
		return id;
	}

    /**
     * Método público para establecer el id 
     * @param id
     * @return none
     */
    
	public void setId(int id) {
		this.id = id;
	}

	/**
     * Método público para obtener el nombre 
     * @param none
     * @return userID
     */
	
	public String getUserID() {
		return userID;
	}

	/**
     * Método público para establecer el nombre 
     * @param userId
     * @return none
     */
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
     * Método público para obtener la caducidad 
     * @param none
     * @return caducity
     */
	
	public String getCaducity() {
		return caducity;
	}

	/**
     * Método público para establecer la caducidad
     * @param caducity
     * @return none
     */
	
	public void setCaducity(String caducity) {
		this.caducity = caducity;
	}

	/**
     * Método público para obtener el numero de sesiones restantes 
     * @param none
     * @return session
     */
	
	public int getSession() {
		return session;
	}

	/**
     * Método público para establecer el numero de sesiones restantes 
     * @param name
     * @return none
     */
	
	public void setSession(int session) {
		this.session = session;
	}

	/**
     * Método público para obtener el tipo de reservas del bono 
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
     * @return Bono info del bono
     */
	
	@Override
	public String toString() {
		return "BonoDTO [id=" + id + ", userID=" + userID + ", caducity=" + caducity + ", session=" + session
				+ ", typeRes=" + typeRes + "]";
	}
    
}