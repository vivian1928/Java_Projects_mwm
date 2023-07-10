package 系统后台操作;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import 教师考勤管理系统界面.Admin;
import 教师考勤管理系统界面.FindPassword;
import 教师考勤管理系统界面.Login;
import 教师考勤管理系统界面.RegisterNormal;
import 教师考勤管理系统界面.TeacherJF;
import 数据库连接操作.InfoTable;
import 数据库连接操作.SqlConnect;

public class Main {
	public static Login login = new Login();
	public static RegisterNormal registernormal = new RegisterNormal();
	public static SqlConnect sqlconnect = new SqlConnect();
	public static FindPassword findpassword = new FindPassword();
	public static Admin admin;
	public static TeacherJF teacherjf;
	public static Teacher teacher = new Teacher();
	public static Administrator adminor = new Administrator();
	public static Account account = new Account();
	public static TeleorMail teleormail;
	public static int count_1 = 0;
	public static InfoTable infotable = new  InfoTable();
	
	public static void main(String[] args) {
		login.paint();
	}
}
