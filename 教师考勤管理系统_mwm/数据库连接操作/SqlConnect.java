package ���ݿ����Ӳ���;

import java.sql.*;

import ϵͳ��̨����.Main;

public class SqlConnect {
	
	public static Connection ct = null; 
	public static PreparedStatement ps=null;
	public static ResultSet rs=null;
	public static Statement stmt = null;
	
	public SqlConnect() {
		update();
	}
	
//	public static void main(String[] args) {
//		update();
//	}

	public static void update() {
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL���ݿ�����
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=MWM";//����Դ ��TCP�˿�Ϊ1433�����ݿ�����Ϊteacherattenddb
		String Name="sa";	//�û�����ʽ��¼
		String Pwd="sa";	//����Ϊsa
		try{
			Class.forName(driverName);//�������ݿ�com.microsoft.sqlserver.jdbc.SQLServerDriver��
			ct=DriverManager.getConnection(dbURL,Name,Pwd);	//	����DriverManager�ķ������������ݿ�����
			ct.setAutoCommit(false);		//�������ݿ��ֶ��ύ��ʽ
			System.out.println("�������ݿ�ɹ�");
		}catch(Exception e){
			
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
	}
	
	public static void close() {
		try {
			stmt.close();
		} catch (SQLException e) {
        // TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ct.close();
			System.out.println("�ر����ݿ�ɹ�");
		} catch (SQLException e) {
        // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
