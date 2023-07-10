package 系统后台操作;

public class TeleorMail {
	private String teleormail = null;
	public TeleorMail(String teleormail) {
		this.teleormail = teleormail;
	}
	
	public boolean judge() {
		boolean j = false;
		char judge[] = new char[100];
		judge = teleormail.toCharArray();
		for(char i : judge) {
			if(i >= 65 && i <= 90 || i >= 97 && i <= 122) {
				j = true;
				break;
			}
		}
		return j;//false表示是电话号码,true表示是邮箱
	}
}
