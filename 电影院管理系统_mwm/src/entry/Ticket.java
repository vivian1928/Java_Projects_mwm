package entry;

public class Ticket {
	private int tId;
	private int uId;
	private int sId;
	private int seatNumber;

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public Ticket(int uId, int sId, int seatNumber) {
		super();
		this.uId = uId;
		this.sId = sId;
		this.seatNumber = seatNumber;
	}

	public Ticket(int tId, int uId, int sId, int seatNumber) {
		super();
		this.tId = tId;
		this.uId = uId;
		this.sId = sId;
		this.seatNumber = seatNumber;
	}

	public Ticket() {
		super();
	}

	@Override
	public String toString() {
		return "Ticket [tId=" + tId + ", uId=" + uId + ", sId=" + sId + ", seatNumber=" + seatNumber + "]";
	}

}
