package es.uco.pw.display.javabean;

import es.uco.pw.business.DTO.UsuarioDTO.type;

/**
 * Clase que representa el javabean necesario ara realizar el login del sistema
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class CustomerBean implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private String emailUser = "";
	private type typeUser;
	private String filter = "";
	private String search = "";
	
	/*
	 * Devuelve el correo del usuario
	 * @param none
	 * @return String con el correo del usuario
	 */
	
	public String getEmailUser() {
		return emailUser;
	}
	
	/* Establece el correo del usuario
	 * @param String con el correo del usuario
	 * @return none
	 * 
	 */
	
	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}
	
	/*
	 * Devuelve el tipo de usuario
	 * @param none
	 * @return String tipo de usuario
	 */
	
	public type getTypeUser() {
		return typeUser;
	}
	
	/*
	 * Establece el tipo de usuario
	 * @param none
	 * @return String tipo de usuario 
	 */
	
	public void setTypeUser(type type) {
		this.typeUser = type;
	}
	
	/*
	 * Devuelve el filtro establecido por el usuario
	 * @param none
	 * @return String filtro del usuario 
	 */
	
	public String getFilter() {
		return filter;
	}
	
	/*
	 * Establece el filtro del usuario 
	 * @param String filtro del usuario
	 * @return none
	 * 
	 */
	
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	/*
	 * Devuelve la búsqueda del usuario
	 * @param none
	 * @return String búsqueda del usuario 
	 */
	
	public String getSearch() {
		return search;
	}
	
	/*
	 * Establece la búsqueda del usuario
	 * @param String búsqueda del usuario
	 * @return none 
	 */
	
	public void setSearch(String search) {
		this.search = search;
	}
	
}
