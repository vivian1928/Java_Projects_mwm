package 系统后台操作;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import 教师考勤管理系统界面.AffairRecordPanel;

public class AffairSelect {
	public void affairselect() {
		String sql1 = "select C.affair_no as 请求编号, C.teacher_no as 编号, A.teacher_name as 姓名,B.college_name as 学院, B.profession_name as 专业, C.affair_type as 请求类型, C.affair_start as 请求开始时间, C.affair_end as 请求结束时间, C.affair_end - C.affair_start as 请求时间, C.reason as 请求原因 from teacherMWM as A, collegeMWM as B, affairMWM as C where A.teacher_no = C.teacher_no and A.college_profession = B.college_profession order by C.teacher_no";
		try {
			Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			AffairRecordPanel.rs = Main.sqlconnect.stmt.executeQuery(sql1);
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
		AffairRecordPanel.affair_no = new ArrayList<String>();
		AffairRecordPanel.teacher_no = new ArrayList<String>();
		AffairRecordPanel.teacher_name = new ArrayList<String>();
		AffairRecordPanel.college_name = new ArrayList<String>();
		AffairRecordPanel.profession_name = new ArrayList<String>();
		AffairRecordPanel.affair_type = new ArrayList<String>();
		AffairRecordPanel.affair_start = new ArrayList<String>();
		AffairRecordPanel.affair_end = new ArrayList<String>();
		AffairRecordPanel.affair_time = new ArrayList<String>();
		AffairRecordPanel.reason = new ArrayList<String>();
		try {
			while(AffairRecordPanel.rs.next()) {
				AffairRecordPanel.affair_no.add(AffairRecordPanel.rs.getString("请求编号"));
				AffairRecordPanel.teacher_no.add(AffairRecordPanel.rs.getString("编号"));
				AffairRecordPanel.teacher_name.add(AffairRecordPanel.rs.getString("姓名"));
				AffairRecordPanel.college_name.add(AffairRecordPanel.rs.getString("学院"));
				AffairRecordPanel.profession_name.add(AffairRecordPanel.rs.getString("专业"));
				AffairRecordPanel.affair_type.add(AffairRecordPanel.rs.getString("请求类型"));
				AffairRecordPanel.affair_start.add(AffairRecordPanel.rs.getString("请求开始时间"));
				AffairRecordPanel.affair_end.add(AffairRecordPanel.rs.getString("请求结束时间"));
				AffairRecordPanel.affair_time.add(AffairRecordPanel.rs.getString("请求时间"));
				AffairRecordPanel.reason.add(AffairRecordPanel.rs.getString("请求原因"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
	}
}
