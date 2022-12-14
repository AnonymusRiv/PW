package es.uco.pw.business.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.uco.pw.business.DTO.PistaDTO.dificulty;

/**
 * DTO para el concepto usuario
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class UsuarioDTO {
    private String name;
    private String dateOfBirth;
    private java.util.Date inscription;
    private String email;
    private String password;
    private type tipo;
    public enum type{
        administrador,cliente
    };
    
    /**
     * Constructor sin parámetros
     * @param none
     */
    
    public UsuarioDTO() {
        
    }
    
    public type getType() {
		return tipo;
	}
    
    public void setType(type tipo) {
		this.tipo = tipo;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	 public String getPassword() {
			return password;
		}

		

	/**
     * Constructor con parámetros
     * @param name
     * @param dateOfBirth
     * @param mail
     */

    public UsuarioDTO(String name, String dateOfBirth, Date inscription, String email, String password, type tipo) {
        super();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.inscription = inscription;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    /**
     * Método público para establecer la fecha de cumpleaños 
     * @param date
     * @return none
     */

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * Método público para establecer la fecha de cumpleaños 
     * @param date
     * @return none
     */
    
    /*public void setDateOfBirth(String date) throws ParseException {
        Date dob=new SimpleDateFormat("yyyy-MM-dd").parse(date);
        dateOfBirth=dob;
    }*/
    
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
        return "UsuarioDTO [name=" + name + ", dateOfBirth=" + dateOfBirth + ", inscription=" + inscription + ", email="
                + email + "]";
    }
}