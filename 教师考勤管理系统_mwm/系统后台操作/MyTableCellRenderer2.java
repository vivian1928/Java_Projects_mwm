package ϵͳ��̨����;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

import ��ʦ���ڹ���ϵͳ����.RequestRecordPanel;

public class MyTableCellRenderer2 extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// ż���б�������Ϊ��ɫ�������б�������Ϊ��ɫ
		if (row == RequestRecordPanel.tModel.getRowCount()) {
			setBackground(Color.ORANGE);
			if (column == 1 || column == 9 || column == 10 || column == 11) {
				setForeground(UIManager.getColor("Button.shadow"));
			}
		}
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
