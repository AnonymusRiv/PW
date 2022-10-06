package es.uco.pw.classes;

public class ReservaBono extends crearReserva{

	protected int numberofsesion;
	
	public ReservaBono() {
		super();
	}
	
	public ReservaBono(int id, int numberofsesion) {
		this.userid=id;
		this.numberofsesion=numberofsesion;
	}
	
	
}
