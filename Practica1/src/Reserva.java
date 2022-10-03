import java.util.Date;

public class Reserva {
	private int userid;
	private Date reserve;
	private int duration;
	private int pistaid;
	private float price;
	private int discount;
	
	//Constructor sin parámetros
	public Reserva() {
		super();
	}

	//Métodos get y set
	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public Date getReserve() {
		return reserve;
	}


	public void setReserve(Date reserve) {
		this.reserve = reserve;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getPistaid() {
		return pistaid;
	}


	public void setPistaid(int pistaid) {
		this.pistaid = pistaid;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}

	
	public int getDiscount() {
		return discount;
	}

	
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	
	//Método toString
	@Override
	public String toString() {
		return "Reserva [userid=" + userid + ", reserve=" + reserve + ", duration=" + duration + ", pistaid=" + pistaid
				+ ", price=" + price + ", discount=" + discount + "]";
	}
	
	

}
