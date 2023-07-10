package 系统后台操作;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

import 教师考勤管理系统界面.AttendRecordPanel;

public class MyTableCellRenderer extends DefaultTableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// 偶数行背景设置为白色，奇数行背景设置为灰色
		if (row == AttendRecordPanel.tModel.getRowCount()) {
			setBackground(Color.ORANGE);
			if (column == 0 || column == 4 || column == 5) {
				setForeground(UIManager.getColor("Button.shadow"));
			}
		}
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
