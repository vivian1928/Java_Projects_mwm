package 系统后台操作;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import 教师考勤管理系统界面.TeacherJF;

public class AttendSelect_1 {
	public void arSql(String sql) {
		TeacherJF.rstart = new ArrayList();
		TeacherJF.rend = new ArrayList();
		TeacherJF.consequence = new ArrayList();
		
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
				TeacherJF.rstart.add(TeacherJF.rs.getString("rstart"));
				TeacherJF.rend.add(TeacherJF.rs.getString("rend"));
				TeacherJF.consequence.add(TeacherJF.rs.getString("consequence"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		
	}
}
