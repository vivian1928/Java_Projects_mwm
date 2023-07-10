package ϵͳ��̨����;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.table.AbstractTableModel;

import ��ʦ���ڹ���ϵͳ����.Admin;
import ��ʦ���ڹ���ϵͳ����.AffairRecordPanel;
import ��ʦ���ڹ���ϵͳ����.Confirm;
import ��ʦ���ڹ���ϵͳ����.InfoManagePanel;
import ���ݿ����Ӳ���.SqlConnect;

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
	//��������
	public int getRowCount() {return rowCount();}
	//��������
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
					return "����";
				}else if(Integer.valueOf(AffairRecordPanel.affair_type.get(row)) == 2) {
					return "���";
				}else if(Integer.valueOf(AffairRecordPanel.affair_type.get(row)) == 3) {
					return "�Ӱ�";
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
	//���ñ�������
	public final String[] columnName = {"������", "���", "����","ѧԺ","רҵ","��ʦ���","��ʦ����","��ʦ��ϵ�绰","��ʦ��ϵ����","��������", "����ʼʱ��","�������ʱ��","����ʱ��","����ԭ��"};
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
        // �����µĵ�Ԫ������ʱ���������ֵ���õ�ԭ������ֵ�У�
//        // ������UI���µ��� getValueAt(...) ��ȡ��Ԫ��ֵʱ���ܻ�ȡ������ֵ
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
					confirm = new Confirm("�����޸���Ч���������޸ģ�");
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
					confirm = new Confirm("�����޸���Ч���������޸ģ�");
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
					confirm = new Confirm("�����޸���Ч���������޸ģ�");
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
        // ���������ݺ󣬱���֪ͨ���ȥ����UI���ػ浥Ԫ�񣩣�������ʾ�����ݲ���ı�
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
