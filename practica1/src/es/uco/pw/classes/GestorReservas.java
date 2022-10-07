package es.uco.pw.classes;

import java.util.ArrayList;
import java.time.LocalDate;

public class GestorReservas {


	public void hacerReservaIndividual(Usuario usuario, ArrayList<Usuario> usuarios, Pista pista, Reserva reserva){
		float precio;
		for(int i=0;i<usuarios.size();i++){
			if(usuarios.get(i).getid()==usuario.getid()){
				//if pista cumpla condiciones
				if(usuario.calcularAntiguedad() > 2) {
					reserva.setDiscount(10);
				}
			}
		}
	}

	public void hacerReservaBono(){
	
	}
	
	public void precioReservaDuracion(Reserva reserva){
		if(reserva.getDuration() == 60){
			reserva.setPrice(20);
		}
		else if(reserva.getDuration() == 90){
			reserva.setPrice(30);
		}
		else if(reserva.getDuration() == 120){
			reserva.setPrice(40);
		}
	}

	public void modificarReserva(Reserva reserva){
	
	}

	public void reservasFuturas(Reserva reserva){
	
	}

	public void reservasDiaConcreto(Reserva reserva, LocalDate fecha){
		/**if((reserva.getreserve() == fecha) && (pista.getName() == reserva.getid())){
			System.out.println(reserva.get(i).getreserve());
		}*/
	}

}