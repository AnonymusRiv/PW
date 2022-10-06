package es.uco.pw.classes;
import java.util.Date;

public class ReservaIndividual extends crearReserva{

	protected Date date;
	
	public ReservaIndividual() {
		super();
	}

	public ReservaIndividual(int userid, Date date) {
		this.userid=userid;
		this.date=date;
	}
	
	
}
