package 系统后台操作;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import 教师考勤管理系统界面.RequestRecordPanel;


public class RequestSelect {
	public void requestselect() {
		String sql = "select C.request_no as 申请编号, C.teacher_no as 教师编号, A.teacher_name as 教师姓名, B.college_name as 学院, B.profession_name as 专业, C.admin_no as 管理员编号, C.request_type as 申请类型, C.request_contend as 申请内容 , C.request_time as 申请时间 from teacherMWM as A, collegeMWM as B, requestMWM as C where A.teacher_no = C.teacher_no and A.college_profession = B.college_profession order by C.teacher_no";
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			RequestRecordPanel.rs = Main.sqlconnect.stmt.executeQuery(sql);
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
		RequestRecordPanel.request_no = new ArrayList<String>();
		RequestRecordPanel.teacher_no = new ArrayList<String>();
		RequestRecordPanel.teacher_name = new ArrayList<String>();
		RequestRecordPanel.college_name = new ArrayList<String>();
		RequestRecordPanel.profession_name = new ArrayList<String>();
		RequestRecordPanel.admin_no = new ArrayList<String>();
		RequestRecordPanel.admin_name = new ArrayList<String>();
		RequestRecordPanel.admin_telephone = new ArrayList<String>();
		RequestRecordPanel.admin_mailbox = new ArrayList<String>();
		RequestRecordPanel.request_type = new ArrayList<String>();
		RequestRecordPanel.request_contend = new ArrayList<String>();
		RequestRecordPanel.request_time = new ArrayList<String>();
		try {
			while(RequestRecordPanel.rs.next()) {
				RequestRecordPanel.request_no.add(RequestRecordPanel.rs.getString("申请编号"));
				RequestRecordPanel.teacher_no.add(RequestRecordPanel.rs.getString("教师编号"));
				RequestRecordPanel.teacher_name.add(RequestRecordPanel.rs.getString("教师姓名"));
				RequestRecordPanel.college_name.add(RequestRecordPanel.rs.getString("学院"));
				RequestRecordPanel.profession_name.add(RequestRecordPanel.rs.getString("专业"));
				RequestRecordPanel.admin_no.add(RequestRecordPanel.rs.getString("管理员编号"));
				RequestRecordPanel.request_type.add(RequestRecordPanel.rs.getString("申请类型"));
				RequestRecordPanel.request_contend.add(RequestRecordPanel.rs.getString("申请内容"));
				RequestRecordPanel.request_time.add(RequestRecordPanel.rs.getString("申请时间"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		
		Iterator<String> no = RequestRecordPanel.admin_no.iterator();
		String adminno;
		while(no.hasNext()) {
			adminno = no.next();
			if(adminno == null) {
				RequestRecordPanel.admin_name.add("");
				RequestRecordPanel.admin_telephone.add("");
				RequestRecordPanel.admin_mailbox.add("");
			}else {
				sql = "select admin_name as 管理员姓名, admin_telephone as 管理员联系电话, admin_mailbox as 管理员联系邮箱 from adminMWM where admin_no = \'";
				sql += adminno;
				sql += "\'";
				try {
					Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					RequestRecordPanel.rs = Main.sqlconnect.stmt.executeQuery(sql);
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
					while(RequestRecordPanel.rs.next()) {
						RequestRecordPanel.admin_name.add(RequestRecordPanel.rs.getString("管理员姓名"));
						RequestRecordPanel.admin_telephone.add(RequestRecordPanel.rs.getString("管理员联系电话"));
						RequestRecordPanel.admin_mailbox.add(RequestRecordPanel.rs.getString("管理员联系邮箱"));
					}
				} catch (SQLException e2) {
					e2.printStackTrace();	
				}
			}
		}
	}
}
