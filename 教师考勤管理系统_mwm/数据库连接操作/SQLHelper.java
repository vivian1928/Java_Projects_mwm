package 数据库连接操作;

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
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=MWM";//数据源 ，TCP端口为1433，数据库名称为teacherattenddb
		String Name="sa";	//用户名方式登录
		String Pwd="sa";	//密码为sa
		try{
			Class.forName(driverName);						//加载数据库com.microsoft.sqlserver.jdbc.SQLServerDriver类
			ct=DriverManager.getConnection(dbURL,Name,Pwd);	//	调用DriverManager的方法来进行数据库连接
			ct.setAutoCommit(false);		//设置数据库手动提交方式
			System.out.println("连接数据库成功");
		}catch(Exception e){
			
			e.printStackTrace();
			System.out.println("连接失败");
		}
	}
	public ResultSet executeQuery(String sql) {
		ResultSet rs=null;
		try	{
			rs = stmt.executeQuery(sql);
		}catch (Exception e){
			 System.out.println("执行QUERY失败！"+sql); 
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close() {
		try	{
			stmt.close();ct.close();
		}catch (Exception e){
			 System.out.println("关闭失败！"); 
			e.printStackTrace();
		}
	}
	
	
}
