package 系统后台操作;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

import 教师考勤管理系统界面.AffairRecordPanel;

public class MyTableCellRenderer1 extends DefaultTableCellRenderer {
	/**
	 * 返回默认的表单元格渲染器，此方法在父类中已实现，直接调用父类方法返回，在返回前做相关参数的设置即可
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// 偶数行背景设置为白色，奇数行背景设置为灰色
		if (row == AffairRecordPanel.tModel.getRowCount()) {
			setBackground(Color.ORANGE);
			if (column == 1 || column == 5 || column == 6 || column == 7 || column == 9) {
				setForeground(UIManager.getColor("Button.shadow"));
			}
		}
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
