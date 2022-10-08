package es.uco.pw.classes;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase Usuario
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public class Usuario {

	private String name;
	private LocalDate birthday;
	private LocalDate reserve;
	private String mail;
	
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
	 * @param birthday
	 * @param mail
	 */
	
	public Usuario(String name, LocalDate birthday, String mail, int id) {
		this.name=name;
		this.birthday=birthday;
		this.mail=mail;
		this.reserve=LocalDate.now();
	}
		
	/**
	 * Método público para obtener el nombre 
	 * @param none
	 * @return name
	 */
	
	public String getname() {
		return name;
	}
		
	/**
	 * Método público para establecer el nombre 
	 * @param name
	 * @return none
	 */
	
	public void setname(String name) {
		this.name=name;
	}
	
	/**
	 * Método público para obtener el cumpleaños 
	 * @param none
	 * @return birthday
	 */
	
	public LocalDate getbirthday() {
		return birthday;
	}
		
	/**
	 * Método público para establecer la fecha de cumpleaños 
	 * @param birthday
	 * @return none
	 */
	
	public void setbirthday(LocalDate birthday) {
		this.birthday=birthday;
	}
	
	/**
	 * Método público para obtener la fecha de reserva 
	 * @param none
	 * @return reserve
	 */
	
	public LocalDate getreserve() {
		return reserve;
	}
		
	/**
	 * Método público para establecer la fecha de reserva 
	 * @param reserve
	 * @return none
	 */
	
	public void setreserve(LocalDate reserve) {
		this.reserve=reserve;
	}
	
	/**
	 * Método público para obtener el mail 
	 * @param none
	 * @return mail
	 */
	
	public String getmail() {
		return mail;
	}
		
	/**
	 * Método público para establecer el mail 
	 * @param mail
	 * @return none
	 */
	
	public void setmail(String mail) {
		this.mail=mail;
	}	
	
	/**
	 * Método público para imprimir la información
	 * @param none
	 * @return Usuario info del usuario
	 */
	
	@Override
	public String toString() {
		return "Usuario [name=" + name + ", birthday=" + birthday + ", reserve=" + reserve + ", mail=" + mail + "]";
	}
	
	/**
	 * Método público para calcular la antigüedad
	 * @param none
	 * @return years 
	 */
	
	public int calcularAntiguedad() {
		Period period=Period.between(this.getreserve(), LocalDate.now());
		return period.getYears();
	}
}
