package entry;

public class Cinema {
	private int cId;
	private String cName;
	private String address;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Cinema() {
		super();
	}

	public Cinema(String cName, String address) {
		super();
		this.cName = cName;
		this.address = address;
	}

	public Cinema(int cId, String cName, String address) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.address = address;
	}

	@Override
	public String toString() {
		if (cId == -1) {
			return cName;
		}
		return cName + "(ID:" + cId + ")";
	}
}
