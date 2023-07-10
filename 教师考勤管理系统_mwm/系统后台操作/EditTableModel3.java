package ϵͳ��̨����;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.table.AbstractTableModel;

import ��ʦ���ڹ���ϵͳ����.Admin;
import ��ʦ���ڹ���ϵͳ����.Confirm;
import ��ʦ���ڹ���ϵͳ����.RequestRecordPanel;
import ���ݿ����Ӳ���.SqlConnect;

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
	//��������
	public int getRowCount() {return rowCount();}
	//��������
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
	//���ñ�������
	public final String[] columnName = {"������","��ʦ���", "��ʦ����","ѧԺ","רҵ","����Ա���","����Ա����", "����Ա��ϵ�绰", "����Ա��ϵ����", "��������","��������","����ʱ��"};
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
        // �����µĵ�Ԫ������ʱ���������ֵ���õ�ԭ������ֵ�У�
//        // ������UI���µ��� getValueAt(...) ��ȡ��Ԫ��ֵʱ���ܻ�ȡ������ֵ
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
					confirm = new Confirm("�����޸���Ч���������޸ģ�");
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
					confirm = new Confirm("�����޸���Ч���������޸ģ�");
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
					confirm = new Confirm("�����޸���Ч���������޸ģ�");
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
        // ���������ݺ󣬱���֪ͨ���ȥ����UI���ػ浥Ԫ�񣩣�������ʾ�����ݲ���ı�
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
