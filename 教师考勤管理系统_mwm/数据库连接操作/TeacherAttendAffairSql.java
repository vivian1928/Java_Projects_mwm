package ���ݿ����Ӳ���;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ��ʦ���ڹ���ϵͳ����.TeacherJF;
import ϵͳ��̨����.Main;

public class TeacherAttendAffairSql {
	public void sqlaction() {
		String sql1 = "select rstart as �ϰ��ʱ��, rend as �°��ʱ��, consequence as �򿨽�� from attendMWM where teacher_no = \'";
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
				TeacherJF.start_time.add(TeacherJF.rs.getString("�ϰ��ʱ��"));
				TeacherJF.end_time.add(TeacherJF.rs.getString("�°��ʱ��"));
				TeacherJF.conseq.add(TeacherJF.rs.getString("�򿨽��"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
		sql1 = "select affair_start as ����ʼʱ��, affair_end as �������ʱ��, reason as ԭ�� from affairMWM where teacher_no = \'";
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
				TeacherJF.start_time.add(TeacherJF.rs.getString("����ʼʱ��"));
				TeacherJF.end_time.add(TeacherJF.rs.getString("�������ʱ��"));
				TeacherJF.conseq.add(TeacherJF.rs.getString("ԭ��"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
	}
}
