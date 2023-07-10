package ϵͳ��̨����;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

import ��ʦ���ڹ���ϵͳ����.AttendRecordPanel;

public class MyTableCellRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// ż���б�������Ϊ��ɫ�������б�������Ϊ��ɫ
		if (row == AttendRecordPanel.tModel.getRowCount()) {
			setBackground(Color.ORANGE);
			if (column == 0 || column == 4 || column == 5) {
				setForeground(UIManager.getColor("Button.shadow"));
			}
		}
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
