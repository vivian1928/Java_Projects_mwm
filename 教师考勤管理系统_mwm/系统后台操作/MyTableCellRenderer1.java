package ϵͳ��̨����;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

import ��ʦ���ڹ���ϵͳ����.AffairRecordPanel;

public class MyTableCellRenderer1 extends DefaultTableCellRenderer {
	/**
	 * ����Ĭ�ϵı�Ԫ����Ⱦ�����˷����ڸ�������ʵ�֣�ֱ�ӵ��ø��෽�����أ��ڷ���ǰ����ز��������ü���
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// ż���б�������Ϊ��ɫ�������б�������Ϊ��ɫ
		if (row == AffairRecordPanel.tModel.getRowCount()) {
			setBackground(Color.ORANGE);
			if (column == 1 || column == 5 || column == 6 || column == 7 || column == 9) {
				setForeground(UIManager.getColor("Button.shadow"));
			}
		}
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
