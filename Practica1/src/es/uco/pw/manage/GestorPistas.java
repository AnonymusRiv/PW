package es.uco.pw.manage;

import es.uco.pw.classes.*;
import es.uco.pw.classes.Pista.dificulty;

import java.util.ArrayList;

/**
 * Clase GestorPistas
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public class GestorPistas {
	private static GestorPistas instance=null;
	private ArrayList<Kart> karts=new ArrayList<Kart>();
	private ArrayList<Pista> pistas=new ArrayList<Pista>();
	
	public static GestorPistas getInstance() {
		if(instance==null) {
			instance=new GestorPistas();
		}
		return instance;
	}

	public ArrayList<Kart> getKarts() {
		return karts;
	}

	public void setKarts(ArrayList<Kart> karts) {
		this.karts = karts;
	}

	public ArrayList<Pista> getPistas() {
		return pistas;
	}

	public void setPistas(ArrayList<Pista> pistas) {
		this.pistas = pistas;
	}
	
	public boolean addPista(Pista pista) {
		pistas.add(pista);
		return true;
	}
	
	public boolean addKart(Kart kart) {
		karts.add(kart);
		return true;
	}
	
	public void asociarKartsAPista(Kart kart, Pista pista) {
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
	
	public void listarPistas(ArrayList<Pista> pistas) {
		for(int i=0;i<pistas.size();i++) {
			System.out.println(pistas.get(i).toString());
		}
	}
	
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