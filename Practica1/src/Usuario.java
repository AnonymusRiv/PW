import java.util.Date;
import java.time.LocalDate;
import java.time.Period;


public class Usuario {
	private String name;				//Nombre y apellidos del usuario
	private Date birthday;				//Fecha de nacimiento del usuario
	private LocalDate reserve;			//Fecha de la primera reserva del usuario
	private String mail;				//Correo electrónico único del usuario
	
	//Constructor sin parámetros
	public Usuario() {
			super();
	}
		
	//Constructor con parámetros
	public Usuario(String name, Date birthday, String mail) {
		this.name=name;
		this.birthday=birthday;
		this.mail=mail;
		this.reserve=LocalDate.now();
		
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
	
	public LocalDate getreserve() {
		return reserve;
	}
		
	public void setreserve(LocalDate reserve) {
		this.reserve=reserve;
	}
	
	public String getmail() {
		return mail;
	}
		
	public void setmail(String mail) {
		this.mail=mail;
	}
	
	//Método toString
	@Override
	public String toString() {
		return "Usuario [name=" + name + ", birthday=" + birthday + ", reserve=" + reserve + ", mail=" + mail + "]";
	}
	
	//Método calcularAntiguedad
	public int calcularAntiguedad() {
		Period period=Period.between(this.getreserve(), LocalDate.now());
		return period.getYears();
	}
}
