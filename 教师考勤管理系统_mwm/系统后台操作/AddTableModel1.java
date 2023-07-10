package ϵͳ��̨����;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ��ʦ���ڹ���ϵͳ����.AffairRecordPanel;
import ��ʦ���ڹ���ϵͳ����.AttendRecordPanel;
import ��ʦ���ڹ���ϵͳ����.InfoManagePanel;
import ���ݿ����Ӳ���.SqlConnect;

public class AddTableModel1 extends AbstractTableModel{
	public static int oldrownumber = AffairRecordPanel.tModel.getRowCount();	//û�����ǰ������
	public static boolean insert = false;
	public static String affair_no = "";
	public static String teacher_no = "�������ʦ���";
	public static String teacher_name = "";
	public static String college_name = "";
	public static String profession_name = "";
	public static String admin_no = "";
	public static String admin_name = "";
	public static String admin_telephone = "";
	public static String admin_mailbox = "";
	public static String affair_type = "��������������";
	public static String affair_start = "����������ʼʱ��";
	public static String affair_end = "�������������ʱ��";
	public static String affair_time = "";
	public static String reason = "����������ԭ��";
	
	public int rowCount() {
		return oldrownumber + 1;
	}
	//��������
	public int getRowCount() {return rowCount();}
	//��������
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
				if(affair_type.equals("��������������")) {
					return "��������������";
				}
				else if(Integer.valueOf(affair_type) == 1) {
					return "����";
				}else if(Integer.valueOf(affair_type) == 2) {
					return "���";
				}else if(Integer.valueOf(affair_type) == 3) {
					return "�Ӱ�";
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
	//���ñ�������
	public final String[] columnName = {"������", "���", "����","ѧԺ","רҵ","��ʦ���","��ʦ����","��ʦ��ϵ�绰","��ʦ��ϵ����","��������", "����ʼʱ��","�������ʱ��","����ʱ��","����ԭ��"};
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
        // �����µĵ�Ԫ������ʱ���������ֵ���õ�ԭ������ֵ�У�
//        // ������UI���µ��� getValueAt(...) ��ȡ��Ԫ��ֵʱ���ܻ�ȡ������ֵ
		switch(columnIndex) {
		case 1:
			teacher_no = (String) newValue;
			break;
		case 9:
			if(newValue.equals("����")) {
				affair_type = "1";
			}else if(newValue.equals("���")) {
				affair_type = "2";
			}else if(newValue.equals("�Ӱ�")) {
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
		// ���������ݺ󣬱���֪ͨ���ȥ����UI���ػ浥Ԫ�񣩣�������ʾ�����ݲ���ı�
		fireTableCellUpdated(rowIndex, columnIndex);
    }
}
