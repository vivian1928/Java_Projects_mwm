package 系统后台操作;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import 教师考勤管理系统界面.AttendRecordPanel;
import 教师考勤管理系统界面.InfoManagePanel;
import 数据库连接操作.SqlConnect;

public class AddTableModel extends AbstractTableModel{
	public static int oldrownumber = AttendRecordPanel.tModel.getRowCount();	//没有添加前的行数
	public static boolean insert = false;
	public static String teacher_no = "请输入教师编号";
	public static String teacher_name = "";
	public static String college_name = "";
	public static String profession_name = "";
	public static String rstart = "请输入上班打卡时间";
	public static String rend = "请输入下班打卡时间";
	public static String consequence = "";
	
	public int rowCount() {
		return oldrownumber + 1;
	}
	//表格的行数
	public int getRowCount() {return rowCount();}
	//表格的列数
	public int getColumnCount() {return 7;}
	
	public Object getValueAt(int row, int col) {
		if(row < oldrownumber) {
			switch(col) {
			case 0:
				return AttendRecordPanel.teacher_no.get(row);
			case 1:
				return AttendRecordPanel.teacher_name.get(row);
			case 2:
				return AttendRecordPanel.college_name.get(row);
			case 3:
				return AttendRecordPanel.profession_name.get(row);
			case 4:
				return AttendRecordPanel.rstart.get(row);
			case 5:
				return AttendRecordPanel.rend.get(row);
			case 6:
				return AttendRecordPanel.consequence.get(row);
			}
		}else {
			switch(col) {
			case 0:
				return teacher_no;
			case 1:
				return teacher_name;
			case 2:
				return college_name;
			case 3:
				return profession_name;
			case 4:
				return rstart;
			case 5:
				return rend;
			case 6:
				return consequence;
			}
		}
		return null;
	}
	//设置表格的列名
	public final String[] columnName = {"编号", "姓名","学院","专业","上班打卡时间","下班打卡时间","考勤情况"};
	public String getColumnName(int column) {
		return columnName[column];
	}
	public Class getColumnClass(int column) {
		return java.lang.String.class;	
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
        return rowIndex == oldrownumber && columnIndex != 1 && columnIndex != 2 && columnIndex != 3 && columnIndex != 6;
    }
	public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
        // 设置新的单元格数据时，必须把新值设置到原数据数值中，
//        // 待更新UI重新调用 getValueAt(...) 获取单元格值时才能获取到最新值
		switch(columnIndex) {
		case 0:
			teacher_no = (String) newValue;
			break;
		case 4:
			rstart = (String) newValue;
			break;
		case 5:
			rend = (String) newValue;
			break;
		}
		// 设置完数据后，必须通知表格去更新UI（重绘单元格），否则显示的数据不会改变
		fireTableCellUpdated(rowIndex, columnIndex);
    }
}
