package ϵͳ��̨����;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import ��ʦ���ڹ���ϵͳ����.RequestRecordPanel;


public class RequestSelect {
	public void requestselect() {
		String sql = "select C.request_no as ������, C.teacher_no as ��ʦ���, A.teacher_name as ��ʦ����, B.college_name as ѧԺ, B.profession_name as רҵ, C.admin_no as ����Ա���, C.request_type as ��������, C.request_contend as �������� , C.request_time as ����ʱ�� from teacherMWM as A, collegeMWM as B, requestMWM as C where A.teacher_no = C.teacher_no and A.college_profession = B.college_profession order by C.teacher_no";
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
				RequestRecordPanel.request_no.add(RequestRecordPanel.rs.getString("������"));
				RequestRecordPanel.teacher_no.add(RequestRecordPanel.rs.getString("��ʦ���"));
				RequestRecordPanel.teacher_name.add(RequestRecordPanel.rs.getString("��ʦ����"));
				RequestRecordPanel.college_name.add(RequestRecordPanel.rs.getString("ѧԺ"));
				RequestRecordPanel.profession_name.add(RequestRecordPanel.rs.getString("רҵ"));
				RequestRecordPanel.admin_no.add(RequestRecordPanel.rs.getString("����Ա���"));
				RequestRecordPanel.request_type.add(RequestRecordPanel.rs.getString("��������"));
				RequestRecordPanel.request_contend.add(RequestRecordPanel.rs.getString("��������"));
				RequestRecordPanel.request_time.add(RequestRecordPanel.rs.getString("����ʱ��"));
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
				sql = "select admin_name as ����Ա����, admin_telephone as ����Ա��ϵ�绰, admin_mailbox as ����Ա��ϵ���� from adminMWM where admin_no = \'";
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
						RequestRecordPanel.admin_name.add(RequestRecordPanel.rs.getString("����Ա����"));
						RequestRecordPanel.admin_telephone.add(RequestRecordPanel.rs.getString("����Ա��ϵ�绰"));
						RequestRecordPanel.admin_mailbox.add(RequestRecordPanel.rs.getString("����Ա��ϵ����"));
					}
				} catch (SQLException e2) {
					e2.printStackTrace();	
				}
			}
		}
	}
}
