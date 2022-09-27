
public class Kart {
	int id;				//identificador del kart
	boolean type;		//tipo de kart, true para adulto o false para niños
	public enum status	//estado del kart
	{
		disponible, reservado, mantenimiento
	}
	
	//Constructor sin parámetros
	public Kart() {
		
	}
	
	//Constructor con parámetros
	public Kart(int id, boolean type, public enum status) {
		this.id=id;
		this.type=type;
		this.status=status;
	}
	
	//
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
	
	public enum status getstatus() {
		return status;
	}
	
	public void setstatus(public enum status) {
		this.status=status;
	}
	
	public string tostring() {
		
	}
}
