package utils;

public class StringUtils {
	public static boolean isEmpty(String s) {
		if (s == null || "".equals(s.trim())) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNotEmpty(String s) {
		if (s != null || !"".equals(s.trim())) {
			return true;
		} else {
			return false;
		}
	}
}
