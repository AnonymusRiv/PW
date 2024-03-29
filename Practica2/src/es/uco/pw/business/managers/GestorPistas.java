package es.uco.pw.business.managers;

import es.uco.pw.business.classes.*;
import es.uco.pw.business.classes.Pista.dificulty;

import java.util.ArrayList;

/**
 * Clase GestorPistas
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class GestorPistas {
	private static GestorPistas instance=null;
	private ArrayList<Kart> karts=new ArrayList<Kart>();
	private ArrayList<Pista> pistas=new ArrayList<Pista>();
	
	/**
	 * Método público para obtener una instancia
	 * @param none
	 * @return instance
	 */
	
	public static GestorPistas getInstance() {
		if(instance==null) {
			instance=new GestorPistas();
		}
		return instance;
	}

	/**
	 * Método público para obtener los karts
	 * @param none
	 * @return karts
	 */
	
	public ArrayList<Kart> getKarts() {
		return karts;
	}

	/**
	 * Método público para establecer los karts
	 * @param karts
	 * @return none
	 */
	
	public void setKarts(ArrayList<Kart> karts) {
		this.karts = karts;
	}

	/**
	 * Método público para obtener las pistas
	 * @param none
	 * @return pistas
	 */
	
	public ArrayList<Pista> getPistas() {
		return pistas;
	}

	/**
	 * Método público para establecer las pistas
	 * @param pistas
	 * @return none
	 */
	
	public void setPistas(ArrayList<Pista> pistas) {
		this.pistas = pistas;
	}
	
	/**
	 * Método público para añadir pistas
	 * @param pista
	 * @return true
	 */
	
	public boolean addPista(ArrayList<Pista> pistas, Pista pista) {
		for(int i=0; i<pistas.size(); i++){
			if(pistas.get(i).getName() == pista.getName()){
				return false;
			}
		}
		pistas.add(pista);
		return true;
	}
	
	/**
	 * Método público para añadir kart
	 * @param karts
	 * @return true
	 */
	
	public boolean addKart(ArrayList<Kart> karts, Kart kart) {
		for(int i=0; i<karts.size(); i++){
			if(karts.get(i).getId() == kart.getId()){
				return false;
			}
		}
		karts.add(kart);
		return true;
	}
	
	/**
	 * Método público para asociar un kart a una pista
	 * @param kart
	 * @param pista
	 * @return none
	 */
	
	public void asociarKartsAPista(ArrayList<Kart> karts, ArrayList<Pista> pistas, Kart kart, Pista pista) {
		for(int i=0; i<karts.size(); i++){
			if(karts.get(i).getId() == kart.getId()){
				for(int j=0; j<pistas.size(); j++){
					if(pistas.get(j).getName() == pista.getName()){
						if((pista.getDificulty().equals(Pista.dificulty.infantil)==true) && (kart.isType()==false) && (pista.isStatus()==true) && ((pista.getKarts().size()+1)<pista.getMax())) {
							karts.add(kart);
						}
						if((pista.getDificulty().equals(Pista.dificulty.familiar)==true) && (pista.isStatus()==true) && ((pista.getKarts().size()+1)<pista.getMax())) {
							karts.add(kart);
						}
						if((pista.getDificulty().equals(Pista.dificulty.adultos)==true) && (kart.isType()==true) && (pista.isStatus()==true) && ((pista.getKarts().size()+1)<pista.getMax())) {
							karts.add(kart);
						}
					}
				}
			}
		}
	}
	
	/**
	 * Método público para listar pistas
	 * @param pistas
	 * @return none
	 */
	
	public void listarPistas(ArrayList<Pista> pistas) {
		for(int i=0;i<pistas.size();i++) {
			System.out.println(pistas.get(i).toString());
		}
	}
	
	/**
	 * Método público para ver las pistas libres
	 * @param pistas
	 * @param diff
	 * @param karts
	 * @return pistasLibres
	 */
	
	public ArrayList<Pista> pistasLibres(ArrayList<Pista>pistas, dificulty diff, int karts){
		ArrayList<Pista> pistasLibres=new ArrayList<Pista>();
		for(int i=0;i<pistas.size();i++) {
			if(pistas.get(i).getDificulty().equals(diff) && pistas.get(i).getMax()>=karts) {
				pistasLibres.add(pistas.get(i));
			}
		}
		return pistasLibres;
	}
}
