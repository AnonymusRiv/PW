package es.uco.pw.business.managers;

import java.util.ArrayList;
import java.util.Date;

import es.uco.pw.business.DTO.ReservaAdultosDTO;
import es.uco.pw.business.DTO.ReservaFamiliarDTO;
import es.uco.pw.business.DTO.ReservaInfantilDTO;
import es.uco.pw.business.classes.Pista;
import es.uco.pw.business.classes.Usuario;
import es.uco.pw.business.factory.Reserva;
import es.uco.pw.data.DAO.ReservasDAO;

/**
 * Clase GestorReservas
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class GestorReservas {
	private static GestorReservas instance=null;
	private ArrayList<Reserva> reservas=new ArrayList<Reserva>();
	
	/**
	 * Método público para obtener una instancia
	 * @param none
	 * @return instance
	 */
	
	public static GestorReservas getInstance() {
		if(instance==null) {
			instance=new GestorReservas();
		}
		return instance;
	}
	
	/**
	 * Método público para hacer una reserva individual infantil
	 * @param reserva
	 * @return none
	 */
	
	public boolean hacerReservaIndividualInfantil(ReservaInfantilDTO reserva){
		ReservasDAO reservasDAO = new ReservasDAO();
		reservasDAO.registrarReservaInfantil(reserva);
	    return true;
	}
	
	/**
     * Método público para hacer una reserva individual de adultos
     * @param reserva
     * @return none
     */
    
    public boolean hacerReservaIndividualAdultos(ReservaAdultosDTO reserva){
        ReservasDAO reservasDAO = new ReservasDAO();
        reservasDAO.registrarReservaAdultos(reserva);
        return true;
    }
    
    /**
     * Método público para hacer una reserva individual familiar
     * @param reserva
     * @return none
     */
    
    public boolean hacerReservaIndividualFamiliar(ReservaFamiliarDTO reserva){
        ReservasDAO reservasDAO = new ReservasDAO();
        reservasDAO.registrarReservaFamiliar(reserva);
        return true;
    }
	

    /**
     * Método público para hacer una reserva bono infantil
     * @param reserva
     * @return none
     */
    
    public boolean hacerReservaBonoInfantil(ReservaInfantilDTO reserva){
        ReservasDAO reservasDAO = new ReservasDAO();
        reservasDAO.registrarReservaBonoInfantil(reserva);
        return true;
    }
    
    /**
     * Método público para hacer una reserva individual de adultos
     * @param reserva
     * @return none
     */
    
    public boolean hacerReservaBonoAdultos(ReservaAdultosDTO reserva){
        ReservasDAO reservasDAO = new ReservasDAO();
        reservasDAO.registrarReservaBonoAdultos(reserva);
        return true;
    }
    
    /**
     * Método público para hacer una reserva individual familiar
     * @param reserva
     * @return none
     */
    
    public boolean hacerReservaBonoFamiliar(ReservaFamiliarDTO reserva){
        ReservasDAO reservasDAO = new ReservasDAO();
        reservasDAO.registrarReservaBonoFamiliar(reserva);
        return true;
    }

    /**
    * Método público para modificar una reserva individual infantil
    * @param reserva
    * @return none
    */
   
   public boolean modificarReservaIndividualInfantil(ReservaInfantilDTO reserva, int id){
       ReservasDAO reservasDAO = new ReservasDAO();
       reservasDAO.modificarReservaInfantil(reserva, id);
       return true;
   }
   
   /**
    * Método público para modificar una reserva individual de adultos
    * @param reserva
    * @return none
    */
   
   public boolean modificarReservaIndividualAdultos(ReservaAdultosDTO reserva, int id){
       ReservasDAO reservasDAO = new ReservasDAO();
       reservasDAO.modificarReservaAdultos(reserva, id);
       return true;
   }
   
   /**
    * Método público para modificar una reserva individual familiar
    * @param reserva
    * @return none
    */
   
   public boolean modificarReservaIndividualFamiliar(ReservaFamiliarDTO reserva, int id){
       ReservasDAO reservasDAO = new ReservasDAO();
       reservasDAO.modificarReservaFamiliar(reserva, id);
       return true;
   }

	/**
	 * Método público para ver las reservas futuras infantiles
	 * @param reserva
	 * @return nreservas
	 */
	
	public ArrayList<ReservaInfantilDTO> reservasFuturasInfantil(){
	    ReservasDAO reservas = new ReservasDAO();
	    return reservas.getReservaInfantil();
	}
	
	/**
     * Método público para ver las reservas futuras familiares
     * @param reserva
     * @return nreservas
     */
    
    public ArrayList<ReservaFamiliarDTO> reservasFuturasFamiliar(){
        ReservasDAO reservas = new ReservasDAO();
        return reservas.getReservaFamiliar();
    }
    
    /**
     * Método público para ver las reservas futuras de adultos
     * @param reserva
     * @return nreservas
     */
    
    public ArrayList<ReservaAdultosDTO> reservasFuturasAdultos(){
        ReservasDAO reservas = new ReservasDAO();
        return reservas.getReservaAdultos();
    }

	/**
	 * Método público para ver las reservas de un dia concreto
	 * @param reserva
	 * @param fecha
	 * @return reservasfecha
	 */
	
	public ArrayList<es.uco.pw.business.factory.Reserva> reservasDiaConcreto(ArrayList<es.uco.pw.business.factory.Reserva> reservas, Date fecha){
		ArrayList <es.uco.pw.business.factory.Reserva> reservasfecha = new ArrayList<es.uco.pw.business.factory.Reserva>();
		for(int i=0; i<reservas.size(); i++) {
			if(reservas.get(i).getDate().equals(fecha)) {
				reservasfecha.add(reservas.get(i));
			}
		}
		return reservasfecha;
	}

	/**
     * Método público para ver eliminar una reserva
     * @param reservas
     * @param reserva
     * @return boolean
     */
	
    public Boolean deleteReserva(ArrayList <Reserva> reservas, String iduser) {
        for(int i=0; i<reservas.size(); i++) {
            if(reservas.get(i).getUserId() == iduser) {
                reservas.remove(i);
                return true;
            }
        }
        return null;
    }

    /**
     * Método público para ver añadir una reserva
     * @param reservas
     * @param usuarios
     * @param pistas
     * @param reserva
     * @return boolean
     */
    
    public Boolean addReserva(ArrayList <Reserva> reservas, ArrayList <Usuario> usuarios, ArrayList <Pista> pistas, Reserva reserva) {
        for(int i=0; i<usuarios.size(); i++) {
            if(usuarios.get(i).getEmail() == reserva.getUserId()) {
                for(int j=0; j<pistas.size(); j++) {
                    if(pistas.get(j).getName() == reserva.getPistId()) {
                        reservas.add(reserva);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Método público para ver obtener las reservas
     * @param none
     * @return reservas
     */
    
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
}
