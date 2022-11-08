package es.uco.pw.business.classes;

import java.util.ArrayList;

/**
 * Clase Pista
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class Pista {
	private String name;       //único
	private boolean status;
	private dificulty dif;
	public enum dificulty{
		infantil, familiar, adultos
	};
	private int max;
	private ArrayList<Kart> karts = new ArrayList<Kart>();
	
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
	 * @param difficult
	 * @param max
	 * @param karts
	 */
	
	public Pista(String name, boolean status, es.uco.pw.business.classes.Pista.dificulty dificulty, int max) {
		super();
		this.name = name;
		this.status = status;
		this.dif = dificulty;
		this.max = max;
		this.karts=null;
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
	 * Método público para obtener el estado 
	 * @param none
	 * @return status
	 */
	
	public boolean isStatus() {
		return status;
	}

	/**
	 * Método público para establecer el estado 
	 * @param status
	 * @return none
	 */
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * Método público para obtener la dificultad 
	 * @param none
	 * @return dif
	 */
	
	public dificulty getDificulty() {
		return dif;
	}

	/**
	 * Método público para establecer la dificultad 
	 * @param difficulty
	 * @return none
	 */
	
	public void setDificulty(dificulty dificulty) {
		this.dif = dificulty;
	}

	/**
     * Método público para establecer la dificultad 
     * @param difficulty
     * @return none
     */
    
    public void setDificulty(String dificulty) {
        if(dificulty == "infantil") {
            dif = es.uco.pw.business.classes.Pista.dificulty.infantil;
        }
        if(dificulty == "familiar") {
            dif = es.uco.pw.business.classes.Pista.dificulty.familiar;
        }
        if(dificulty == "adultos") {
            dif = es.uco.pw.business.classes.Pista.dificulty.adultos;
        }
    }

	/**
	 * Método público para obtener el número de karts máximo 
	 * @param none
	 * @return max
	 */
	
	public int getMax() {
		return max;
	}

	/**
	 * Método público para establecer el número máximo de karts 
	 * @param max
	 * @return none
	 */
	
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * Método público para obtener la lista de karts asociados 
	 * @param none
	 * @return karts
	 */
	
	public ArrayList<Kart> getKarts() {
		return karts;
	}

	/**
	 * Método público para establecer los karts asociados 
	 * @param karts
	 * @return none
	 */
	
	public void setKarts(ArrayList<Kart> karts) {
		this.karts = karts;
	}

	/**
	 * Método público para imprimir la información
	 * @param none
	 * @return Pista info de la pista
	 */
	
	@Override
	public String toString() {
		return "Pista [name=" + name + ", status=" + status + ", dificulty=" + dif + ", max=" + max + ", karts="
				+ karts + "]";
	}

	/**
	 * Método público para consultar los karts disponibles
	 * @param none
	 * @return disponibles vector de karts disponibles 
	 */
	
	public ArrayList<Kart> consultarKartsDisponibles() {
		ArrayList<Kart> disponibles=new ArrayList<Kart>();
		for(int i=0;i<karts.size();i++){
			if(karts.get(i).getStatus().equals(Kart.status.disponible)==true) {
				disponibles.add(karts.get(i));
			}
		}
		return disponibles;
	}
	
	/**
	 * Método público para asociar karts a una pista
	 * @param kart
	 * @return none 
	 */
	
	public void asociarKartAPista(Kart kart) {
		if((this.getDificulty().equals(Pista.dificulty.infantil)==true) && (kart.isType()==false)){
			karts.add(kart);
		}
		if(this.getDificulty().equals(Pista.dificulty.familiar)==true){
			karts.add(kart);
		}
		if((this.getDificulty().equals(Pista.dificulty.adultos)==true) && (kart.isType()==true)){
			karts.add(kart);
		}
	}
}
