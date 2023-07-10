package 系统后台操作;

import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import 教师考勤管理系统界面.TeacherJF;

public class AttendAffairTable extends AbstractTableModel{
		//拿到有多少条记录 
		public int rowCount() {
			String sqlCount = "select count(*) as 行数 from attendMWM";
			try {
				TeacherJF.rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int count = 0;
			try {
				TeacherJF.rsCount.next();
				count = TeacherJF.rsCount.getInt("行数");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			sqlCount = "select count(*) as 行数 from affairMWM";
			try {
				TeacherJF.rsCount = Main.sqlconnect.stmt.executeQuery(sqlCount);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				TeacherJF.rsCount.next();
				count += TeacherJF.rsCount.getInt("行数");
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
		//设置表格的列名
		public final String[] columnName = {"开始时间", "结束时间","情况"};
		public String getColumnName(int column) {
			return columnName[column];
		}
		public Class getColumnClass(int column) {
			return java.lang.String.class;	
    	}
}
