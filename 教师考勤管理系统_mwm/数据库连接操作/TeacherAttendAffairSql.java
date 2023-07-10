package 数据库连接操作;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import 教师考勤管理系统界面.TeacherJF;
import 系统后台操作.Main;

public class TeacherAttendAffairSql {
	public void sqlaction() {
		String sql1 = "select rstart as 上班打卡时间, rend as 下班打卡时间, consequence as 打卡结果 from attendMWM where teacher_no = \'";
		sql1 += Main.teacher.getNo() + "\'";
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
		TeacherJF.start_time = new ArrayList<String>();
		TeacherJF.end_time = new ArrayList<String>();
		TeacherJF.conseq = new ArrayList<String>();
		try {
			while(TeacherJF.rs.next()) {
				TeacherJF.start_time.add(TeacherJF.rs.getString("上班打卡时间"));
				TeacherJF.end_time.add(TeacherJF.rs.getString("下班打卡时间"));
				TeacherJF.conseq.add(TeacherJF.rs.getString("打卡结果"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		sql1 = "select affair_start as 请求开始时间, affair_end as 请求结束时间, reason as 原因 from affairMWM where teacher_no = \'";
		sql1 += Main.teacher.getNo() + "\'";
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
				TeacherJF.start_time.add(TeacherJF.rs.getString("请求开始时间"));
				TeacherJF.end_time.add(TeacherJF.rs.getString("请求结束时间"));
				TeacherJF.conseq.add(TeacherJF.rs.getString("原因"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
	}
}
