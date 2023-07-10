package 系统后台操作;

import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import 教师考勤管理系统界面.TeacherJF;

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
			count = TeacherJF.rsCount.getInt("行数");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return count;
	}
	//表格的行数
	public int getRowCount() {return rowCount();}
	//表格的列数
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
	//设置表格的列名
	public final String[] columnName = {"开始时间", "结束时间","情况"};
	public String getColumnName(int column) {
		return columnName[column];
	}
	public Class getColumnClass(int column) {
		return java.lang.String.class;	
	}
}
