package 系统后台操作;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import 教师考勤管理系统界面.AttendRecordPanel;

public class AttendSelect {
	public void attendselect() {
		String sql1 = "select C.teacher_no as 编号, A.teacher_name as 姓名,B.college_name as 学院, B.profession_name as 专业, C.rstart as 上班打卡时间, C.rend as 下班打卡时间, C.consequence as 考勤情况 from teacherMWM as A, collegeMWM as B, attendMWM as C where A.teacher_no = C.teacher_no and A.college_profession = B.college_profession order by C.teacher_no";
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			AttendRecordPanel.rs = Main.sqlconnect.stmt.executeQuery(sql1);
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
		AttendRecordPanel.teacher_no = new ArrayList<String>();
		AttendRecordPanel.teacher_name = new ArrayList<String>();
		AttendRecordPanel.college_name = new ArrayList<String>();
		AttendRecordPanel.profession_name = new ArrayList<String>();
		AttendRecordPanel.rstart = new ArrayList<String>();
		AttendRecordPanel.rend = new ArrayList<String>();
		AttendRecordPanel.consequence = new ArrayList<String>();
		try {
			while(AttendRecordPanel.rs.next()) {
				AttendRecordPanel.teacher_no.add(AttendRecordPanel.rs.getString("编号"));
				AttendRecordPanel.teacher_name.add(AttendRecordPanel.rs.getString("姓名"));
				AttendRecordPanel.college_name.add(AttendRecordPanel.rs.getString("学院"));
				AttendRecordPanel.profession_name.add(AttendRecordPanel.rs.getString("专业"));
				AttendRecordPanel.rstart.add(AttendRecordPanel.rs.getString("上班打卡时间"));
				AttendRecordPanel.rend.add(AttendRecordPanel.rs.getString("下班打卡时间"));
				AttendRecordPanel.consequence.add(AttendRecordPanel.rs.getString("考勤情况"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
	}
}
