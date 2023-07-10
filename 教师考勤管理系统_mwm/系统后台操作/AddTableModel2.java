package 系统后台操作;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import 教师考勤管理系统界面.InfoManagePanel;
import 教师考勤管理系统界面.RequestRecordPanel;
import 数据库连接操作.SqlConnect;

public class AddTableModel2 extends AbstractTableModel{
	public static int oldrownumber = RequestRecordPanel.tModel.getRowCount();	//没有添加前的行数
	public static boolean insert = false;
	public static String request_no = "";
	public static String teacher_no = "请输入教师编号";
	public static String teacher_name = "";
	public static String college_name = "";
	public static String profession_name = "";
	public static String admin_no = "";
	public static String admin_name = "";
	public static String admin_telephone = "";
	public static String admin_mailbox = "";
	public static String request_type = "请输入申请类型";
	public static String request_contend = "请输入申请内容";
	public static String request_time = "请输入请求时间";
	
	public int rowCount() {
		return oldrownumber + 1;
	}
	//表格的行数
	public int getRowCount() {return rowCount();}
	//表格的列数
	public int getColumnCount() {return 12;}
	
	public Object getValueAt(int row, int col) {
		if(row < oldrownumber) {
			switch(col) {
			case 0:
				return RequestRecordPanel.request_no.get(row);
			case 1:
				return RequestRecordPanel.teacher_no.get(row);
			case 2:
				return RequestRecordPanel.teacher_name.get(row);
			case 3:
				return RequestRecordPanel.college_name.get(row);
			case 4:
				return RequestRecordPanel.profession_name.get(row);
			case 5:
				return RequestRecordPanel.admin_no.get(row);
			case 6:
				return RequestRecordPanel.admin_name.get(row);
			case 7:
				return RequestRecordPanel.admin_telephone.get(row);
			case 8:
				return RequestRecordPanel.admin_mailbox.get(row);
			case 9:
				return RequestRecordPanel.request_type.get(row);
			case 10:
				return RequestRecordPanel.request_contend.get(row);
			case 11:
				return RequestRecordPanel.request_time.get(row);
			}
		}else {
			switch(col) {
			case 0:
				return request_no;
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
				return request_type;
			case 10:
				return request_contend;
			case 11:
				return request_time;
			}
		}
		return null;
	}
	//设置表格的列名
	public final String[] columnName = {"申请编号","教师编号", "教师姓名","学院","专业","管理员编号","管理员姓名", "管理员联系电话", "管理员联系邮箱", "申请类型","申请内容","申请时间"};
	public String getColumnName(int column) {
		return columnName[column];
	}
	public Class getColumnClass(int column) {
		return java.lang.String.class;	
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
        return rowIndex == oldrownumber && columnIndex != 0 && columnIndex != 2 && columnIndex != 3 && columnIndex != 4 && columnIndex != 5 && columnIndex != 6 && columnIndex != 7 && columnIndex != 8;
    }
	public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
        // 设置新的单元格数据时，必须把新值设置到原数据数值中，
//        // 待更新UI重新调用 getValueAt(...) 获取单元格值时才能获取到最新值
		switch(columnIndex) {
		case 1:
			teacher_no = (String) newValue;
			break;
		case 9:
			request_type = (String) newValue;
			break;
		case 10:
			request_contend = (String) newValue;
			break;
		case 11:
			request_time = (String) newValue;
			break;
		}
		// 设置完数据后，必须通知表格去更新UI（重绘单元格），否则显示的数据不会改变
		fireTableCellUpdated(rowIndex, columnIndex);
    }
}
