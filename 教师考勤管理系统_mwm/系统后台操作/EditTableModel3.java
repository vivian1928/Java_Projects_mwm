package 系统后台操作;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.table.AbstractTableModel;

import 教师考勤管理系统界面.Admin;
import 教师考勤管理系统界面.Confirm;
import 教师考勤管理系统界面.RequestRecordPanel;
import 数据库连接操作.SqlConnect;

public class EditTableModel3 extends AbstractTableModel{

	public static String request_no = "";
	public static String admin_no = "";
	public static String admin_name = "";
	public static String admin_telephone = "";
	public static String admin_mailbox = "";
	public static String request_type = "";
	public static String request_contend = "";
	public static String request_time = "";
	private JudgeTime judgetime = new JudgeTime();
	private Confirm confirm;
	
	public int rowCount() {
		return RequestRecordPanel.tModel.getRowCount();
	}
	//表格的行数
	public int getRowCount() {return rowCount();}
	//表格的列数
	public int getColumnCount() {return 12;}
	
	public Object getValueAt(int row, int col) {
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
        return columnIndex != 0 && columnIndex != 1 && columnIndex != 2 && columnIndex != 3 && columnIndex != 4 && columnIndex != 6 && columnIndex != 7 && columnIndex != 8;
    }
	public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
        // 设置新的单元格数据时，必须把新值设置到原数据数值中，
//        // 待更新UI重新调用 getValueAt(...) 获取单元格值时才能获取到最新值
			String request_no = RequestRecordPanel.request_no.get(rowIndex);
			String admin_no = RequestRecordPanel.admin_no.get(rowIndex);
			String request_type = RequestRecordPanel.request_type.get(rowIndex);
			String request_contend = RequestRecordPanel.request_contend.get(rowIndex);
			String request_time = RequestRecordPanel.request_time.get(rowIndex);
			String sql_1 = null;
			switch(columnIndex) {
			case 5:
				sql_1 = "select admin_name, admin_telephone, admin_mailbox from adminMWM where admin_no = ";
				sql_1 += (String)newValue;
				sql_1 += "\'";
				int count = 0;
				try {
					SqlConnect.ps=SqlConnect.ct.prepareStatement(sql_1);
					SqlConnect.rs=SqlConnect.ps.executeQuery();
					while(SqlConnect.rs.next()) {
						admin_name = SqlConnect.rs.getString(1);
						admin_telephone = SqlConnect.rs.getString(2);
						admin_mailbox = SqlConnect.rs.getString(3);
						count++;
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(count == 0) {
					confirm = new Confirm("您的修改无效，请重新修改！");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}else {
					sql_1 = "update requestMWM set admin_no = ";
					sql_1 += "\'"+ newValue +"\', ";
					sql_1 += "where request_no = ";	 
					sql_1 += "\'"+ request_no +"\'";
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
					RequestRecordPanel.admin_no.set(rowIndex, (String) newValue);
				}
				break;
			case 9:
				if(!((String)newValue).equals("1") && !((String)newValue).equals("2") && !((String)newValue).equals("3")) {
					confirm = new Confirm("您的修改无效，请重新修改！");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}else {
					sql_1 = "update requestMWM set request_type = ";
					sql_1 += newValue;
					sql_1 += "where request_no = ";	 
					sql_1 += "\'"+ request_no +"\'";
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
					RequestRecordPanel.request_type.set(rowIndex, (String) newValue);
				}
				break;
			case 10:
				if(((String)newValue) == null || ((String)newValue).equals("")) {
					confirm = new Confirm("您的修改无效，请重新修改！");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}else {
					sql_1 = "update requestMWM set request_contend = ";
					sql_1 += "\'"+ newValue +"\' ";
					sql_1 += "where request_no = ";	 
					sql_1 += "\'"+ request_no +"\'";
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
					RequestRecordPanel.request_contend.set(rowIndex, (String) newValue);
				}
				break;
			case 11:
				sql_1 = "update requestMWM set request_time = ";
				sql_1 += "\'"+ newValue +"\' ";
				sql_1 += "where request_no = ";	 
				sql_1 += "\'"+ request_no +"\'";
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
				RequestRecordPanel.request_time.set(rowIndex, (String) newValue);
				break;
			}
        // 设置完数据后，必须通知表格去更新UI（重绘单元格），否则显示的数据不会改变
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
