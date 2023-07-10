package 系统后台操作;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class ComboBoxNoButton extends JComboBox{
	public ComboBoxNoButton() {
	    super();
	}
	public void updateUI() {
	    super.updateUI();
	    UIManager.put("ComboBox.squareButton", Boolean.FALSE);
	    setUI(new BasicComboBoxUI() {
	      @Override 
	      protected JButton createArrowButton() {
	        JButton b = new JButton();
	        b.setBorder(BorderFactory.createEmptyBorder());
	        b.setVisible(false);
	        return b;
	      }
	    });
	    setBorder(BorderFactory.createEmptyBorder());
	}
}
