package es.uco.pw.business.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase Usuario
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class Usuario {
	private String name;
	private Date dateOfBirth;
	private java.util.Date inscription;
	private String email;                  //único

	/**
	 * Constructor sin parámetros
	 * @param none
	 */
	
	public Usuario() {
		super();
	}

	/**
	 * Constructor con parámetros
	 * @param name
	 * @param dateOfBirth
	 * @param mail
	 */
	
	public Usuario(String name, Date dateOfBirth, String email) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.inscription = new Date();
		this.email = email;
	}

	/**
	 * Método público para obtener el nombre 
	 * @param none
	 * @return name
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * Método público para establecer el nombre 
	 * @param name
	 * @return none
	 */
	
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Método público para obtener el cumpleaños 
	 * @param none
	 * @return dateOfBirth
	 */
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Método público para establecer la fecha de cumpleaños 
	 * @param date
	 * @return none
	 */
	
	public void setDateOfBirth(String date) throws ParseException {
		Date dob=new SimpleDateFormat("dd/MM/yyyy").parse(date);
		dateOfBirth=dob;
	}

	/**
	 * Método público para establecer la fecha de cumpleaños 
	 * @param date
	 * @return none
	 */
	
	public void setDateOfBirth(Date date) {
		this.dateOfBirth=date;
	}
	
	/**
	 * Método público para obtener la fecha de reserva 
	 * @param none
	 * @return inscription
	 */
	
	public java.util.Date getInscription() {
		return inscription;
	}

	/**
	 * Método público para establecer la fecha de reserva 
	 * @param inscription
	 * @return none
	 */
	
	public void setInscription(java.util.Date inscription) {
		this.inscription = inscription;
	}
	
	/**
     * Método público para establecer la fecha de reserva 
     * @param date
     * @return none
     */
    
    public void setInscription(String date) throws ParseException {
        Date ins=new SimpleDateFormat("dd/MM/yyyy").parse(date);
        inscription=ins;
    }

	/**
	 * Método público para obtener el mail 
	 * @param none
	 * @return mail
	 */
	
	public String getEmail() {
		return email;
	}

	/**
	 * Método público para establecer el mail 
	 * @param mail
	 * @return none
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método público para imprimir la información
	 * @param none
	 * @return Usuario info del usuario
	 */
	
	@Override
	public String toString() {
		return "Usuario [name=" + name + ", dateOfBirth=" + dateOfBirth + ", inscription=" + inscription + ", email="
				+ email + "]";
	}

	/**
	 * Método público para calcular la antigüedad
	 * @param none
	 * @return SimpleDateFormat 
	 */
	
	public String calcularAntiguedad() {
		Date today=new Date();
		long diff=this.inscription.getTime()-today.getTime();
		Date date=new Date();
		date.setTime(diff);
		return new SimpleDateFormat().format(date);
	}
}
