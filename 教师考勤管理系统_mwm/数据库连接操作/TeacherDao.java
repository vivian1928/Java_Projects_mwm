package ���ݿ����Ӳ���;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import ϵͳ��̨����.Main;
import ϵͳ��̨����.Teacher;

public class TeacherDao {
	public void add_Affair(Affair a) {
		String sql = "insert into affairMWM values(\'" + a.getTno() + "',null," + "'" + Integer.parseInt(a.affair_type) + "','" + a.getAffair_start() + 
						"','" + a.getAffair_end() + "','" + a.getReason() +  "\')";
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			Main.sqlconnect.stmt.executeUpdate(sql);
			Main.sqlconnect.ct.commit();
			JOptionPane.showMessageDialog(null, "����ɹ���");
        }catch(Exception e1) {
        	JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
        }finally {
        	System.out.println(sql);
        }
	}
	//��������ѯ
	public void add_request(Affair a) {
		String sql = "insert into requestMWM values(\'" + a.getTno() + "',null,'"+ Integer.parseInt(a.affair_type) + "','" + a.getReason()+ "','" +a.getAffair_start() + "\')";
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			Main.sqlconnect.stmt.executeUpdate(sql);
			Main.sqlconnect.ct.commit();
			JOptionPane.showMessageDialog(null, "����ɹ���");
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
		}finally {
			System.out.println(sql);
		}
	}

}
