package 系统后台操作;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.table.AbstractTableModel;

import 教师考勤管理系统界面.AttendRecordPanel;
import 教师考勤管理系统界面.Confirm;
import 教师考勤管理系统界面.InfoManagePanel;
import 数据库连接操作.SqlConnect;

public class EditTableModel1 extends AbstractTableModel{

	public static String teacher_no = "";
	public static String rstart = "";
	public static String rend = "";
	public static String consequence = "";
	private JudgeTime judgetime = new JudgeTime();
	private Confirm confirm;
	
	public int rowCount() {
		return AttendRecordPanel.tModel.getRowCount();
	}
	//表格的行数
	public int getRowCount() {return rowCount();}
	//表格的列数
	public int getColumnCount() {return 7;}
	
	public Object getValueAt(int row, int col) {
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
        return columnIndex != 0 && columnIndex != 1 && columnIndex != 2 && columnIndex != 3 && columnIndex != 6;
    }
	public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
        // 设置新的单元格数据时，必须把新值设置到原数据数值中，
//        // 待更新UI重新调用 getValueAt(...) 获取单元格值时才能获取到最新值
			String teacher_no = AttendRecordPanel.teacher_no.get(rowIndex);
			String rstart = AttendRecordPanel.rstart.get(rowIndex);
			String rend = AttendRecordPanel.rend.get(rowIndex);
			String consequence = AttendRecordPanel.consequence.get(rowIndex);
			String sql_1 = null;
			switch(columnIndex) {
			case 4:
				if(!judgetime.judge((String)newValue, rend)) {
					confirm = new Confirm("您的修改无效，请重新修改！");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}else {
					if(!judgetime.judge((String)newValue, ((String)newValue).substring(0, 10) + " 08:00:00") || !judgetime.judge(rend, rend.substring(0, 10) + " 12:00:00") && !judgetime.judge((String)newValue, ((String)newValue).substring(0, 10) + " 14:30:00")) {
						if(consequence == null || !(consequence.equals("缺席"))) {
							consequence = "迟到";
						}
					}
					sql_1 = "update attendMWM set rstart = ";
					sql_1 += "\'"+ newValue +"\', ";
					sql_1 += "consequence = \'"+ consequence +"\' ";
					sql_1 += "where teacher_no = ";	 
					sql_1 += "\'"+ teacher_no +"\' and ";
					sql_1 += "rstart = \'"+ rstart +"\' and ";
					sql_1 += "rend = \'"+ rend +"\'";
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
					AttendRecordPanel.rstart.set(rowIndex, (String) newValue);
					AttendRecordPanel.consequence.set(rowIndex, consequence);
				}
				break;
			case 5:
				if(!judgetime.judge(rstart, (String)newValue)) {
					confirm = new Confirm("您的修改无效，请重新修改！");
					confirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					confirm.setVisible(true);
				}else {
					if(judgetime.judge((String)newValue, ((String)newValue).substring(0, 10) + " 12:00:00") || judgetime.judge(rstart, rend.substring(0, 10) + " 14:30:00") && judgetime.judge((String)newValue, ((String)newValue).substring(0, 10) + " 18:00:00")) {
						if(consequence == null || !(consequence.equals("缺席"))) {
							consequence = "早退";
						}
					}
					sql_1 = "update attendMWM set rend = ";
					sql_1 += "\'"+ newValue +"\', ";
					sql_1 += "consequence = \'"+ consequence +"\' ";
					sql_1 += "where teacher_no = ";	 
					sql_1 += "\'"+ teacher_no +"\' and ";
					sql_1 += "rstart = \'"+ rstart +"\' and ";
					sql_1 += "rend = \'"+ rend +"\'";
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
					AttendRecordPanel.rend.set(rowIndex, (String) newValue);
					AttendRecordPanel.consequence.set(rowIndex, consequence);
				}
				break;
			
			}
        // 设置完数据后，必须通知表格去更新UI（重绘单元格），否则显示的数据不会改变
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
