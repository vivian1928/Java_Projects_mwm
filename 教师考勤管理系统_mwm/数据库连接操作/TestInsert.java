package ���ݿ����Ӳ���;

import java.sql.SQLException;
import java.sql.Statement;

import ϵͳ��̨����.Main;

public class TestInsert {
	public void insert() {
		Statement stmt = null;	//����statement��ɾ�����
		try {
			stmt = SqlConnect.ct.createStatement();	//������
		} catch (SQLException e) {
        // TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql_1 = "Insert into dbo.adminMWM values(\'xxxxx\',\'����\',\'Ů\',\'D:\\picture\',\'2019-12-15\',\'����\',\'18776909202\',\'\',\'abc123\')";
		int count_1 = 0;
		try {
			count_1 = stmt.executeUpdate(sql_1);
			System.out.println(count_1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(SqlConnect.ct!=null){
	               try {
	            	   SqlConnect.ct.rollback();
	               } catch (SQLException e1) {
	                   e1.printStackTrace();
	               }
	        }
			e.printStackTrace();
		}//����ֵ��ʾ��ɾ�ļ�������
//		try {
//			SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
////			Main.sqlconnect.ps.setString(1, "xxxxx");
////			Main.sqlconnect.ps.setString(2, Main.adminor.name);
////			Main.sqlconnect.ps.setString(3, Main.adminor.sex);
////			Main.sqlconnect.ps.setString(4, Main.adminor.picture);
////			Main.sqlconnect.ps.setString(5, Main.adminor.register_time);
////			Main.sqlconnect.ps.setString(6, Main.adminor.position);
////			Main.sqlconnect.ps.setString(7, Main.adminor.telephone);
////			Main.sqlconnect.ps.setString(8, Main.adminor.mailbox);
////			Main.sqlconnect.ps.setString(9, Main.adminor.code);
//			SqlConnect.ps.executeUpdate();
//			System.out.println("����ɹ���");
//		}catch(Exception e1) {
//			e1.printStackTrace();
//		}
	}
}
