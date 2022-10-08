package es.uco.pw.classes;

import java.util.ArrayList;

/**
 * Clase Pista
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public class Pista {
	private String name;
	private boolean status;
	private difficult difficulty;
	private int number;
	private ArrayList<Kart> karts = new ArrayList<Kart>();
	public enum difficult
	{
		infantil, familiar, adultos;
	};
	
	
	/**
	 * Constructor sin parámetros
	 * @param none
	 */
	
	public Pista() {
		super();
	}
	
	/**
	 * Constructor con parámetros
	 * @param name
	 * @param status
	 * @param difficulty
	 * @param number
	 * @param karts
	 */
	
	public Pista(String name, boolean status, difficult difficulty, int number) {
		this.name=name;
		this.status=status;
		this.difficulty=difficulty;
		this.number=number;
		this.karts=null;
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
	 * Método público para obtener el estado 
	 * @param none
	 * @return status
	 */
	
	public boolean getstatus() {
		return status;
	}
	
	/**
	 * Método público para establecer el estado 
	 * @param status
	 * @return none
	 */
	
	public void setstatus(boolean status) {
		this.status=status;
	}
	
	/**
	 * Método público para obtener la dificultad 
	 * @param none
	 * @return difficulty
	 */
	
	public difficult getdifficulty() {
		return difficulty;
	}
	
	/**
	 * Método público para establecer la dificultad 
	 * @param difficulty
	 * @return none
	 */
	
	public void setdifficult(difficult difficulty) {
		this.difficulty=difficulty;
	}
	
	/**
	 * Método público para obtener el número de karts máximo 
	 * @param none
	 * @return number
	 */
	
	public int getnumber() {
		return number;
	}
	
	/**
	 * Método público para establecer el número máximo de karts 
	 * @param number
	 * @return none
	 */
	
	public void setnumber(int number) {
		this.number=number;
	}
	
	/**
	 * Método público para obtener la lista de karts asociados 
	 * @param none
	 * @return karts
	 */
	
	public ArrayList<Kart> getkarts() {
		return karts;
	}
	
	/**
	 * Método público para establecer los karts asociados 
	 * @param karts
	 * @return none
	 */
	
	public void setkarts(ArrayList<Kart> karts) {
		this.karts=karts;
	}
	
	/**
	 * Método público para imprimir la información
	 * @param none
	 * @return Pista info de la pista
	 */
	
	@Override
	public String toString() {
		return "Pista [name=" + name + ", status=" + status + ", difficulty=" + difficulty + ", number=" + number
				+ ", karts=" + karts + "]";
	}
	
	/**
	 * Método público para consultar los karts disponibles
	 * @param none
	 * @return freekarts vector de karts disponibles 
	 */
	
	public ArrayList<Kart> consultarKartsDisponibles() {
		ArrayList<Kart> freekarts = new ArrayList<Kart>();
		for(int i=0; i<karts.size(); i++) {
			if(karts.get(i).getstatus().equals(Kart.status.disponible) == true){
				freekarts.add(karts.get(i));
			}
		}
		return freekarts;
	}
	
	
	/**
	 * Método público para asociar karts a una pista
	 * @param karts
	 * @return none 
	 */
	
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
