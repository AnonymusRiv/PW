import java.util.ArrayList;

public class Pista {
	private String name;										//Nombre de la pista
	private boolean status;										//Estado de la pista, true para disponible para reservas y false para no
	private difficult difficulty;								//Dificultad de la pista
	private int number;											//Número de karts autorizados
	private ArrayList<Kart> karts = new ArrayList<Kart>();		//Lista de karts
	public enum difficult
	{
		infantil, familiar, adultos
	};
	
	
	//Constructor sin parámetros
	public Pista() {
		super();
	}
	
	//Constructor con parámetros
	public Pista(String name, boolean status, difficult difficulty, int number) {
		this.name=name;
		this.status=status;
		this.difficulty=difficulty;
		this.number=number;
		this.karts=null;
	}
	
	//Métodos get y set
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name=name;
	}
	
	public boolean getstatus() {
		return status;
	}
	
	public void setstatus(boolean status) {
		this.status=status;
	}
	
	public difficult getdifficulty() {
		return difficulty;
	}
	
	public void setdifficult(difficult difficulty) {
		this.difficulty=difficulty;
	}
	
	public int getnumber() {
		return number;
	}
	
	public void setnumber(int number) {
		this.number=number;
	}
	
	public ArrayList<Kart> getkarts() {
		return karts;
	}
	
	public void setkarts(ArrayList<Kart> karts) {
		this.karts=karts;
	}
	
	//Método toString
	@Override
	public String toString() {
		return "Pista [name=" + name + ", status=" + status + ", difficulty=" + difficulty + ", number=" + number
				+ ", karts=" + karts + "]";
	}
	
	//Método consultarKartsDisponibles
	public ArrayList<Kart> consultarKartsDisponibles() {
		ArrayList<Kart> freekarts = new ArrayList<Kart>();		//array de karts disponibles
		for(int i=0; i<karts.size(); i++) {
			if(karts.get(i).getstatus().equals(Kart.status.disponible) == true){
				freekarts.add(karts.get(i));
			}
		}
		return freekarts;
	}
	
	
	//Método asociarKartAPista
	public void asociarKartAPista(Kart kart) {
		if((this.getdifficulty().equals(Pista.difficult.infantil) == true) && (kart.gettype() == false)) {
			karts.add(kart);
		}
		if(this.getdifficulty().equals(Pista.difficult.familiar) == true) {
			karts.add(kart);
		}
		if((this.getdifficulty().equals(Pista.difficult.adultos) == true) && (kart.gettype() == true)) {
			karts.add(kart);
		}
	}
	
	
}
