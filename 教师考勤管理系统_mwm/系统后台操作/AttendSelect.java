package ϵͳ��̨����;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ��ʦ���ڹ���ϵͳ����.AttendRecordPanel;

public class AttendSelect {
	public void attendselect() {
		String sql1 = "select C.teacher_no as ���, A.teacher_name as ����,B.college_name as ѧԺ, B.profession_name as רҵ, C.rstart as �ϰ��ʱ��, C.rend as �°��ʱ��, C.consequence as ������� from teacherMWM as A, collegeMWM as B, attendMWM as C where A.teacher_no = C.teacher_no and A.college_profession = B.college_profession order by C.teacher_no";
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
				AttendRecordPanel.teacher_no.add(AttendRecordPanel.rs.getString("���"));
				AttendRecordPanel.teacher_name.add(AttendRecordPanel.rs.getString("����"));
				AttendRecordPanel.college_name.add(AttendRecordPanel.rs.getString("ѧԺ"));
				AttendRecordPanel.profession_name.add(AttendRecordPanel.rs.getString("רҵ"));
				AttendRecordPanel.rstart.add(AttendRecordPanel.rs.getString("�ϰ��ʱ��"));
				AttendRecordPanel.rend.add(AttendRecordPanel.rs.getString("�°��ʱ��"));
				AttendRecordPanel.consequence.add(AttendRecordPanel.rs.getString("�������"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
	}
}
