package 数据库连接操作;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import 系统后台操作.Main;
import 系统后台操作.Teacher;

public class TeacherDao {
	public void add_Affair(Affair a) {
		String sql = "insert into affairMWM values(\'" + a.getTno() + "',null," + "'" + Integer.parseInt(a.affair_type) + "','" + a.getAffair_start() + 
						"','" + a.getAffair_end() + "','" + a.getReason() +  "\')";
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			Main.sqlconnect.stmt.executeUpdate(sql);
			Main.sqlconnect.ct.commit();
			JOptionPane.showMessageDialog(null, "申请成功！");
        }catch(Exception e1) {
        	JOptionPane.showMessageDialog(null, "申请失败！");
        }finally {
        	System.out.println(sql);
        }
	}
	//按条件查询
	public void add_request(Affair a) {
		String sql = "insert into requestMWM values(\'" + a.getTno() + "',null,'"+ Integer.parseInt(a.affair_type) + "','" + a.getReason()+ "','" +a.getAffair_start() + "\')";
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			Main.sqlconnect.stmt.executeUpdate(sql);
			Main.sqlconnect.ct.commit();
			JOptionPane.showMessageDialog(null, "申请成功！");
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "申请失败！");
		}finally {
			System.out.println(sql);
		}
	}

}
