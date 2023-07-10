package 系统后台操作;

public class Bissextile {
	private int year;
	public Bissextile(int year) {
		this.year = year;
	}
	public boolean judge() {
		if(year%4==0&&year%100!=0||year%400==0){
            return true;
        }else{
            return false;
        }
	}
}
