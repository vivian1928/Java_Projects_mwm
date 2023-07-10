package entry;

public class Session {
	private int sId;
	private int hId;
	private int cId;
	private int mId;
	private String time;
	private int price;
	private int remaindSeat;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int gethId() {
		return hId;
	}

	public void sethId(int hId) {
		this.hId = hId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRemaindSeat() {
		return remaindSeat;
	}

	public void setRemaindSeat(int remaindSeat) {
		this.remaindSeat = remaindSeat;
	}

	public Session() {
		super();
	}
	
	public Session(int hId, int cId, int mId, String time, int price, int remaindSeat) {
		super();
		this.hId = hId;
		this.cId = cId;
		this.mId = mId;
		this.time = time;
		this.price = price;
		this.remaindSeat = remaindSeat;
	}
	
	public Session(int sId, int hId, int cId, int mId, String time, int price) {
		super();
		this.sId = sId;
		this.hId = hId;
		this.cId = cId;
		this.mId = mId;
		this.time = time;
		this.price = price;
	}

	public Session(int sId, int hId, int cId, int mId, String time, int price, int remaindSeat) {
		super();
		this.sId = sId;
		this.hId = hId;
		this.cId = cId;
		this.mId = mId;
		this.time = time;
		this.price = price;
		this.remaindSeat = remaindSeat;
	}

	@Override
	public String toString() {
		return "Session [sId=" + sId + ", hId=" + hId + ", cId=" + cId + ", mId=" + mId + ", time=" + time + ", price="
				+ price + ", remaindSeat=" + remaindSeat + "]";
	}
}
