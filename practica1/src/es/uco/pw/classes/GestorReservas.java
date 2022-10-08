package es.uco.pw.classes;

import java.util.ArrayList;
import java.util.Date;

public class GestorReservas {


	public void hacerReservaIndividual(Usuario usuario, ArrayList<Usuario> usuarios, Pista pista, Reserva reserva){
		for(int i=0;i<usuarios.size();i++){
			if(usuarios.get(i).getmail()==usuario.getmail()){
				if((pista.getstatus() == true) && (pista.getdifficulty().equals(reserva.getType()) == true) && (pista.getnumber() < pista.getkarts().size())) {
					if(usuario.calcularAntiguedad() > 2) {
						reserva.setDiscount(10);
					}
				}
			}
		}
	}

	public void hacerReservaBono(){
	
	}
	
	public void establecerprecio(Reserva reserva){
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

	public void modificarReserva(Reserva reserva){
		
	}

	public int reservasFuturas(ArrayList<Reserva> reservas){
		int nreservas = 0;
		for(int i=0; i<reservas.size(); i++) {
			if(reservas.get(i).getReserve().after(new Date())) {
				nreservas++;
			}
		}
		return nreservas;
	}

	public ArrayList<Reserva> reservasDiaConcreto(ArrayList<Reserva> reservas, Date fecha){
		ArrayList <Reserva> reservasfecha = new ArrayList<Reserva>();
		for(int i=0; i<reservas.size(); i++) {
			if(reservas.get(i).getReserve().equals(fecha)) {
				reservasfecha.add(reservas.get(i));
			}
		}
		return reservasfecha;
	}

}