package ϵͳ��̨����;

import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import ��ʦ���ڹ���ϵͳ����.TeacherJF;

public class AttendAffairTable extends AbstractTableModel{
		//�õ��ж�������¼ 
		public int rowCount() {
			String sqlCount = "select count(*) as ���� from attendMWM";
			try {
				TeacherJF.rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int count = 0;
			try {
				TeacherJF.rsCount.next();
				count = TeacherJF.rsCount.getInt("����");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			sqlCount = "select count(*) as ���� from affairMWM";
			try {
				TeacherJF.rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				TeacherJF.rsCount.next();
				count += TeacherJF.rsCount.getInt("����");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return count;
		}
		//��������
		public int getRowCount() {return rowCount();}
		//��������
		public int getColumnCount() {return 3;}
		
		public Object getValueAt(int row, int col) {
			switch(col) {
			case 0:
				return TeacherJF.start_time.get(row);
			case 1:
				return TeacherJF.end_time.get(row);
			case 2:
				return TeacherJF.conseq.get(row);
			}
			return null;
		}
		//���ñ�������
		public final String[] columnName = {"��ʼʱ��", "����ʱ��","���"};
		public String getColumnName(int column) {
			return columnName[column];
		}
		public Class getColumnClass(int column) {
			return java.lang.String.class;	
    	}
}
