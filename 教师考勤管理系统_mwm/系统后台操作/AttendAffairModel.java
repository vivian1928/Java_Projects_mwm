package 系统后台操作;

import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import 教师考勤管理系统界面.TeacherJF;

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
			count = TeacherJF.rsCount.getInt("行数");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return count;
	}
	//表格的行数
	public int getRowCount() {return rowCount();}
	//表格的列数
	public int getColumnCount() {return 9;}
	
	public Object getValueAt(int row, int col) {
		switch(col) {
		case 0:
			if(row < count) {
				if(Integer.valueOf(TeacherJF.a_type.get(row)) == 1) {
					return "出差";
				}else if(Integer.valueOf(TeacherJF.a_type.get(row)) == 2) {
					return "请假";
				}else if(Integer.valueOf(TeacherJF.a_type.get(row)) == 3) {
					return "加班";
				}
			}else {
				if(Integer.valueOf(TeacherJF.a_type.get(row)) == 1) {
					return "修改个人信息";
				}else if(Integer.valueOf(TeacherJF.a_type.get(row)) == 2) {
					return "修改考勤信息";
				}else if(Integer.valueOf(TeacherJF.a_type.get(row)) == 3) {
					return "修改请求信息";
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
				return "未审核";
			}else {
				return "已通过";
			}
		}
		return null;
	}
	//设置表格的列名
	public final String[] columnName = {"事件类型","开始时间", "结束时间","原因","管理员编号","管理员姓名","管理员联系电话","管理员联系邮箱","审核状态"};
	public String getColumnName(int column) {
		return columnName[column];
	}
	public Class getColumnClass(int column) {
		return java.lang.String.class;	
	}
}
