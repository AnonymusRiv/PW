
public class Kart {
	private int id;				//identificador del kart
	private boolean type;		//tipo de kart, true para adulto o false para niños
	private status status;		//estado del kart
	public enum status			//posibles valores para el estado del kart
	{
		disponible, reservado, mantenimiento
	}
	
	//Constructor sin parámetros
	public Kart() {
		
	}
	
	//Constructor con parámetros
	public Kart(int id, boolean type, status status) {
		this.id=id;
		this.type=type;
		this.status=status;
	}
	
	//Métodos get y set
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id=id;
	}
	
	public boolean gettype() {
		return type;
	}
	
	public void settype(boolean type) {
		this.type=type;
	}
	
	public status getstatus() {
		return status;
	}
	
	public void setstatus(status status) {
		this.status=status;
	}

	//Método para dar la info de un kart
	public String toString() {
		if(this.type) {	//Si el tipo es true, entonces el kart es de tipo adulto, sino sera de tipo niño
			String Kartinfo = "El kart con id " + this.id + " que es para adultos tiene el estado " + this.status;
			return Kartinfo;
		}
		String Kartinfo = "El kart con id " + this.id + " que es para niños tiene el estado " + this.status;
		return Kartinfo;
	}
	
}
