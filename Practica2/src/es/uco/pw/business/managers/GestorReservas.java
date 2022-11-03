package es.uco.pw.business.managers;

import java.util.ArrayList;
import java.util.Date;

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
	 * Método público para hacer una reserva individual
	 * @param usuario
	 * @param usuarios
	 * @param pista
	 * @param reserva
	 * @return none
	 */
	
	public void hacerReservaIndividual(es.uco.pw.business.classes.Usuario usuario, ArrayList<es.uco.pw.business.classes.Usuario> usuarios, es.uco.pw.business.classes.Pista pista, es.uco.pw.business.factory.Reserva reserva){
		for(int i=0;i<usuarios.size();i++){
			if(usuarios.get(i).getEmail()==usuario.getEmail()){
				if((pista.isStatus() == true) && (pista.getDificulty().equals(reserva.getTypeRes()) == true) && (pista.getMax() < pista.getKarts().size())) {
					if(Integer.parseInt(usuario.calcularAntiguedad()) > 2) {
						reserva.setDiscount(10);
					}
				}
			}
		}
	}
	
	/**
	 * Método público para hacer una reserva bono
	 * @param reserva
	 * @param usuario
	 * @param usuarios
	 * @return none
	 */
	
	public void hacerReservaBono(es.uco.pw.business.factory.Reserva reserva, es.uco.pw.business.classes.Usuario usuario, ArrayList<es.uco.pw.business.classes.Usuario> usuarios){
		for(int i=0;i<usuarios.size();i++){
			if(usuarios.get(i).getEmail()==usuario.getEmail()){
				if(reserva.getDuration() == 60){
					reserva.setDiscount(5);
				}
				if(reserva.getDuration() == 90){
					reserva.setDiscount(5);
				}
				if(reserva.getDuration() == 120){
					reserva.setDiscount(5);
				}
			}
		}
	}
	
	/**
	 * Método público para establecer el precio
	 * @param reserva
	 * @return none
	 */
	
	public void establecerprecio(ArrayList <es.uco.pw.business.factory.Reserva> reservas, es.uco.pw.business.factory.Reserva reserva){
		for(int i=0; i<reservas.size(); i++){
			if(reservas.get(i).getUserId() == reserva.getUserId()){
				if(reserva.getDuration() == 60){
					reserva.setPrice(20);
				}
				if(reserva.getDuration() == 90){
					reserva.setPrice(30);
				}
				if(reserva.getDuration() == 120){
					reserva.setPrice(40);
				}
			}
		}
	}

	/**
	 * Método público para modificar la reserva
	 * @param reserva
	 * @param usuario
	 * @return none
	 */
	
	public void modificarReserva(ArrayList <es.uco.pw.business.factory.Reserva> reservas, ArrayList <es.uco.pw.business.classes.Usuario> usuarios, es.uco.pw.business.factory.Reserva reserva, es.uco.pw.business.classes.Usuario usuario){
		for(int i=0; i<reservas.size(); i++){
			if(reservas.get(i).getUserId() == reserva.getUserId()){
				for(int j=0;j<usuarios.size();j++){
					if(usuarios.get(j).getEmail()==usuario.getEmail()){
						if(reserva.getDate().before(new Date())) {
							reserva.setDate(reserva.getDate());
							reserva.setDuration(reserva.getDuration());
							reserva.setPistId(reserva.getPistId());
							reserva.setPrice(reserva.getPrice());
							reserva.setDiscount(reserva.getDiscount());
							reserva.setTypeRes(reserva.getTypeRes());
						}
					}
				}
			}
		}
	}

	/**
	 * Método público para ver el número de reservas futuras
	 * @param reserva
	 * @return nreservas
	 */
	
	public int reservasFuturas(ArrayList<es.uco.pw.business.factory.Reserva> reservas){
		int nreservas = 0;
		for(int i=0; i<reservas.size(); i++) {
			if(reservas.get(i).getDate().after(new Date())) {
				nreservas++;
			}
		}
		return nreservas;
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
}
