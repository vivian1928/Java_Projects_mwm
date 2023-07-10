package entry;

public class Hall {
	private int hId;
	private String hName;
	private int cId;
	private int maxPNumber;
	
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public String gethName() {
		return hName;
	}
	public void sethName(String hName) {
		this.hName = hName;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getMaxPNumber() {
		return maxPNumber;
	}
	public void setMaxPNumber(int maxPNumber) {
		this.maxPNumber = maxPNumber;
	}
	
	public Hall(String hName, int cId, int maxPNumber) {
		super();
		this.hName = hName;
		this.cId = cId;
		this.maxPNumber = maxPNumber;
	}
	public Hall(int hId, String hName, int cId, int maxPNumber) {
		super();
		this.hId = hId;
		this.hName = hName;
		this.cId = cId;
		this.maxPNumber = maxPNumber;
	}
	
	public Hall() {
		super();
	}
	
	@Override
	public String toString() {
		if (hId==-1) {
			return hName;
		}
		return hName + "(ID:" + hId +")";
	}
}
