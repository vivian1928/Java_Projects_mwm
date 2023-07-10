package entry;

public class User {
	private int uId;
	private String uName;
	private String password;
	private int level;
	private int money;
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public User() {
		super();
	}
	
	public User(String uName, String password, int level, int money) {
		super();
		this.uName = uName;
		this.password = password;
		this.level = level;
		this.money = money;
	}
	public User(int uId, String uName, String password, int level, int money) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.password = password;
		this.level = level;
		this.money = money;
	}
	
	public User(String uName, String password) {
		super();
		this.uName = uName;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", password=" + password + ", level=" + level + ", money="
				+ money + "]";
	}
	
}
