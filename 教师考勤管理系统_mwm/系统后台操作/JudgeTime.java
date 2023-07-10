package 系统后台操作;

public class JudgeTime {
	public boolean judge(String start, String end) {
		if(Integer.valueOf(start.substring(0, 4)) < Integer.valueOf(end.substring(0, 4))) {
			return true;
		}else if(start.substring(0, 4).equals(end.substring(0, 4)) && Integer.valueOf(start.substring(5, 7)) < Integer.valueOf(end.substring(5, 7))) {
			return true;
		}else if(start.substring(5, 7).equals(end.substring(5, 7))&& Integer.valueOf(start.substring(8, 10)) < Integer.valueOf(end.substring(8, 10))) {
			return true;
		}else if(start.substring(8, 10).equals(end.substring(8, 10)) && Integer.valueOf(start.substring(11, 13)) < Integer.valueOf(end.substring(11, 13))) {
			return true;
		}else if(start.substring(11, 13).equals(end.substring(11, 13)) && Integer.valueOf(start.substring(14, 16)) < Integer.valueOf(end.substring(14, 16))) {
			return true;
		}else if(start.substring(14, 16).equals(end.substring(14, 16)) && Integer.valueOf(start.substring(17, 19)) < Integer.valueOf(end.substring(17, 19))) {
			return true;
		}else {
			return false;
		}
	}
}
