package ���ݿ����Ӳ���;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLHelper {
	
	public static Connection ct = null; 
	public static PreparedStatement ps=null;
	public static ResultSet rs=null;
	public static Statement stmt = null;
	
	public SQLHelper() {
		update();
	}
	
	public static void update() {
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL���ݿ�����
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=MWM";//����Դ ��TCP�˿�Ϊ1433�����ݿ�����Ϊteacherattenddb
		String Name="sa";	//�û�����ʽ��¼
		String Pwd="sa";	//����Ϊsa
		try{
			Class.forName(driverName);						//�������ݿ�com.microsoft.sqlserver.jdbc.SQLServerDriver��
			ct=DriverManager.getConnection(dbURL,Name,Pwd);	//	����DriverManager�ķ������������ݿ�����
			ct.setAutoCommit(false);		//�������ݿ��ֶ��ύ��ʽ
			System.out.println("�������ݿ�ɹ�");
		}catch(Exception e){
			
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
	}
	public ResultSet executeQuery(String sql) {
		ResultSet rs=null;
		try	{
			rs = stmt.executeQuery(sql);
		}catch (Exception e){
			 System.out.println("ִ��QUERYʧ�ܣ�"+sql); 
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close() {
		try	{
			stmt.close();ct.close();
		}catch (Exception e){
			 System.out.println("�ر�ʧ�ܣ�"); 
			e.printStackTrace();
		}
	}
	
	
}
