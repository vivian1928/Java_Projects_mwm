package ϵͳ��̨����;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import ��ʦ���ڹ���ϵͳ����.AttendRecordPanel;
import ��ʦ���ڹ���ϵͳ����.InfoManagePanel;
import ���ݿ����Ӳ���.SqlConnect;

public class AddTableModel extends AbstractTableModel{
	public static int oldrownumber = AttendRecordPanel.tModel.getRowCount();	//û�����ǰ������
	public static boolean insert = false;
	public static String teacher_no = "�������ʦ���";
	public static String teacher_name = "";
	public static String college_name = "";
	public static String profession_name = "";
	public static String rstart = "�������ϰ��ʱ��";
	public static String rend = "�������°��ʱ��";
	public static String consequence = "";
	
	public int rowCount() {
		return oldrownumber + 1;
	}
	//��������
	public int getRowCount() {return rowCount();}
	//��������
	public int getColumnCount() {return 7;}
	
	public Object getValueAt(int row, int col) {
		if(row < oldrownumber) {
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
		}else {
			switch(col) {
			case 0:
				return teacher_no;
			case 1:
				return teacher_name;
			case 2:
				return college_name;
			case 3:
				return profession_name;
			case 4:
				return rstart;
			case 5:
				return rend;
			case 6:
				return consequence;
			}
		}
		return null;
	}
	//���ñ�������
	public final String[] columnName = {"���", "����","ѧԺ","רҵ","�ϰ��ʱ��","�°��ʱ��","�������"};
	public String getColumnName(int column) {
		return columnName[column];
	}
	public Class getColumnClass(int column) {
		return java.lang.String.class;	
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
        return rowIndex == oldrownumber && columnIndex != 1 && columnIndex != 2 && columnIndex != 3 && columnIndex != 6;
    }
	public void setValueAt(Object newValue, int rowIndex, int columnIndex) {
        // �����µĵ�Ԫ������ʱ���������ֵ���õ�ԭ������ֵ�У�
//        // ������UI���µ��� getValueAt(...) ��ȡ��Ԫ��ֵʱ���ܻ�ȡ������ֵ
		switch(columnIndex) {
		case 0:
			teacher_no = (String) newValue;
			break;
		case 4:
			rstart = (String) newValue;
			break;
		case 5:
			rend = (String) newValue;
			break;
		}
		// ���������ݺ󣬱���֪ͨ���ȥ����UI���ػ浥Ԫ�񣩣�������ʾ�����ݲ���ı�
		fireTableCellUpdated(rowIndex, columnIndex);
    }
}
