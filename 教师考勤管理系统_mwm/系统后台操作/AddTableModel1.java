package 系统后台操作;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import 教师考勤管理系统界面.AffairRecordPanel;
import 教师考勤管理系统界面.AttendRecordPanel;
import 教师考勤管理系统界面.InfoManagePanel;
import 数据库连接操作.SqlConnect;

public class AddTableModel1 extends AbstractTableModel{
	public static int oldrownumber = AffairRecordPanel.tModel.getRowCount();	//没有添加前的行数
	public static boolean insert = false;
	public static String affair_no = "";
	public static String teacher_no = "请输入教师编号";
	public static String teacher_name = "";
	public static String college_name = "";
	public static String profession_name = "";
	public static String admin_no = "";
	public static String admin_name = "";
	public static String admin_telephone = "";
	public static String admin_mailbox = "";
	public static String affair_type = "请输入请求类型";
	public static String affair_start = "请输入请求开始时间";
	public static String affair_end = "请输入请求结束时间";
	public static String affair_time = "";
	public static String reason = "请输入请求原因";
	
	public int rowCount() {
		return oldrownumber + 1;
	}
	//表格的行数
	public int getRowCount() {return rowCount();}
	//表格的列数
	public int getColumnCount() {return 14;}
	
	public Object getValueAt(int row, int col) {
		if(row < oldrownumber) {
			switch(col) {
			case 0:
				return AffairRecordPanel.affair_no.get(row);
			case 1:
				return AffairRecordPanel.teacher_no.get(row);
			case 2:
				return AffairRecordPanel.teacher_name.get(row);
			case 3:
				return AffairRecordPanel.college_name.get(row);
			case 4:
				return AffairRecordPanel.profession_name.get(row);
			case 5:
				return AffairRecordPanel.admin_no.get(row);
			case 6:
				return AffairRecordPanel.admin_name.get(row);
			case 7:
				return AffairRecordPanel.admin_telephone.get(row);
			case 8:
				return AffairRecordPanel.admin_mailbox.get(row);
			case 9:
				if(Integer.valueOf(AffairRecordPanel.affair_type.get(row)) == 1) {
					return "出差";
				}else if(Integer.valueOf(AffairRecordPanel.affair_type.get(row)) == 2) {
					return "请假";
				}else if(Integer.valueOf(AffairRecordPanel.affair_type.get(row)) == 3) {
					return "加班";
				}
			case 10:
				return AffairRecordPanel.affair_start.get(row);
			case 11:
				return AffairRecordPanel.affair_end.get(row);
			case 12:
				return AffairRecordPanel.affair_time.get(row);
			case 13:
				return AffairRecordPanel.reason.get(row);
			}
		}else {
			switch(col) {
			case 0:
				return affair_no;
			case 1:
				return teacher_no;
			case 2:
				return teacher_name;
			case 3:
				return college_name;
			case 4:
				return profession_name;
			case 5:
				return admin_no;
			case 6:
				return admin_name;
			case 7:
				return admin_telephone;
			case 8:
				return admin_mailbox;
			case 9:
				if(affair_type.equals("请输入请求类型")) {
					return "请输入请求类型";
				}
				else if(Integer.valueOf(affair_type) == 1) {
					return "出差";
				}else if(Integer.valueOf(affair_type) == 2) {
					return "请假";
				}else if(Integer.valueOf(affair_type) == 3) {
					return "加班";
				}
			case 10:
				return affair_start;
			case 11:
				return affair_end;
			case 12:
				return affair_time;
			case 13:
				return reason;
			}
		}
		return null;
	}
	//设置表格的列名
	public final String[] columnName = {"请求编号", "编号", "姓名","学院","专业","教师编号","教师姓名","教师联系电话","教师联系邮箱","请求类型", "请求开始时间","请求结束时间","请求时间","请求原因"};
	public String getColumnName(int column) {
		return columnName[column];
	}
	public Class getColumnClass(int column) {
		return java.lang.String.class;	
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
        return rowIndex == oldrownumber && columnIndex != 0 && columnIndex != 2 && columnIndex != 3 && columnIndex != 4 && columnIndex != 5 && columnIndex != 6 && columnIndex != 7 && columnIndex != 8 && columnIndex != 12;
    }
	public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
        // 设置新的单元格数据时，必须把新值设置到原数据数值中，
//        // 待更新UI重新调用 getValueAt(...) 获取单元格值时才能获取到最新值
		switch(columnIndex) {
		case 1:
			teacher_no = (String) newValue;
			break;
		case 9:
			if(newValue.equals("出差")) {
				affair_type = "1";
			}else if(newValue.equals("请假")) {
				affair_type = "2";
			}else if(newValue.equals("加班")) {
				affair_type = "3";
			}
			break;
		case 10:
			affair_start = (String) newValue;
			break;
		case 11:
			affair_end = (String) newValue;
			break;
		case 13:
			reason = (String) newValue;
			break;
		}
		// 设置完数据后，必须通知表格去更新UI（重绘单元格），否则显示的数据不会改变
		fireTableCellUpdated(rowIndex, columnIndex);
    }
}
