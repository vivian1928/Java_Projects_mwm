package ϵͳ��̨����;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ��ʦ���ڹ���ϵͳ����.AffairRecordPanel;

public class AffairSelect {
	public void affairselect() {
		String sql1 = "select C.affair_no as ������, C.teacher_no as ���, A.teacher_name as ����,B.college_name as ѧԺ, B.profession_name as רҵ, C.affair_type as ��������, C.affair_start as ����ʼʱ��, C.affair_end as �������ʱ��, C.affair_end - C.affair_start as ����ʱ��, C.reason as ����ԭ�� from teacherMWM as A, collegeMWM as B, affairMWM as C where A.teacher_no = C.teacher_no and A.college_profession = B.college_profession order by C.teacher_no";
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
				AffairRecordPanel.affair_no.add(AffairRecordPanel.rs.getString("������"));
				AffairRecordPanel.teacher_no.add(AffairRecordPanel.rs.getString("���"));
				AffairRecordPanel.teacher_name.add(AffairRecordPanel.rs.getString("����"));
				AffairRecordPanel.college_name.add(AffairRecordPanel.rs.getString("ѧԺ"));
				AffairRecordPanel.profession_name.add(AffairRecordPanel.rs.getString("רҵ"));
				AffairRecordPanel.affair_type.add(AffairRecordPanel.rs.getString("��������"));
				AffairRecordPanel.affair_start.add(AffairRecordPanel.rs.getString("����ʼʱ��"));
				AffairRecordPanel.affair_end.add(AffairRecordPanel.rs.getString("�������ʱ��"));
				AffairRecordPanel.affair_time.add(AffairRecordPanel.rs.getString("����ʱ��"));
				AffairRecordPanel.reason.add(AffairRecordPanel.rs.getString("����ԭ��"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();	
		}
	}
}
