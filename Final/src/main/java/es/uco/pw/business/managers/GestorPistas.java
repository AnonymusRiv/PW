package es.uco.pw.business.managers;

import es.uco.pw.business.DTO.KartDTO;
import es.uco.pw.business.DTO.PistaDTO;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.data.DAO.PistaDAO;

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
	
	public boolean registerPista(PistaDTO pista) {
	    GestorPistas gestor = new GestorPistas();
        ArrayList<PistaDTO> pistas = gestor.getPistas();
        for (int i = 0; i < pistas.size(); i++) {
          if (pistas.get(i).getName().equals(pista.getName())) {
            return false;
          }
        }
        PistaDAO pistaDAO = new PistaDAO();
        pistaDAO.registrarPista(
          pista.getName(),
          pista.isStatus(),
          pista.getDif(),
          pista.getMax()
        );
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
	
	public void asociarKartsAPista(KartDTO kart, int id) {
		PistaDAO kartdao = new PistaDAO();
        kartdao.asociarKaP(kart, id);
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
	
	public ArrayList<PistaDTO> pistasLibres(ArrayList<PistaDTO>pistas, PistaDTO.dificulty diff, int karts){
		ArrayList<PistaDTO> pistasLibres=new ArrayList<PistaDTO>();
		for(int i=0;i<pistas.size();i++) {
			if(pistas.get(i).getDif().equals(diff) && pistas.get(i).getMax()>=karts) {
				pistasLibres.add(pistas.get(i));
			}
		}
		return pistasLibres;
	}
	
	/**
     * Método público para eliminar un Kart
     * @param id
     * @return true o false
     */
    
    public Boolean deleteKart(int id) {
        ArrayList<KartDTO> karts = getKarts();
        for(int i=0; i<karts.size(); i++) {
            if(karts.get(i).getId() == id) {
                PistaDAO kart = new PistaDAO();
                kart.deleteKart(id);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método público para modificar un kart
     * @param user
     * @return none
     */
    
    public Boolean modificarKart(KartDTO kart, int id) {
        PistaDAO kartdao = new PistaDAO();
        kartdao.modificarKart(kart, id);
        return true;
    }
    
    /**
     * Método público para modificar una pista
     * @param user
     * @return none
     */
    
    public Boolean modificarPista(PistaDTO pista, String pistaId) {
        PistaDAO pistadao = new PistaDAO();
        pistadao.modificarPista(pista, pistaId);
        return true;
    }
    
    /**
     * Método público para eliminar una pista
     * @param id
     * @return true o false
     */
    
    public Boolean deletePista(String pistaId) {
        ArrayList<PistaDTO> pistas = getPistas();
        for(int i=0; i<pistas.size(); i++) {
            if(pistas.get(i).getName().equals(pistaId)) {
                PistaDAO pista = new PistaDAO();
                pista.deletePista(pistaId);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método público para buscar un kart
     * @param mail
     * @return true o false
     */
    
    public KartDTO findKart(int id) {
        ArrayList<KartDTO> karts = getKarts();
        for(int i=0; i<karts.size(); i++) {
            if(karts.get(i).getId() == id) {
                return karts.get(i);
            }
        }
		return null;
    }
    
    /**
     * Método público para buscar una pista
     * @param mail
     * @return true o false
     */
    
    public PistaDTO findPista(String name) {
        ArrayList<PistaDTO> pistas = getPistas();
        for(int i=0; i<pistas.size(); i++) {
            if(pistas.get(i).getName().equals(name)) {
                return pistas.get(i);
            }
        }
		return null;
    }
}
