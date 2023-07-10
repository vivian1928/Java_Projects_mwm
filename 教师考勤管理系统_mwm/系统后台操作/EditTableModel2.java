package 系统后台操作;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.table.AbstractTableModel;

import 教师考勤管理系统界面.Admin;
import 教师考勤管理系统界面.AffairRecordPanel;
import 教师考勤管理系统界面.Confirm;
import 教师考勤管理系统界面.InfoManagePanel;
import 数据库连接操作.SqlConnect;

public class EditTableModel2 extends AbstractTableModel{

	public static String affair_no = "";
	public static String affair_type = "";
	public static String affair_start = "";
	public static String affair_end = "";
	public static String affair_time = "";
	public static String reason = "";
	private JudgeTime judgetime = new JudgeTime();
	private Confirm confirm;
	
	public int rowCount() {
		return AffairRecordPanel.tModel.getRowCount();
	}
	//表格的行数
	public int getRowCount() {return rowCount();}
	//表格的列数
	public int getColumnCount() {return 7;}
	
	public Object getValueAt(int row, int col) {
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
        return columnIndex != 0 && columnIndex != 1 && columnIndex != 2 && columnIndex != 3 && columnIndex != 4 && columnIndex != 5 && columnIndex != 6 && columnIndex != 7 && columnIndex != 8 && columnIndex != 12;
    }
	public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
        // 设置新的单元格数据时，必须把新值设置到原数据数值中，
//        // 待更新UI重新调用 getValueAt(...) 获取单元格值时才能获取到最新值
			String affair_no = AffairRecordPanel.affair_no.get(rowIndex);
			String affair_type = AffairRecordPanel.affair_type.get(rowIndex);
			String affair_start = AffairRecordPanel.affair_start.get(rowIndex);
			String affair_end = AffairRecordPanel.affair_end.get(rowIndex);
			String affair_time = AffairRecordPanel.affair_time.get(rowIndex);
			String reason = AffairRecordPanel.reason.get(rowIndex);
			String sql_1 = null;
			switch(columnIndex) {
			case 9:
				if(!((String)newValue).equals("1") || !((String)newValue).equals("2") || !((String)newValue).equals("3")) {
					confirm = new Confirm("您的修改无效，请重新修改！");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}else {
					sql_1 = "update affairMWM set affair_type = ";
					sql_1 += "\'"+ newValue +"\' ";
					sql_1 += "where affair_no = ";	 
					sql_1 += "\'"+ affair_no +"\'";
					try {
						Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						Main.sqlconnect.stmt.executeUpdate(sql_1);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					try {
						Main.sqlconnect.ct.commit();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					AffairRecordPanel.affair_type.set(rowIndex, (String) newValue);
				}
				break;
			case 10:
				if(!judgetime.judge((String)newValue, affair_end)) {
					confirm = new Confirm("您的修改无效，请重新修改！");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}else {
					sql_1 = "update affairMWM set affair_start = ";
					sql_1 += "\'"+ newValue +"\' ";
					sql_1 += "where affair_no = ";	 
					sql_1 += "\'"+ affair_no +"\'";
					try {
						Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						Main.sqlconnect.stmt.executeUpdate(sql_1);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					try {
						Main.sqlconnect.ct.commit();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sql_1 = "select affair_end - affair_start from affairMWM where affair_no = ";
					sql_1 += affair_no;
					sql_1 += "\'";
					try {
						SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
						SqlConnect.rs=SqlConnect.ps.executeQuery();
						
						while(SqlConnect.rs.next()) {
							affair_time=SqlConnect.rs.getString(1);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					AffairRecordPanel.affair_start.set(rowIndex, (String) newValue);
					AffairRecordPanel.affair_time.set(rowIndex, affair_time);
				}
				break;
			case 11:
				if(!judgetime.judge(affair_start, (String)newValue)) {
					confirm = new Confirm("您的修改无效，请重新修改！");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}else {
					sql_1 = "update affairMWM set affair_end = ";
					sql_1 += "\'"+ newValue +"\' ";
					sql_1 += "where affair_no = ";	 
					sql_1 += "\'"+ affair_no +"\'";
					try {
						Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						Main.sqlconnect.stmt.executeUpdate(sql_1);
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					try {
						Main.sqlconnect.ct.commit();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					sql_1 = "select affair_end - affair_start from affairMWM where affair_no = ";
					sql_1 += affair_no;
					sql_1 += "\'";
					try {
						SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
						SqlConnect.rs=SqlConnect.ps.executeQuery();
						
						while(SqlConnect.rs.next()) {
							affair_time=SqlConnect.rs.getString(1);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					AffairRecordPanel.affair_end.set(rowIndex, (String) newValue);
					AffairRecordPanel.affair_time.set(rowIndex, affair_time);
				}
				break;
			case 13:
				sql_1 = "update affairMWM set reason = ";
				sql_1 += "\'"+ newValue +"\' ";
				sql_1 += "where affair_no = ";	 
				sql_1 += "\'"+ affair_no +"\'";
				try {
					Main.sqlconnect.stmt = Main.sqlconnect.ct.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					Main.sqlconnect.stmt.executeUpdate(sql_1);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				try {
					Main.sqlconnect.ct.commit();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				AffairRecordPanel.reason.set(rowIndex, (String) newValue);
				break;
			}
        // 设置完数据后，必须通知表格去更新UI（重绘单元格），否则显示的数据不会改变
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
