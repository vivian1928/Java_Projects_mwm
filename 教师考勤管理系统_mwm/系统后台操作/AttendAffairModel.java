package ϵͳ��̨����;

import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import ��ʦ���ڹ���ϵͳ����.TeacherJF;

public class AttendAffairModel extends AbstractTableModel{
	public String sqlCount = "";
	public int count = 0;
	public int count1 = 0;
	public AttendAffairModel(String sqlCount) {
		this.sqlCount = sqlCount;
		System.out.println(sqlCount);
	}
	public int rowCount() {
//			Statement stmtCount = DB.createStmt(conn);
		try {
			TeacherJF.rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			TeacherJF.rsCount.next();
			count = TeacherJF.rsCount.getInt("����");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return count;
	}
	//��������
	public int getRowCount() {return rowCount();}
	//��������
	public int getColumnCount() {return 9;}
	
	public Object getValueAt(int row, int col) {
		switch(col) {
		case 0:
			if(row < count) {
				if(Integer.valueOf(TeacherJF.a_type.get(row)) == 1) {
					return "����";
				}else if(Integer.valueOf(TeacherJF.a_type.get(row)) == 2) {
					return "���";
				}else if(Integer.valueOf(TeacherJF.a_type.get(row)) == 3) {
					return "�Ӱ�";
				}
			}else {
				if(Integer.valueOf(TeacherJF.a_type.get(row)) == 1) {
					return "�޸ĸ�����Ϣ";
				}else if(Integer.valueOf(TeacherJF.a_type.get(row)) == 2) {
					return "�޸Ŀ�����Ϣ";
				}else if(Integer.valueOf(TeacherJF.a_type.get(row)) == 3) {
					return "�޸�������Ϣ";
				}
			}
		case 1:
			return TeacherJF.a_start.get(row);
		case 2:
			return TeacherJF.a_end.get(row);
		case 3:
			return TeacherJF.reason.get(row);
		case 4:
			return TeacherJF.admin_no.get(row);
		case 5:
			return TeacherJF.admin_name.get(row);
		case 6:
			return TeacherJF.admin_telephone.get(row);
		case 7:
			return TeacherJF.admin_mailbox.get(row);
		case 8:
			if(TeacherJF.admin_no.get(row) == null || TeacherJF.admin_no.get(row).length() == 0) {
				return "δ���";
			}else {
				return "��ͨ��";
			}
		}
		return null;
	}
	//���ñ�������
	public final String[] columnName = {"�¼�����","��ʼʱ��", "����ʱ��","ԭ��","����Ա���","����Ա����","����Ա��ϵ�绰","����Ա��ϵ����","���״̬"};
	public String getColumnName(int column) {
		return columnName[column];
	}
	public Class getColumnClass(int column) {
		return java.lang.String.class;	
	}
}
