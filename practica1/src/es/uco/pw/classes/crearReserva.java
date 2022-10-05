package es.uco.pw.classes;

public class crearReserva extends Reserva{

	@Override
	public ReservaIndividual crearReservaIndividual() {
		ReservaIndividual reserva = new ReservaIndividual();
		return reserva;
	}
	
	@Override
	public ReservaBono crearReservaBono() {
		ReservaBono reserva = new ReservaBono();
		return reserva;
	}
}
