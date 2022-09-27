import java.util.Date;

public class Usuario {
	private String name;		//Nombre y apellidos del usuario
	private Date birthday;		//Fecha de nacimiento del usuario
	private Date reserve;		//Fecha de la primera serva del usuario
	private String mail;		//Correo electrónico único del usuario  ¿es único?
	
	//Constructor sin parámetros
	public Usuario() {
			
	}
		
	//Constructor con parámetros
	public Usuario(String name, Date birthday, Date reserve, String mail) {
		this.name=name;
		this.birthday=birthday;
		this.reserve=reserve;
		this.mail=mail;
	}
		
	//Métodos get y set
	public String getname() {
		return name;
	}
		
	public void setname(String name) {
		this.name=name;
	}
	
	public Date getbirthday() {
		return birthday;
	}
		
	public void setbirthday(Date birthday) {
		this.birthday=birthday;
	}
	
	public Date getreserve() {
		return reserve;
	}
		
	public void setreserve(Date reserve) {
		this.reserve=reserve;
	}
	
	public String getmail() {
		return mail;
	}
		
	public void setmail(String mail) {
		this.mail=mail;
	}
	
	//Método toString
	public String toString() {
		String userinfo= "El nombre del usuario es " + this.name + " cuya fecha de nacimiento es el " + this.birthday + ", su fecha de inscripción es del " + this.reserve + " y su correo es " + this.mail;
		return userinfo;
	}
	
	//Método calcularAntiguedad

}
