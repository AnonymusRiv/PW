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

	public void hacerReservaBono(es.uco.pw.factory.Reserva reserva, es.uco.pw.classes.Usuario usuario){
		
	}
	
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

	public void modificarReserva(es.uco.pw.factory.Reserva reserva, es.uco.pw.classes.Usuario usuario){
		if(reserva.getUserId() == "") {
			
		}
		else if(reserva.getUserId() == usuario.getEmail()) {
			
		}
	}

	public int reservasFuturas(ArrayList<es.uco.pw.factory.Reserva> reservas){
		int nreservas = 0;
		for(int i=0; i<reservas.size(); i++) {
			if(reservas.get(i).getDate().after(new Date())) {
				nreservas++;
			}
		}
		return nreservas;
	}

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