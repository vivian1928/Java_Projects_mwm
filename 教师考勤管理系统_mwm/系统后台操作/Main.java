package ϵͳ��̨����;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import ��ʦ���ڹ���ϵͳ����.Admin;
import ��ʦ���ڹ���ϵͳ����.FindPassword;
import ��ʦ���ڹ���ϵͳ����.Login;
import ��ʦ���ڹ���ϵͳ����.RegisterNormal;
import ��ʦ���ڹ���ϵͳ����.TeacherJF;
import ���ݿ����Ӳ���.InfoTable;
import ���ݿ����Ӳ���.SqlConnect;

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
