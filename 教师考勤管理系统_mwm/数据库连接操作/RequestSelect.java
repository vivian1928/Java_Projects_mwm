package 数据库连接操作;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import 教师考勤管理系统界面.TeacherJF;
import 系统后台操作.Main;

public class RequestSelect {
	public void sqlaction() {
		TeacherJF.a_type = new ArrayList();
		TeacherJF.a_start = new ArrayList();
		TeacherJF.a_end = new ArrayList();
		TeacherJF.reason = new ArrayList();
		TeacherJF.admin_no = new ArrayList();
		TeacherJF.admin_name = new ArrayList();
		TeacherJF.admin_telephone = new ArrayList();
		TeacherJF.admin_mailbox = new ArrayList();
		
		String sql = "select * from affairMWM where teacher_no = " + Main.teacher.getNo();
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			TeacherJF.rs = Main.sqlconnect.stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Main.sqlconnect.ct.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	final ArrayList<String> af_no = new ArrayList<String>();
	//	final ArrayList<String> teacher_no = new ArrayList<String>();
		
		try {
			while(TeacherJF.rs.next()) {
				TeacherJF.a_type.add(TeacherJF.rs.getString("affair_type"));
				TeacherJF.a_start.add(TeacherJF.rs.getString("affair_start"));
				TeacherJF.a_end.add(TeacherJF.rs.getString("affair_end"));
				TeacherJF.reason.add(TeacherJF.rs.getString("reason"));
				TeacherJF.admin_no.add(TeacherJF.rs.getString("admin_no"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		
		sql = "select * from requestMWM where teacher_no = " + Main.teacher.getNo();
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			TeacherJF.rs = Main.sqlconnect.stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Main.sqlconnect.ct.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(TeacherJF.rs.next()) {
				TeacherJF.a_type.add(TeacherJF.rs.getString("request_type"));
				TeacherJF.a_start.add(TeacherJF.rs.getString("request_time"));
				TeacherJF.a_end.add(TeacherJF.rs.getString("request_time"));
				TeacherJF.reason.add(TeacherJF.rs.getString("request_contend"));
				TeacherJF.admin_no.add(TeacherJF.rs.getString("admin_no"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		Iterator<String> no = TeacherJF.admin_no.iterator();
		String adminno;
		while(no.hasNext()) {
			adminno = no.next();
			if(adminno == null || adminno.length() == 0) {
				TeacherJF.admin_name.add("");
				TeacherJF.admin_telephone.add("");
				TeacherJF.admin_mailbox.add("");
			}else {
				String sql1 = "select admin_name as 管理员姓名, admin_telephone as 管理员联系电话, admin_mailbox as 管理员联系邮箱 from adminMWM where admin_no = \'";
				sql1 += adminno;
				sql1 += "\'";
				try {
					Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					TeacherJF.rs = Main.sqlconnect.stmt.executeQuery(sql1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Main.sqlconnect.ct.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					while(TeacherJF.rs.next()) {
						TeacherJF.admin_name.add(TeacherJF.rs.getString("管理员姓名"));
						TeacherJF.admin_telephone.add(TeacherJF.rs.getString("管理员联系电话"));
						TeacherJF.admin_mailbox.add(TeacherJF.rs.getString("管理员联系邮箱"));
					}
				} catch (SQLException e2) {
					e2.printStackTrace();	
				}
			}
		}
	}
}
