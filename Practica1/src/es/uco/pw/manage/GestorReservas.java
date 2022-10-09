package es.uco.pw.manage;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase GestorReservas
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
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
	
	public void hacerReservaIndividual(es.uco.pw.classes.Usuario usuario, ArrayList<es.uco.pw.classes.Usuario> usuarios, es.uco.pw.classes.Pista pista, es.uco.pw.factory.Reserva reserva){
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
	
	public void hacerReservaBono(es.uco.pw.factory.Reserva reserva, es.uco.pw.classes.Usuario usuario, ArrayList<es.uco.pw.classes.Usuario> usuarios){
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
	
	public void establecerprecio(es.uco.pw.factory.Reserva reserva){
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

	/**
	 * Método público para modificar la reserva
	 * @param reserva
	 * @param usuario
	 * @return none
	 */
	
	public void modificarReserva(es.uco.pw.factory.Reserva reserva, es.uco.pw.classes.Usuario usuario){
		if(reserva.getDate().before(new Date())) {
			reserva.setDate(reserva.getDate());
			reserva.setDuration(reserva.getDuration());
			reserva.setPistId(reserva.getPistId());
			reserva.setPrice(reserva.getPrice());
			reserva.setDiscount(reserva.getDiscount());
			reserva.setTypeRes(reserva.getTypeRes());
		}
	}

	/**
	 * Método público para ver el número de reservas futuras
	 * @param reserva
	 * @return nreservas
	 */
	
	public int reservasFuturas(ArrayList<es.uco.pw.factory.Reserva> reservas){
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
	
	public ArrayList<es.uco.pw.factory.Reserva> reservasDiaConcreto(ArrayList<es.uco.pw.factory.Reserva> reservas, Date fecha){
		ArrayList <es.uco.pw.factory.Reserva> reservasfecha = new ArrayList<es.uco.pw.factory.Reserva>();
		for(int i=0; i<reservas.size(); i++) {
			if(reservas.get(i).getDate().equals(fecha)) {
				reservasfecha.add(reservas.get(i));
			}
		}
		return reservasfecha;
	}

}