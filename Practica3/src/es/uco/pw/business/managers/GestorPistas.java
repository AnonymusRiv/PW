package es.uco.pw.business.managers;

import es.uco.pw.business.DTO.KartDTO;
import es.uco.pw.business.DTO.PistaDTO;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.classes.*;
import es.uco.pw.business.classes.Pista.dificulty;
import es.uco.pw.data.DAO.PistaDAO;
import es.uco.pw.data.DAO.UsuarioDAO;

import java.text.SimpleDateFormat;
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
	private ArrayList<KartDTO> karts=new ArrayList<KartDTO>();
	private ArrayList<PistaDTO> pistas=new ArrayList<PistaDTO>();
	
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
	
	public ArrayList<KartDTO> getKarts() {
	    PistaDAO karts = new PistaDAO();
		return karts.getKarts();
	}

	/**
	 * Método público para establecer los karts
	 * @param karts
	 * @return none
	 */
	
	public void setKarts(ArrayList<KartDTO> karts) {
		this.karts = karts;
	}

	/**
	 * Método público para obtener las pistas
	 * @param none
	 * @return pistas
	 */
	
	public ArrayList<PistaDTO> getPistas() {
	    PistaDAO pistas = new PistaDAO();
		return pistas.getPistas();
	}

	/**
	 * Método público para establecer las pistas
	 * @param pistas
	 * @return none
	 */
	
	public void setPistas(ArrayList<PistaDTO> pistas) {
		this.pistas = pistas;
	}
	
	/**
	 * Método público para añadir pistas
	 * @param pista
	 * @return true
	 */
	
	public boolean addPista(ArrayList<PistaDTO> pistas, PistaDTO pista) {
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
	
	public boolean registerKart(KartDTO kart) {
	    GestorPistas gestor = new GestorPistas();
        ArrayList<KartDTO> karts = gestor.getKarts();
        for (int i = 0; i < karts.size(); i++) {
          if (karts.get(i).getId() == kart.getId()) {
            return false;
          }
        }
        PistaDAO pistaDAO = new PistaDAO();
        pistaDAO.registrarKart(
          kart.getId(),
          kart.isType(),
          kart.getStat(),
          kart.getpistaId()
        );
        return true;
	}
	
	/**
	 * Método público para asociar un kart a una pista
	 * @param kart
	 * @param pista
	 * @return none
	 */
	
	public void asociarKartsAPista(ArrayList<KartDTO> karts, ArrayList<PistaDTO> pistas, KartDTO kart, PistaDTO pista) {
		for(int i=0; i<karts.size(); i++){
			if(karts.get(i).getId() == kart.getId()){
				for(int j=0; j<pistas.size(); j++){
					if(pistas.get(j).getName() == pista.getName()){
						if((pista.getDif().equals(Pista.dificulty.infantil)==true) && (kart.isType()==false) && (pista.isStatus()==true)) {
							karts.add(kart);
						}
						if((pista.getDif().equals(Pista.dificulty.familiar)==true) && (pista.isStatus()==true)) {
							karts.add(kart);
						}
						if((pista.getDif().equals(Pista.dificulty.adultos)==true) && (kart.isType()==true) && (pista.isStatus()==true)) {
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
	
	public void listarPistas(ArrayList<PistaDTO> pistas) {
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
	
	public ArrayList<PistaDTO> pistasLibres(ArrayList<PistaDTO>pistas, dificulty diff, int karts){
		ArrayList<PistaDTO> pistasLibres=new ArrayList<PistaDTO>();
		for(int i=0;i<pistas.size();i++) {
			if(pistas.get(i).getDif().equals(diff) && pistas.get(i).getMax()>=karts) {
				pistasLibres.add(pistas.get(i));
			}
		}
		return pistasLibres;
	}
}
