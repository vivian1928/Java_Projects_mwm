package ϵͳ��̨����;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ��ʦ���ڹ���ϵͳ����.InfoManagePanel;
import ��ʦ���ڹ���ϵͳ����.RequestRecordPanel;
import ���ݿ����Ӳ���.SqlConnect;

public class AddTableModel2 extends AbstractTableModel{
	public static int oldrownumber = RequestRecordPanel.tModel.getRowCount();	//û�����ǰ������
	public static boolean insert = false;
	public static String request_no = "";
	public static String teacher_no = "�������ʦ���";
	public static String teacher_name = "";
	public static String college_name = "";
	public static String profession_name = "";
	public static String admin_no = "";
	public static String admin_name = "";
	public static String admin_telephone = "";
	public static String admin_mailbox = "";
	public static String request_type = "��������������";
	public static String request_contend = "��������������";
	public static String request_time = "����������ʱ��";
	
	public int rowCount() {
		return oldrownumber + 1;
	}
	//��������
	public int getRowCount() {return rowCount();}
	//��������
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
	//���ñ�������
	public final String[] columnName = {"������","��ʦ���", "��ʦ����","ѧԺ","רҵ","����Ա���","����Ա����", "����Ա��ϵ�绰", "����Ա��ϵ����", "��������","��������","����ʱ��"};
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
        // �����µĵ�Ԫ������ʱ���������ֵ���õ�ԭ������ֵ�У�
//        // ������UI���µ��� getValueAt(...) ��ȡ��Ԫ��ֵʱ���ܻ�ȡ������ֵ
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
		// ���������ݺ󣬱���֪ͨ���ȥ����UI���ػ浥Ԫ�񣩣�������ʾ�����ݲ���ı�
		fireTableCellUpdated(rowIndex, columnIndex);
    }
}
