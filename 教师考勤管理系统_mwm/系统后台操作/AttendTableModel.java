package ϵͳ��̨����;

import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import ��ʦ���ڹ���ϵͳ����.TeacherJF;

public class AttendTableModel extends AbstractTableModel{
	public int count = 0;
	public int count1 = 0;
	public String sqlCount = "";
	public AttendTableModel(String sqlCount) {
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
	public int getColumnCount() {return 3;}
	
	public Object getValueAt(int row, int col) {
		if(row < count) {
			switch(col) {
			case 0:
				return TeacherJF.rstart.get(row);
			case 1:
				return TeacherJF.rend.get(row);
			case 2:
				return TeacherJF.consequence.get(row);
			}
		}else {
			
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
