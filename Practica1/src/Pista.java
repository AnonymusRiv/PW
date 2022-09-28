import java.util.ArrayList;

public class Pista {
	private String name;										//Nombre de la pista
	private boolean status;										//Estado de la pista, true para disponible para reservas y false para no
	private difficulty difficulty;								//Dificultad de la pista
	private int number;											//Número de karts autorizados
	private ArrayList<Kart> karts = new ArrayList<Kart>();		//Lista de karts
	public enum difficulty
	{
		infantil, familiar, adultos
	}
	
	
	//Constructor sin parámetros
	public Pista() {
		
	}
	
	//Constructor con parámetros
	public Pista(String name, boolean status, difficulty difficulty, int number) {
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
	
	public difficulty getdifficulty() {
		return difficulty;
	}
	
	public void setdifficult(difficulty difficulty) {
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
	public String toString() {
		if(this.status) {
			String Pistainfo = "La pista con nombre " + this.name + " esta disponible para reservas, tiene una dificultad  " + this.difficulty + ". Esta autorizado para " + this.number + " karts y la lista de karts asociados es " + this.karts;
			return Pistainfo;
		}
		String Pistainfo = "La pista con nombre " + this.name + " no esta disponible para reservas, tiene una dificultad  " + this.difficulty + ". Esta autorizado para " + this.number + " karts y la lista de karts asociados es " + this.karts;
		return Pistainfo;
	}
	
	//Método consultarKartsDisponibles
	public ArrayList<Kart> freekarts() {
		ArrayList<Kart> freekarts = new ArrayList<Kart>();		//array de coches disponibles
		for(int i=0; i<karts.size(); i++) {
			if(karts.get(i).getstatus() == ){
				freekarts.add(karts.get(i));
			}
		}
		return freekarts;
	}
	
	//karts en estado disponible
	
	
	//Método asociarKartAPista
	
	
}
